package example.application

import example.domain.buildings.{Building, BuildingRepository}
import example.domain.errors.UseCaseError

trait CreateBuildingUseCase {
  // 必要があれば拡張する
  protected[this] val presenter: CreateBuildingUseCase.Presenter = new CreateBuildingUseCase.Presenter() {}

  def execute(command: CreateBuildingUseCase.Command): Unit
}

object CreateBuildingUseCase {

  case class Command(name: String)

  trait Presenter {
    def complete(reply: Reply): Unit = ()
  }

  case class Reply(entity: Building)

  /**
    * 依存する側は定義する
    */
  trait Dependent {
    protected[this] val createBuildingUseCase: CreateBuildingUseCase
  }

  trait Interactor extends CreateBuildingUseCase with BuildingRepository.Dependent {
    override def execute(command: CreateBuildingUseCase.Command): Unit = {
      try {
        val entity = Building(name = command.name)
        buildingRepository.store(entity)
        buildingRepository.findById(entity.id)
        presenter.complete(Reply(entity))
      } catch {
        case e: Throwable => throw UseCaseError(e)
      }
    }
  }

  trait Inject {}
}
