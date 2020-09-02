package example.domain.building

case class BuildingId(value: String) {
  require(value.length > 0)
}
