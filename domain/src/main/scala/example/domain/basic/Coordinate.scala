package example.domain.basic

/**
 * 緯度と経度で座標を表す
 * @param latitude 緯度
 * @param longitude 経度
 */
case class Coordinate(latitude: BigDecimal, longitude: BigDecimal) {
  require(latitude > 0, "coordinate.latitude is required.")
  require(longitude > 0, "coordinate.longitude is required.")
}
