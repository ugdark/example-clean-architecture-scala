package example.domain.rooms.models

case class Rooms(values: Seq[Room]) {
  require(values.nonEmpty)
}
