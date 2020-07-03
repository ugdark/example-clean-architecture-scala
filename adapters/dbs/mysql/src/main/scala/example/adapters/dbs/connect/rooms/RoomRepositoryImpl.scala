package example.adapters.dbs.connect.rooms

import example.core.errors.DomainError
import example.domain.rooms.RoomRepository
import example.domain.rooms.models.{Room, RoomId, RoomName}


class RoomRepositoryImpl extends RoomRepository {

  override def store(room: Room): Either[DomainError, Room] = ???

  override def findById(roomId: RoomId): Either[DomainError, Option[Room]] = ???

  override def findByName(name: RoomName): Either[DomainError, Option[Room]] = ???

  override def findAll(): Either[DomainError, Seq[Room]] = ???

  override def delete(roomId: RoomId): Either[DomainError, Boolean] = ???

  override def clear(): Either[DomainError, Boolean] = ???
}
