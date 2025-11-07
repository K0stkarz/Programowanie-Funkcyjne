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

  @cask.postJson("/drop-n")
  def dropN(n: Int, list: Seq[ujson.Value]) = {
    val myList = DoubleList(list: _*)
    val dropped = myList.drop(n)

    ujson.Obj(
      "dropped" -> dropped.toSeq
    )
  }

  @cask.postJson("/drop-while")
  def dropWhile(predicate: String, list: Seq[ujson.Value]) = {
    val myList = DoubleList(list: _*)
    val dropped = myList.dropWhile(predicate)

    ujson.Obj(
      "dropped" -> dropped.toSeq
    )
  }

  initialize()
}