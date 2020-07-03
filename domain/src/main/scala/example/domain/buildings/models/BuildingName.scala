package example.domain.buildings.models

case class BuildingName(value: String) {

  require(Option(value).isDefined && value.length > 100)

  override def toString: String = value
}
