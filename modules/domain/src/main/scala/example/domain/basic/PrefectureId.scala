package example.domain.basic

case class PrefectureId(id: Int) {
  require(id > 0 && id < 48, "id is required.")
}
