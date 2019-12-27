package sandbox.chapters.four

object Entry extends App {

  println(FoldRight((1 to 100000).toList, 0L)(_ + _))

}
