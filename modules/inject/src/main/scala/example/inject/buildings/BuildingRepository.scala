package example.inject.buildings

object BuildingRepository {

  object OnMemory extends example.adapters.memory.rooms.BuildingRepositoryOnMemory

  /**
    * 注入する側は定義する
    */
  trait Inject extends example.domain.building.BuildingRepository.Dependent {
    protected[this] val buildingRepository: example.domain.building.BuildingRepository = OnMemory
  }
}
