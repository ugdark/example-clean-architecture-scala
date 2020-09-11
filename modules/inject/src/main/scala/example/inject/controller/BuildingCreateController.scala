package example.inject.controller

class BuildingCreateController
    extends example.adapters.controller.BuildingCreateController
    with example.inject.application.BuildingCreateUseCase.Inject

object BuildingCreateController {

  object BuildingCreateController extends BuildingCreateController

  /**
    * 注入する側は定義する
    */
  trait Inject extends example.adapters.controller.BuildingCreateController.Dependent {
    override protected[this] val buildingCreateController: BuildingCreateController = BuildingCreateController
  }
}
