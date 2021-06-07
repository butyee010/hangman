package hangman

import scala.util.Random

trait Word

object Word {
  val random: Random.type = Random

  def getRandomWord(list: List[String]): String = list(random.nextInt(list.length))

  def maskUnderscoreWord(word: String): String = {
    var wordMask = word.flatMap(f => {
      if (f.toString.matches("[a-zA-Z]")) "_"
      else f.toString
    })
    wordMask = removeSpace(wordMask)
    addSpace(wordMask)
  }

  def removeSpace(word: String): String = word.replaceAll(" ", "")

  def addSpace(word: String): String = word.mkString(" ")

  def letterInWord(letter: Char, word: String): Boolean = word.contains(letter)

  def addLetter(inputLetter: Char, letterList: List[Char]): List[Char] = {
    if (letterList.contains(inputLetter)) letterList
    else letterList :+ inputLetter
  }
}
