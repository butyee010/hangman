package hangman


case class Guesses(letter: Char, word: String)

object Guesses {

  def guessesWord(guesses: Guesses, answer: String): String = {
    val wordCharArray = Word.removeSpace(guesses.word).toCharArray
    answer.zipWithIndex.foreach(f => {
      if (f._1.toLower == guesses.letter.toLower) wordCharArray.update(f._2, f._1)
    })
    Word.addSpace(wordCharArray.mkString)
  }
}