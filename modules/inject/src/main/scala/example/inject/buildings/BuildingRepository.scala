package example.inject.buildings

import example.adapters.memory.rooms.BuildingRepositoryOnMemory
import example.domain.building.BuildingRepository

object BuildingRepository {

  object OnMemory extends BuildingRepositoryOnMemory

  /**
    * 注入する側は定義する
    */
  trait Inject extends example.domain.building.BuildingRepository.Dependent {
    protected[this] val buildingRepository: BuildingRepository = OnMemory
  }
}
