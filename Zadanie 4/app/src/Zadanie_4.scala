package app

object Zadanie_1 extends cask.MainRoutes{

  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  @cask.get("/")
  def helloWorld() = {
    "Hello World!"
  }

  @cask.postJson("/append")
  def append(e: ujson.Value, index: Option[Int] = None, list: Option[Seq[ujson.Value]] = None) = {
    val new_list = list.getOrElse(Seq.empty)
    val new_index = index.getOrElse(new_list.length)
    
    var (split1, split2) = new_list.splitAt(new_index)
    var out = split1 ++ List(e) ++ split2
    ujson.Obj(
      "list" -> out
    )
  }

  @cask.postJson("/variance")
  def variance(list: Option[Seq[ujson.Value]] = None) = {
    var result: ujson.Value = ujson.Null
    if (list != None) {
      val nums = list.get.map(_.num)
      val mean = nums.sum / nums.size
      val variance = nums.map(x => math.pow(x - mean, 2)).sum / nums.size
      result = ujson.Num(variance)
    }
    ujson.Obj(
      "variance" -> result
    )
  }

  initialize()
}