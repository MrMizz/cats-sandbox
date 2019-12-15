package sandbox.chapters.two

object Entry extends App{

  import instances.MonoidInstances._
  import syntax.MonoidSyntax._
  assert(true combine true)
  assert(true combine implicitly[Monoid[Boolean]].empty)

}
