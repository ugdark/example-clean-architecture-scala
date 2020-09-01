package example.domain.rooms

import example.core.errors.DomainError
import example.domain.rooms.models.{Room, RoomId, RoomName}

trait RoomRepository {

  def store(room: Room): Either[DomainError, Room]

  def storeMulti(rooms: Seq[Room]): Either[DomainError, Seq[Room]]

  def findById(roomId: RoomId): Either[DomainError, Option[Room]]

  def findByName(name: RoomName): Either[DomainError, Option[Room]]

  def findAll(): Either[DomainError, Seq[Room]]

  def delete(roomId: RoomId): Either[DomainError, Boolean]

  def clear(): Either[DomainError, Boolean]
}
