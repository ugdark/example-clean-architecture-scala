package example.adapters.memory.rooms

import example.core.errors.DomainError
import example.domain.buildings.{Building, BuildingId, BuildingName, BuildingRepository}

class BuildingRepositoryOnMemory extends BuildingRepository {
  private[this] val storage: scala.collection.mutable.Map[BuildingId, Building] =
    scala.collection.mutable.Map.empty

  override def store(entity: Building): Either[DomainError, Unit] = {
    storage.update(entity.id, entity)
    Right(())
  }

  override def findById(buildingId: BuildingId): Either[DomainError, Option[Building]] =
    Right(storage.get(buildingId))

  override def findByName(entity: BuildingName): Either[DomainError, Option[Building]] =
    Right(storage.values.find(_.name == entity))

  override def findAll(): Either[DomainError, Seq[Building]] = {
    Right(storage.values.toSeq)
  }

  override def delete(buildingId: BuildingId): Either[DomainError, Boolean] =
    Right(storage.remove(buildingId).isDefined)

  override def clear(): Either[DomainError, Unit] = Right(storage.clear())
}
