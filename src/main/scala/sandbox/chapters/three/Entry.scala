package sandbox.chapters.three

import sandbox.chapters.three.TreeADT._
import sandbox.chapters.three.instances.FunctorInstances._
import cats.syntax.functor._

object Entry extends App {

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

  println(tree.map(x => x + 1).map(x => x - 2))

}
