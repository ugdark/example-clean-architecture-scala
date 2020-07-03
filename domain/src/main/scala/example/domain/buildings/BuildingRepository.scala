package example.domain.buildings

import example.core.errors.DomainError
import example.domain.buildings.models.{Building, BuildingId, BuildingName}

trait BuildingRepository {

  def store(building: Building): Either[DomainError, Building]

  def findById(buildingId: BuildingId): Either[DomainError, Option[Building]]

  def findByName(building: BuildingName): Either[DomainError, Option[Building]]

  def findAll(): Either[DomainError, Seq[Building]]

  def delete(buildingId: BuildingId): Either[DomainError, Boolean]

  def clear(): Either[DomainError, Boolean]

}
