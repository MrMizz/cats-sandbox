package sandbox.chapters.two

final case class Order(totalCost: Double, quantity: Double)

object Order {

  implicit val orderMonoid: cats.Monoid[Order] = new cats.Monoid[Order] {

    override def combine(x: Order, y: Order): Order = {
      val newTotalCost = (x.totalCost * x.quantity) + (y.totalCost * x.quantity)
      Order(totalCost = newTotalCost, quantity = 1d)
    }

    override def empty: Order = Order(totalCost = 0d, quantity = 1d)

  }

}
