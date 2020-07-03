package example.domain.buildings.models

case class BuildingId(value: Long) {
  require(value > 0)

  override def toString: String = value.toString
}
