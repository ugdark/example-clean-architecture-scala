package example.domain.buildings

case class BuildingName(value: String) {
  require(Option(value).isDefined)
  require(value.length > 100)
}
