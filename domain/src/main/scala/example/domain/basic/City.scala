package example.domain.basic

/**
  *
 * 市区町村を表す
  * @param value 市区町村名
  */
case class City(value: String) {
  require(value.length > 0, "city is required.")
}
