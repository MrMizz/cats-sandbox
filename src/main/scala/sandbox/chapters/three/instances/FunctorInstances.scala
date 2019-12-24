package sandbox.chapters.three.instances

import cats.Functor
import sandbox.chapters.three.TreeADT._

object FunctorInstances {

  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {
    override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = {
      fa match {
        case Branch(left, right) =>
          Branch(map(left)(f), map(right)(f))
        case Leaf(value) =>
          Leaf(f(value))
      }
    }
  }

}
