package example.usecase.building.rooms.create

trait CreateBuildingRoomsUseCase {

  def execute(command: CreateBuildingRoomsCommand):Unit
}
