package example.adapters.dbs.connect.building

import example.core.errors.DomainError
import example.domain.buildings.BuildingRepository
import example.domain.buildings.models.{Building, BuildingId, BuildingName}


class BuildingRepositoryImpl extends BuildingRepository {

  override def store(building: Building): Either[DomainError, Building] = ???

  override def findById(buildingId: BuildingId): Either[DomainError, Option[Building]] = ???

  override def findByName(building: BuildingName): Either[DomainError, Option[Building]] = ???

  override def findAll(): Either[DomainError, Seq[Building]] = ???

  override def delete(buildingId: BuildingId): Either[DomainError, Boolean] = ???

  override def clear(): Either[DomainError, Boolean] = ???
}

object BuildingRepositoryImpl extends BuildingRepositoryImpl