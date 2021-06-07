package hangman

trait Live

object Live {
  var max = 5
  var live: Int = max
  var currentLivePiece = 0
  val livePieces: Array[String] =
    """||--|
       || (-)
       || /|\
       ||  |
       || / \""".stripMargin.split("\n")

  def countDownLivePiece(): String = {
    currentLivePiece = currentLivePiece + 1
    live = live - 1
    var response = ""
    livePieces.slice(0, max - live).reverse.foreach(f => response = f + "\n" + response)
    response
  }
}

