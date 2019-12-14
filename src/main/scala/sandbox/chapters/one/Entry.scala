package sandbox.chapters.one

object Entry extends App {

  val cat = Cat(name = "Oscar", age = 9, color = "mixto")
  Printable.print(cat)

  import PrintableSyntax._
  cat.print

  import cats.syntax.show._
  println(cat.show)


  val cat1 = Cat("Garfield",   38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")
  val optionCat1 = Option(cat1)
  val optionCat2 = Option.empty[Cat]
  import cats.syntax.eq._
  assert(cat1 =!= cat2)
  import cats.instances.option._
  assert(optionCat1 =!= optionCat2)

}
