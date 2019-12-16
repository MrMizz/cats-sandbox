package sandbox.chapters.two

object SuperAdder {

  def add[A](list: List[A])(implicit monoid: cats.Monoid[A]): A = {
    list.foldRight(monoid.empty)((left, right) => monoid.combine(left, right))
  }

}
