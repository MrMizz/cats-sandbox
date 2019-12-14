package sandbox.chapters.one

object PrintableInstances {

  implicit val printableString: Printable[String] = new Printable[String] {
    override def format(str: String): String = str
  }

  implicit val printableInt: Printable[Int] = new Printable[Int] {
    override def format(int: Int): String = int.toString
  }

}
