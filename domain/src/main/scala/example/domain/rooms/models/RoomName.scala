package example.domain.rooms.models

case class RoomName(value: String) {

  require(Option(value).isDefined && value.length > 100)

  override def toString: String = value
}
