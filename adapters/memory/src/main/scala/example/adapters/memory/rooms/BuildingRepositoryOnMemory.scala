package example.adapters.memory.rooms

import example.domain.building.{Building, BuildingId, BuildingRepository}

import scala.util.Try

class BuildingRepositoryOnMemory extends BuildingRepository {
  private[this] val storage: scala.collection.mutable.Map[BuildingId, Building] =
    scala.collection.mutable.Map.empty

  override def store(entity: Building): Try[Unit] =
    Try { storage.update(entity.id, entity) }

  override def storeMulti(entities: Seq[Building]): Try[Unit] = Try { entities.foreach(store) }

  override def findById(buildingId: BuildingId): Try[Option[Building]] = Try { storage.get(buildingId) }

  override def findAll(): Try[Seq[Building]] = Try { storage.values.toSeq }

  override def delete(buildingId: BuildingId): Try[Unit] = Try { storage.remove(buildingId) }

  override def clear(): Try[Unit] = Try { storage.clear() }
}
