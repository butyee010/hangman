package hangman

case class GameState(answer: String)

object GameState {
  val live: Live.type = Live
  var score: Int = 0

  def initGame(gameState: GameState): String = Word.maskUnderscoreWord(gameState.answer)

  def isAlreadyLetter(letter: Char, letterList: List[Char]): Boolean = letterList.contains(letter)

  def guessesCorrect(guesses: Guesses, gameState: GameState, letterList: List[Char]): Boolean = {
    if (isAlreadyLetter(guesses.letter, letterList)) return false

    if (Word.letterInWord(guesses.letter, gameState.answer)) {
      score = score + 5
      println("you score: " + score +" point")
      return true
    }
    else {
      println(live.countDownLivePiece())
      println("you live: " + live.live)
    }
    false
  }

  def gameAlive(guessesWord: String, gameState: GameState): Boolean = {
    var alive = true
    if (win(guessesWord, gameState.answer)) {
      alive = false
      println("you win")
    }
    if (lose(live.live)) {
      alive = false
      println("you lose and answer is \""+ gameState.answer + "\"")
    }
    if (!alive)
      println("total score: " + score +" point")
    alive
  }

  def lose(live: Int): Boolean = live == 0

  def win(guessesWord: String, answer: String): Boolean = Word.removeSpace(guessesWord) == Word.removeSpace(answer)

}