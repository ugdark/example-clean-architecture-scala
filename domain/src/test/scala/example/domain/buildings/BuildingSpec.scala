package example.domain.buildings

import org.scalatest.wordspec.AnyWordSpec

class BuildingSpec extends AnyWordSpec {

  "名前だけで作成する" in {
    assert(Building(name = "一刻館").name == BuildingName("一刻館"))
  }

  "すべての項目で作成する" in {
    assert(Building(name = "一刻館").name == BuildingName("一刻館"))

  }

}
