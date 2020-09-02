package example.domain.application

import example.application.CreateBuildingUseCase
import example.application.CreateBuildingUseCase.Reply
import example.domain.building.{Building, BuildingName, BuildingRepository}
import org.scalatest.wordspec.AnyWordSpec

class CreateBuildingUseCaseSpec extends AnyWordSpec {

  "CreateBuildingUseCaseで" when {
    "建物が追加された場合" should {
      "Unitを返す" in {
        val command          = CreateBuildingUseCase.Command("ガーデンビュー石神A")
        var entity: Building = null
        val presenterImpl: CreateBuildingUseCase.Presenter = new CreateBuildingUseCase.Presenter() {
          override def complete(reply: Reply): Unit = {
            entity = reply.entity
          }
        }
        val createBuildingUseCase = new example.application.CreateBuildingUseCase.Interactor() {
          override protected[this] val presenter: CreateBuildingUseCase.Presenter = presenterImpl
          override protected[this] val buildingRepository: BuildingRepository =
            example.inject.buildings.BuildingRepository.OnMemory
        }

        createBuildingUseCase.execute(command)
        assert(entity.name == BuildingName(command.name))

      }
    }

  }

}
