package sandbox.chapters.two.syntax

import sandbox.chapters.two.Monoid

object MonoidSyntax {

  implicit class MonoidOps[A](left: A) {

    def combine(right: A)(implicit monoid: Monoid[A]): A = {
      monoid.combine(left, right)
    }

  }


}
