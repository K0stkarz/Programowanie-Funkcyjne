package app

object Zadanie_3 extends cask.MainRoutes{

  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  @cask.get("/")
  def helloWorld() ={
    "Hello World!"
  }

  @cask.postJson("/get-tail")
  def getTail(list: Seq[ujson.Value]) = {
    val myList = SingleList(list: _*)
    val tail = myList.tail

    ujson.Obj(
      "tail" -> tail.toSeq
    )
  }

  initialize()
}