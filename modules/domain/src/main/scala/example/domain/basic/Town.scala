package example.domain.basic

/**
  *  町域を表す
  */
case class Town(value: String) {
  require(value.length > 0, "townE is required.")

}
