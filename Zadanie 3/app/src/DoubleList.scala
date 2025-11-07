package app

sealed trait DoubleList[+A] {
    def drop(n: Int): DoubleList[A] = this match {
        case NilD => NilD
        case NodeD(_, _, t) =>
            if (n <= 0) this
            else t.drop(n - 1)
    }

    def dropWhile(predicate: String): DoubleList[A] = this match {
        case NilD => NilD
        case NodeD(h, _, t) =>
            if (matchPredicate(h.toString.toInt, predicate)) t.dropWhile(predicate)
            else this
    }

    private def matchPredicate(value: Int, predicate: String): Boolean = predicate match {
        case s"<=$num" => value <= num.toInt
        case s">=$num" => value >= num.toInt
        case s"<$num" => value < num.toInt
        case s">$num" => value > num.toInt
        case s"==$num" => value == num.toInt
        case s"!=$num" => value != num.toInt
        case _ => false
    }

    def toSeq: Seq[A] = this match {
        case NilD => Seq.empty
        case NodeD(h, _, t) => h +: t.toSeq
    }
}

case object NilD extends DoubleList[Nothing]
case class NodeD[+A](head: A, prev: DoubleList[A], next: DoubleList[A]) extends DoubleList[A]

object DoubleList {
    def apply[A](next: A*): DoubleList[A] = {
        buildDoubleList(buildSingleList(next), NilD)
    }

    def buildSingleList[A](list: Seq[A]): DoubleList[A] = {
        if (list.isEmpty) NilD
        else NodeD(list.head, NilD, buildSingleList(list.tail))
    }

    def buildDoubleList[A](list: DoubleList[A], prev: DoubleList[A]): DoubleList[A] = list match {
        case NilD => NilD
        case NodeD(h, _, t) => NodeD(h, prev, buildDoubleList(t, list))
    }
}