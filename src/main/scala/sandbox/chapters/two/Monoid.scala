package sandbox.chapters.two

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Monoid {

  def combine[A](left: A, right: A)(implicit monoid: Monoid[A]): A = {
    monoid.combine(left, right)
  }

}

