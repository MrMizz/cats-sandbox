package sandbox.chapters.four

import cats.Eval

object FoldRight {

  def apply[A, B](as: List[A], acc: B)(fn: (A, B) => B): B = {

    val lift: (A, Eval[B]) => Eval[B] = {
      (a: A, evalB: Eval[B]) =>
        evalB.map { bValue =>
          fn(a, bValue)
        }
    }

    safe(as, Eval.now(acc))(lift).value
  }

  private def safe[A, B](as: List[A], acc: Eval[B])(fn: (A, Eval[B]) => Eval[B]): Eval[B] = {
    as match {
      case head :: tail =>
        Eval.now(head).flatMap { a =>
          fn(a, safe(tail, acc)(fn))
        }
      case Nil =>
        acc
    }
  }

}
