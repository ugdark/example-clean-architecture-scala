import sbt.Keys._
import sbt._

object Dependencies {

  object Versions {
    val scalaTestVersion = "3.2.0"
  }

  lazy val commonSettings = Seq(
    organization := "com.kokodayo",
    version := "0.1",
    scalaVersion := "2.13.3",
    scalacOptions := Seq(
        "-deprecation", // @deprecated なAPIが使われている箇所を警告します
        "-feature", // langauge feature の import が必要な箇所を警告します
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
      "org.scalatest" %% "scalatest"       % Versions.scalaTestVersion % Test,
      "ch.qos.logback" % "logback-classic" % "1.2.3"
    )
  }

}
