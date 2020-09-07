package example.inject.application

import example.domain.building.BuildingRepository

class BuildingCreateUseCase extends example.application.BuildingCreateUseCase.Interactor {
  override protected[this] val buildingRepository: BuildingRepository =
    example.inject.buildings.BuildingRepository.OnMemory
}

//実際のサービスで稼働させるInjectを設定する
object BuildingCreateUseCase extends BuildingCreateUseCase {
  override protected[this] val buildingRepository: BuildingRepository =
    example.inject.buildings.BuildingRepository.OnMemory
}
