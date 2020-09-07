package example.inject.controller
import example.application.BuildingCreateUseCase

class BuildingCreateController extends example.adapters.controller.BuildingCreateController {
  override protected[this] val buildingCreateUseCase: BuildingCreateUseCase =
    example.inject.application.BuildingCreateUseCase

}
object BuildingCreateController extends BuildingCreateController
