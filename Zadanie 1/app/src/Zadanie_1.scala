package app

object Zadanie_1 extends cask.MainRoutes{

  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  @cask.get("/")
  def helloWorld() ={
    "Hello World!"
  }

  @cask.postJson("/is-sorted")
  def isSorted(list: Seq[Int], order: String) = {
    def f(list: Seq[Int], order: String) = {
      var sorted = true
      var a = list(0)
      for (i <- list) {
        if (a <= i && sorted && order == "asc") {
          sorted = true
          a = i
        }
        else if (a >= i && sorted && order == "desc"){
          sorted = true
          a = i
        }
        else {
          sorted = false
        }
      }
      sorted
    }

    var sorted = true
    if (list.length <= 1) {
      sorted = true
    }
    else {
      sorted = f(list, order)
    }
    ujson.Obj(
      "isSorted" -> sorted
    )
  }

  @cask.postJson("/sum-lists")  
  def sumLists(list1: Seq[Int], list2: Seq[Int], list3: Seq[Int]) = {
    def g(a: Seq[Int], b: Seq[Int]) = {
      a.zipAll(b, 0, 0).map {case (x, y) => x + y}
    }

    ujson.Obj(
      "list" -> g(g(list1, list2), list3)
    )
  }

  @cask.postJson("/set-head")
  def setHead(e: ujson.Value, list: Seq[ujson.Value]) = {
    var out = e +: list
    ujson.Obj(
      "list" -> out
    )
  }

  @cask.postJson("/append")
  def append(e: ujson.Value, index: Int, list: Seq[ujson.Value]) = {
    var (split1, split2) = list.splitAt(index)
    var out = split1 ++ List(e) ++ split2
    ujson.Obj(
      "list" -> out
    )
  }

  @cask.postJson("/square-lists")
  def squareLists(list1: Seq[Int], list2: Seq[Int]) = {
    ujson.Obj(
      "list" -> list1.zipAll(list2, 0, 0).map {case (x,y) => List(x*x , y*y)}
    )
  }

  initialize()
}