import Dependencies._

///**
//  * <interface> これを定義する
//  * UseCase<Interfaceを提供>
//  *   - Command<UseCaseのInput型>
//  *   - Reply<UseCaseのOutput型>
//  */
//lazy val useCase = project
//  .in(file("useCase"))
//  .settings(commonSettings)
//  .settings(testSettings)

/**
  * 業務ロジック置き場
  *
  *   - Model[Entity,VO>
  *   　- domainのrepository<Interfaceを提供>
  *     - domainのqueryProcessor<Interfaceを提供>
  *   - Application(UseCase)の実装<Interactor>
  */
lazy val domain = project
  .in(file("domain"))
  .settings(commonSettings)

lazy val adaptersMemory = Project("adapters-memory", file("adapters/memory"))
  .settings(commonSettings)
  .dependsOn(domain)

lazy val adaptersWeb = Project("adapters-web", file("adapters/web"))
  .settings(commonSettings)
  .settings(
    libraryDependencies ++= Seq(
        "com.typesafe.akka" %% "akka-http"            % Versions.akkaHttp,
        "com.typesafe.akka" %% "akka-http-spray-json" % Versions.akkaHttp,
        "com.typesafe.akka" %% "akka-stream"          % Versions.akka
      )
  )
  .dependsOn(domain)

/**
  * Databasesを取り扱う
  * repositoryの実装
  * QueryProcessorの実装
  * repository以下はMysqlとかAWSとかつなぐとか何やっても良い
  */
//lazy val adaptersDbMySQL = Project("adapters-dbs-mysql", file("adapters/dbs/mysql"))
//  .dependsOn(domain)

// 実体置き場
lazy val inject = project
  .in(file("inject"))
  .settings(commonSettings)
  .dependsOn(domain)
  .dependsOn(adaptersMemory)
  .dependsOn(adaptersWeb)

// テスト置き場
lazy val test = project
  .in(file("test"))
  .settings(commonSettings)
  .settings(testSettings)
  .dependsOn(inject)

lazy val aggregatedProjects = Seq[ProjectReference](
  domain,
  adaptersMemory,
  adaptersWeb,
  inject,
  test
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "example-clean-architecture-scala"
  )
  .aggregate(aggregatedProjects: _*)
