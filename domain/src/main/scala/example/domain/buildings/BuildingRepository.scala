package example.domain.buildings

import example.core.errors.DomainError

trait BuildingRepository {

  def store(building: Building): Either[DomainError, Unit]

  //def storeMulti(building: Building): Either[DomainError, Long]

  def findById(buildingId: BuildingId): Either[DomainError, Option[Building]]

  def findByName(building: BuildingName): Either[DomainError, Option[Building]]

  def findAll(): Either[DomainError, Seq[Building]]

  def delete(buildingId: BuildingId): Either[DomainError, Boolean]

  //def deleteMulti(buildingId: BuildingId): Either[DomainError, Boolean]

  def clear(): Either[DomainError, Unit]

}

//object BuildingRepository {
//
//  trait Dependent {
//    protected[this] val building: BuildingRepository
//  }
//}
