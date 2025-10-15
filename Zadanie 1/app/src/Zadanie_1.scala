package app

object Zadanie_1 extends cask.MainRoutes{

  @cask.get("/")
  def helloWorld() ={
    "Hello World!"
  }

  @cask.postJson("/is-sorted")
  def isSorted(list: Seq[Int]) = {
    def f(list: Seq[Int], bool: Boolean) = {
      var sorted = bool
      var a = list(0)
      for (i <- list) {
        if (a <= i)
        {
          if (sorted == true) {
            sorted = true
            a = i
          }
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
      sorted = f(list, sorted)
      if (sorted == false) {
        sorted = true
        sorted = f(list.reverse, sorted)
      }
    }
    ujson.Obj(
      "isSorted" -> sorted
    )
  }

  @cask.postJson("/json")
  def jsonEndpointObj(value1: ujson.Value, value2: Seq[Int]) = {
    ujson.Obj(
      "value1" -> value1,
      "value2" -> value2
    )
  }

  initialize()
}