package example.domain.building

case class BuildingName(value: String) {
  require(Option(value).isDefined && value.nonEmpty)
  require(value.length <= 100)

//  requires(
//
//  )

}
