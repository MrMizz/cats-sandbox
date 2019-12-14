package sandbox.chapters.one

import cats.Show
import cats.Eq
import cats.syntax.show._
import cats.syntax.eq._
import cats.instances.int._
import cats.instances.string._

final case class Cat(
                      name: String,
                      age: Int,
                      color: String
                    )

object Cat {

  import PrintableInstances._

  implicit val printable: Printable[Cat] = new Printable[Cat] {
    override def format(cat: Cat): String = {
      val name: String = Printable.format(cat.name)
      val age: String = Printable.format(cat.age)
      val color: String = Printable.format(cat.color)
      s"$name is a $age year-old $color cat."
    }
  }

  implicit val show: Show[Cat] = Show.show[Cat] { cat =>
    val name: String = cat.name.show
    val age: String = cat.age.show
    val color: String = cat.color.show
    s"$name is a $age year-old $color cat."
  }

  implicit val eq: Eq[Cat] = Eq.instance[Cat] { (left, right) =>
    val sameName: Boolean = left.name === right.name
    val sameAge: Boolean = left.age === right.age
    val sameColor: Boolean = left.color === right.color
    sameName && sameAge && sameColor
  }

}

