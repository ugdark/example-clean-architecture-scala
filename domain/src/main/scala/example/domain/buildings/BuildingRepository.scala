package example.domain.buildings

import scala.util.Try

trait BuildingRepository {

  def store(entity: Building): Try[Unit]

  def storeMulti(entities: Seq[Building]): Try[Unit]

  def findById(buildingId: BuildingId): Try[Option[Building]]

  def findAll(): Try[Seq[Building]]

  def delete(buildingId: BuildingId): Try[Unit]

  def clear(): Try[Unit]

}

object BuildingRepository {

  /**
    * 依存する側は定義する
    */
  trait Dependent {
    protected[this] val buildingRepository: BuildingRepository
  }

}
