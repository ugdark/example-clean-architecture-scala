package example.adapters.web.controller

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import BuildingCreateController.PostResponse
import example.application.BuildingCreateUseCase
import example.domain.building.BuildingRepository
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import spray.json.DefaultJsonProtocol._
import spray.json.RootJsonFormat

class BuildingCreateControllerSpec extends AnyFreeSpec with SprayJsonSupport with Matchers with ScalatestRouteTest {

  private[this] val buildingCreateController =
    new BuildingCreateController {
      override protected[this] val buildingCreateUseCase: BuildingCreateUseCase =
        new example.inject.application.BuildingCreateUseCase() {
          override protected[this] val buildingRepository: BuildingRepository =
            example.inject.buildings.BuildingRepository.OnMemory
        }
    }

  private implicit val postResponseFormat: RootJsonFormat[PostResponse] = jsonFormat4(PostResponse.apply)

  "The controller" - {

    "post buildings" in {
      val req = HttpEntity(ContentTypes.`application/json`, """{"name":"一刻館"}""")
      Post("/buildings", req) ~> buildingCreateController.route ~> check {
        val building = responseAs[BuildingCreateController.PostResponse]
        building.name shouldEqual "一刻館"
        building.id should have length 36
        building.createdAt should have
        building.updateAt should have
      }
    }
  }
}
