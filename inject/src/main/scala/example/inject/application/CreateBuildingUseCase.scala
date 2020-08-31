package example.inject.application

import example.domain.buildings.BuildingRepository

//実際のサービスで稼働させるInjectを設定する
object CreateBuildingUseCase extends example.application.CreateBuildingUseCase.Interactor {
  override protected[this] val buildingRepository: BuildingRepository =
    example.inject.buildings.BuildingRepository.OnMemory

}
