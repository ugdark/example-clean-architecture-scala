package example.domain.support

trait Enum[A <: EnumColumn] {

  val values: Seq[A]

  /**
   * 初期値
   */
  val defaultValue: A

}
