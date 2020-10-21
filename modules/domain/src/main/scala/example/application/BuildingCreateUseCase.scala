package example.application

import example.domain.building.{Building, BuildingRepository}
import example.domain.errors.UseCaseError

trait BuildingCreateUseCase extends BuildingRepository.Dependent {

  def execute(command: BuildingCreateUseCase.Command): Either[UseCaseError, BuildingCreateUseCase.Reply]
}

object BuildingCreateUseCase {

case class Command(




                    name: String)

case class Reply(


                  entity: Building)

  /**
    * 依存する側は定義する
    */
  trait Dependent {
    protected[this] val buildingCreateUseCase: BuildingCreateUseCase
  }

  trait Interactor extends BuildingCreateUseCase {
    override def execute(command: BuildingCreateUseCase.Command): Either[UseCaseError, BuildingCreateUseCase.Reply] = {
      try {
        val entity = Building(name = command.name)
        buildingRepository.store(entity)
        buildingRepository.findById(entity.id)
        Right(Reply(entity))
      } catch {
        case e: Throwable => Left(UseCaseError(e))
      }
    }
  }

}
