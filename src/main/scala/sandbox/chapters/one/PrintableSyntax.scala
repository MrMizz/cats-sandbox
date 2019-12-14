package sandbox.chapters.one

object PrintableSyntax {

  implicit class PrintableOps[A](a: A) {

    def format(implicit printable: Printable[A]): String = {
      printable.format(a)
    }

    def print(implicit printable: Printable[A]): Unit = {
      println(format)
    }

  }

}
