package sandbox.chapters.two

trait Semigroup[A] {
  def combine(x: A, y: A): A
}
