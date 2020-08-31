package example.inject.buildings

import example.adapters.memory.rooms.BuildingRepositoryOnMemory

object BuildingRepository {

  object OnMemory extends BuildingRepositoryOnMemory

}
