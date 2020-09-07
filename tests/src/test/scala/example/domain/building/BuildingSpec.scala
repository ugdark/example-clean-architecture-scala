package example.domain.building

import java.time.ZonedDateTime

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.wordspec.AnyWordSpec

class BuildingSpec extends AnyFreeSpec {

  "名前だけで作成する" in {
    assert(Building(name = "一刻館").name == BuildingName("一刻館"))
  }

  "すべての項目で作成する" in {
    Building(
      id = "1",
      name = "一刻館",
      createdAt = ZonedDateTime.parse("2018-08-04T16:00:07+09:00"),
      updatedAt = Some(ZonedDateTime.parse("2018-08-04T16:00:07+09:00"))
    )

    succeed

  }

}
