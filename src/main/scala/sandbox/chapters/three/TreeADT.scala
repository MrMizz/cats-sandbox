package sandbox.chapters.three

object TreeADT {

  sealed trait Tree[+A]

  final case class Branch[A](left: Tree[A], right: Tree[A])
    extends Tree[A]

  final case class Leaf[A](value: A) extends Tree[A]

  object Tree {

    def apply[A](value: A): Tree[A] = {
      Leaf(value)
    }

    def apply[A](leftValue: A)(rightValue: A): Branch[A] = {
      Branch(left = Tree(leftValue), right = Tree(rightValue))
    }

  }

}
