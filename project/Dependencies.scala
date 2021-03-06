import sbt.Keys._
import sbt._

object Dependencies {

  object Versions {
    val scalaTestVersion = "3.2.0"
    val akka             = "2.6.8"
    val akkaHttp         = "10.2.0"

  }

  lazy val commonSettings = Seq(
    organization := "com.kokodayo",
    version := "0.1",
    scalaVersion := "2.13.3",
    scalacOptions := Seq(
        "-deprecation", // @deprecated なAPIが使われている箇所を警告します
        "-feature",     // langauge feature の import が必要な箇所を警告します
        "-unchecked",
        "-Xlint",
        "-Ywarn-dead-code",
        "-Ywarn-numeric-widen",
        "-Ywarn-unused"
        //"-Ywarn-unused-import",
        //"-Ywarn-value-discard",
        //"-Xfatal-warnings"
      )
  )

  lazy val testSettings = libraryDependencies ++= {
    Seq(
      "org.scalatest"     %% "scalatest"         % Versions.scalaTestVersion % Test,
      "com.typesafe.akka" %% "akka-http-testkit" % Versions.akkaHttp         % Test,
      "com.typesafe.akka" %% "akka-testkit"      % Versions.akka             % Test
    )
  }

}
