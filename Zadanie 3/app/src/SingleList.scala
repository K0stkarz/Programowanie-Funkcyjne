package app

sealed trait SingleList[+A] {
    def tail: SingleList[A] = this match {
        case Nil => Nil
        case Node(_, t) => t
    }

    def toSeq: Seq[A] = this match {
        case Nil => Seq.empty
        case Node(h, t) => h +: t.toSeq
    }
}

case object Nil extends SingleList[Nothing]
case class Node[+A](head: A, rest: SingleList[A]) extends SingleList[A]

object SingleList {
    def apply[A](next: A*): SingleList[A] = {
        if (next.isEmpty) Nil
        else Node(next.head, apply(next.tail: _*))
    }
}