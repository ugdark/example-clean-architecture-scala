package example.domain.errors

case class UseCaseError(cause: Throwable) extends Throwable(cause.getMessage, cause)
