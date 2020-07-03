package example.core.errors

sealed trait DomainError {
  val code: Long
  val message: String
}


