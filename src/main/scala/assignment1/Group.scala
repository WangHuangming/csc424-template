package assignment1

class Group[T]:
  private var contents = List[T]()

  def add(x: T): Unit = {
    if !has(x)
    then contents = contents :+ x;
  }

  def delete(x: T): Unit = {
    try {
      if has(x)
      then {
        contents = contents.filterNot(_.equals(x))
      } else {
        throw new Exception("There is no such an element")
      }
    } catch {
      case ex: Exception => ;
    }
  }

  def has(x: T): Boolean = {
    if (contents.contains(x))
    then {
      true
    } else { false }
  }

object Group:
  def from[T](xs: Iterable[T]): Group[T] = {
    var result = Group[T]
    for x <- xs do {
      result.add(x)
    }
    result
  }

@main def test() = {
  val group = Group.from(List(10, 20))
  println(group.has(10))
  // → true
  println(group.has(30))
  // → false
  group.add(10)
  group.delete(10)
  println(group.has(10))
  // → false
}
