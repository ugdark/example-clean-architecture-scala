package example.domain.buildings

import java.time.ZonedDateTime

import example.domain.support.IdGenerator

case class Building(
    id: BuildingId,
    name: BuildingName,
    createdAt: ZonedDateTime,
    updatedAt: Option[ZonedDateTime]
)

object Building {

  def apply(
             id: String = IdGenerator.uuid,
             name: String,
             createdAt: ZonedDateTime = ZonedDateTime.now(),
             updatedAt: Option[ZonedDateTime] = None
  ): Building =
    new Building(BuildingId(id), BuildingName(name), createdAt, updatedAt)
  //def apply(id: String = IDGenerator.uuid, name: String):Building = Building(BuildingId(id), BuildingName(name))
}
