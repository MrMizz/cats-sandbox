package sandbox.chapters.four.instances

import cats.Monad
import sandbox.chapters.three.TreeADT._

object MonadInstances {

  implicit val treeMonad: Monad[Tree] = new Monad[Tree] {

    override def pure[A](x: A): Tree[A] = {
      Tree(x)
    }

    override def flatMap[A, B](fa: Tree[A])(f: A => Tree[B]): Tree[B] = {
      fa match {
        case Branch(left, right) =>
          Branch(flatMap(left)(f), flatMap(right)(f))
        case Leaf(value) =>
          f(value)
      }
    }

    override def tailRecM[A, B](a: A)(f: A => Tree[Either[A, B]]): Tree[B] = {
      flatMap(f(a)) {
        case Left(a) => tailRecM(a)(f)
        case Right(b) => Tree(b)
      }
    }

  }

}
