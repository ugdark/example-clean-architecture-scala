package example.inject.controller

import example.adapters.web.controller

class BuildingCreateController
    extends controller.BuildingCreateController
    with example.inject.application.BuildingCreateUseCase.Inject

object BuildingCreateController {

  object BuildingCreateController extends BuildingCreateController

  /**
    * 注入する側は定義する
    */
  trait Inject extends controller.BuildingCreateController.Dependent {
    override protected[this] val buildingCreateController: BuildingCreateController = BuildingCreateController
  }
}
