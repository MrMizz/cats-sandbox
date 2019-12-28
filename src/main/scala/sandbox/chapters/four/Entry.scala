package sandbox.chapters.four

import sandbox.chapters.three.TreeADT._

object Entry extends App {

  println(FoldRight((1 to 100000).toList, 0L)(_ + _))

  val tree: Tree[Int] = Branch[Int](
    left = Branch(
      left = Branch(
        left = Leaf(10),
        right = Leaf(20)
      ),
      right = Leaf(5)
    ),
    right = Leaf(25)
  )

  import instances.MonadInstances._
  import cats.syntax.functor._
  import cats.syntax.flatMap._
  println(tree.map(_ + 10))
  val x: Tree[Int] = for {
    tree1 <- tree.map(_ + 1)
    tree2 <- tree.map(_ + 2)
  } yield {
    tree1 + tree2
  }
  println(x)

}
