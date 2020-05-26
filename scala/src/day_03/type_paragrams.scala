package day_03

import scala.collection.immutable.Queue


object type_paragrams {
  val q = Queue(1, 2, 3)


}

class SlowAppendQueue[T](smele: List[T]) {
  def last: T = smele.last

}
