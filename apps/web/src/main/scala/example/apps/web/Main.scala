package example.apps.web

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import com.typesafe.config.ConfigFactory

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object Main extends example.inject.controller.BuildingCreateController.Inject {

  private implicit val system: ActorSystem                        = ActorSystem()
  private implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  private[this] val config = ConfigFactory.load()

  def main(args: Array[String]): Unit = {

    val route: Route = buildingCreateController.route

    val bindingFuture = Http()
      .newServerAt(
        config.getString("http.interface"),
        config.getInt("http.port")
      )
      .bind(
        route
      )

    println(
      s""""Server online at
          http://${config.getString("http.interface")}:${config.getInt("http.port")}/
      \nPress RETURN to stop...
        """
    )

    StdIn.readLine()

    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())

  }
}
