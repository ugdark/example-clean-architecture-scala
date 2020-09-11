package example.inject.application

class BuildingCreateUseCase
    extends example.application.BuildingCreateUseCase.Interactor
    with example.inject.buildings.BuildingRepository.Inject

object BuildingCreateUseCase {

  private object BuildingCreateUseCase extends BuildingCreateUseCase

  /**
    * 注入する側は定義する
    */
  trait Inject extends example.application.BuildingCreateUseCase.Dependent {
    override protected[this] val buildingCreateUseCase: example.application.BuildingCreateUseCase =
      BuildingCreateUseCase
  }
}
