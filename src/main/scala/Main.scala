
import hangman.GameState.initGame
import hangman.{Category, GameState, Guesses, Word}

import scala.io.StdIn.readLine


object Main {

  def main(args: Array[String]): Unit = {
    var categorySelected: String = ""
    val categoryObject = Category
    do {
      println("Select Category:")
      for ((index, category) <- categoryObject.categoryMap) {
        println(index + ": " + category._1)
      }
      categorySelected = readLine("> ")
    } while (!categoryObject.categoryMap.contains(categorySelected.toInt))

    val categoryListSelected = categoryObject.categoryMap(categorySelected.toInt)
    val answer: String = Word.getRandomWord(categoryListSelected._2)
    val gameState = GameState(answer)
    var letterList: List[Char] = List.empty
    var wrongLetterList: List[Char] = List.empty

    var guessesWord = initGame(gameState)
    println(guessesWord)
    do {
      val inputLetter = readLine("> ")
      if (inputLetter.length == 1) {
        val guesses = Guesses(inputLetter.charAt(0), guessesWord)
        if (GameState.guessesCorrect(guesses, gameState, letterList)) {
          guessesWord = Guesses.guessesWord(guesses, answer)
          letterList = Word.addLetter(inputLetter.charAt(0), letterList)
        }
        else {
          wrongLetterList = Word.addLetter(inputLetter.charAt(0), wrongLetterList)
          println("wrong guesses: " + wrongLetterList.mkString(" "))
        }
        println(guessesWord)
      }
    } while (GameState.gameAlive(guessesWord, gameState))
  }
}