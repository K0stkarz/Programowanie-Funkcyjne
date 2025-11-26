package app

object Zadanie_1 extends cask.MainRoutes{

  override def host: String = "0.0.0.0"
  override def port: Int = 8080

  @cask.get("/")
  def helloWorld() = {
    "Hello World!"
  }

  initialize()
}