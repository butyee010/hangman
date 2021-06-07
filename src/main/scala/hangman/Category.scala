package hangman


trait Category

object Category {

  val fruit: List[String] = List("apples", "oranges", "pears", "durian", "rambutan")
  val mobiles: List[String] = List("nokia3310", "iphone12", "motorola", "ipad", "blackberry")

  val categoryMap = Map(1 -> ("fruit", fruit), 2 -> ("mobiles", mobiles))
}
