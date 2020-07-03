package example.domain.rooms.models

case class RoomId(value: Long) {
  require(value > 0)

  override def toString: String = value.toString
}
