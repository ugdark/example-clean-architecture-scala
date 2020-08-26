package example.domain.basic

/**
 * 郵便番号を表す
 * @param areaCode 郵便区分
 * @param cityCode 町域
 */
case class ZipCode(areaCode: String, cityCode: String) {
  require(areaCode.length == 3, "areaCode is 3 length.")
  require(cityCode.length == 4, "cityCode is 4 length.")
}


object ZipCode {

  def apply(zipCode: String): ZipCode = {
    if (zipCode.length == 7) {
      val (areaCode, cityCode) = zipCode.splitAt(3)
      ZipCode(areaCode, cityCode)
    } else if (zipCode.length == 8) {
      val splits = zipCode.split("-").ensuring(_.length == 2)
      new ZipCode(splits(0), splits(1))
    } else {
      throw new IllegalArgumentException("zipcode is format[000-0000].")
    }
  }
}