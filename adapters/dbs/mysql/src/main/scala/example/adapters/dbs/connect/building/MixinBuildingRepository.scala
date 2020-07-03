package example.adapters.dbs.connect.building

import example.domain.buildings.BuildingRepository

trait MixinBuildingRepository {
  protected[this] val buildingRepository: BuildingRepository = BuildingRepositoryImpl
}
