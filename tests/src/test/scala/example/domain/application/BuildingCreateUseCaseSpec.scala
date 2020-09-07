package example.domain.application

import java.time.ZonedDateTime

import example.application.BuildingCreateUseCase
import example.domain.building.{BuildingName, BuildingRepository}
import org.scalatest.EitherValues
import org.scalatest.freespec.AnyFreeSpec

class BuildingCreateUseCaseSpec extends AnyFreeSpec with EitherValues {

  "建物の作成で" - {
    "名前のみで追加された場合" - {
      "Entityを返す" in {
        val command = BuildingCreateUseCase.Command("ガーデンビュー石神A")
        val now     = ZonedDateTime.now
        val createBuildingUseCase = new example.application.BuildingCreateUseCase.Interactor() {
          override protected[this] val buildingRepository: BuildingRepository =
            example.inject.buildings.BuildingRepository.OnMemory
        }
        val reply: BuildingCreateUseCase.Reply =
          createBuildingUseCase.execute(command).getOrElse(fail("either was not Right!"))

        assert(reply.entity.id.value.length == 36)
        assert(reply.entity.name == BuildingName(command.name))
        assert(reply.entity.createdAt.isAfter(now))
        assert(reply.entity.updatedAt.get.isAfter(now))
      }
    }
  }
}
