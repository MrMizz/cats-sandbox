package sandbox.chapters.two.instances

import sandbox.chapters.two.Monoid

object MonoidInstances {

  implicit val booleanMonoid: Monoid[Boolean] = new Monoid[Boolean] {

    override def combine(x: Boolean, y: Boolean): Boolean = {
      x && y
    }

    override def empty: Boolean = true

  }

}
