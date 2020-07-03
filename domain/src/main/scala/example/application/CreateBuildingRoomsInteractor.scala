package example.application

import example.usecase.building.rooms.create.{CreateBuildingRoomsCommand, CreateBuildingRoomsUseCase}

class CreateBuildingRoomsInteractor extends CreateBuildingRoomsUseCase {
  override def execute(command: CreateBuildingRoomsCommand): Unit = ???
}
