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

  initialize()
}