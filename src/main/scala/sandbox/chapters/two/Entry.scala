package sandbox.chapters.two

object Entry extends App{

  import instances.MonoidInstances._
  import syntax.MonoidSyntax._
  assert(true combine true)
  assert(true combine implicitly[Monoid[Boolean]].empty)

  import cats.instances.int._
  val intList = List(1, 1, 2, 3)
  assert(SuperAdder.add(intList) == 7)

  import cats.instances.option._
  val intOptionList = List(Some(1), None, Some(2))
  assert(SuperAdder.add(intOptionList) == Option(3))

  val order1 = Order(totalCost = 20d, quantity = 1d)
  val order2 = Order(totalCost = 10d, quantity = 2d)
  assert(SuperAdder.add(List(order1, order2)) == Order(totalCost = 40d, quantity = 1d))

}
