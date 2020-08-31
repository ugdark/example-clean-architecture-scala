package example.domain.buildings

case class BuildingId(value: String) {
  require(value.length > 0)
}
