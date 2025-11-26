package app

object Zadanie_1 extends cask.MainRoutes{

  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  @cask.get("/")
  def helloWorld() = {
    "Hello World!"
  }

  @cask.postJson("/count-numbers")
  def countNumbers(list: Seq[ujson.Value]) = {
    def mapReduce(list: Seq[ujson.Value]) = {
      val mapped = list.map(number => (number, 1))
      val reduced = mapped.groupBy(tuple => tuple._1)
      val counts = reduced.mapValues(_.size)
      counts
    }

    val result = mapReduce(list)

    ujson.Obj(
      "counts" -> result.map{ case (k, v) => (k.toString(), ujson.Num(v))}
    )
  }

  @cask.postJson("/qube-numbers")
  def qubeNumbers(list: Seq[ujson.Value]) = {
    def mapReduce(list: Seq[ujson.Value]) = {
      val mapped = list.map(number => {
        val num = number.num.toDouble
        (number, num * num * num)
      })
      val reduced = mapped.groupBy(tuple => tuple._1)
      reduced
    }
    val result = mapReduce(list)
    ujson.Obj(
      "qubes" -> result.map{ case (k, v) => (k.toString(), ujson.Num(v.head._2))}
    )
  }

    @cask.postJson("/student-hours")
  def studentHours(list: Seq[ujson.Value]) = {
    def mapReduce(list: Seq[ujson.Value]) = {
      val mapped = list.map(student => {
        val name = student("student").str
        val hours = student("hours").num
        (name, hours)
      })
      val reduced = mapped.groupBy(tuple => tuple._1)
      val totalHours = reduced.mapValues(_.map(_._2).sum)
      totalHours
    }
    val result = mapReduce(list)

    ujson.Obj(
      "total_hours" -> result.map{ case (k, v) => (k, ujson.Num(v))}
    )
  }

  initialize()
}