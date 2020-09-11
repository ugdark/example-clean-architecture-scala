package example.adapters.controller

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives.{entity, _}
import akka.http.scaladsl.server.Route
import example.application.BuildingCreateUseCase
import example.application.BuildingCreateUseCase.Command
import example.domain.building.Building
import spray.json.DefaultJsonProtocol._
import spray.json._

trait BuildingCreateController extends BuildingCreateUseCase.Dependent with SprayJsonSupport {

  import BuildingCreateController._

  val route: Route =
    pathPrefix("buildings") {
      pathEnd {
        post {
          entity(as[PostRequest]) { request =>
            complete {
              buildingCreateUseCase.execute(Command(name = request.name)) match {
                case Right(reply) =>
                  StatusCodes.Created -> PostResponse.create(reply.entity)
                case _ => StatusCodes.BadRequest
              }

            }
          }
        }
      }
    }
}

object BuildingCreateController {

  case class PostRequest(name: String)

  case class PostResponse(id: String, name: String, createdAt: String, updateAt: String)

  implicit val postResponseFormat: RootJsonFormat[PostResponse] = jsonFormat4(PostResponse.apply)

  implicit val postRequestFormat: RootJsonFormat[PostRequest] = jsonFormat1(PostRequest)

  object PostResponse {
    def create(building: Building): PostResponse =
      new PostResponse(
        building.id.value,
        building.name.value,
        building.createdAt.toString,
        building.updatedAt.get.toString
      )
  }

  /**
    * 依存する側は定義する
    */
  trait Dependent {
    protected[this] val buildingCreateController: BuildingCreateController
  }

}
