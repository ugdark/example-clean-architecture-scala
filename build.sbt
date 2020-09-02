import Dependencies._

/**
 * 全体図
 * apps     -> inject -> domain <- adapters
 * tests    -> inject
 * testsで全部testを書く
 * 但しOnMySQL等がある場合にDB固有の確認がしたい場合はtestはそちらで書くとする。
 */

/**
  * 業務ロジック置き場
  * (UseCaseとDomainととりあえず共通ライブラリ置き場)
  *   - application(UseCase)の実装<Interactor>
  *   - domain[Entity,VO>
  *   　- domainのrepository<Interfaceを提供>
  */
lazy val domain = project.in(file("modules/domain"))
  .settings(commonSettings)

lazy val adaptersMemory = Project("adapters-memory", file("modules/adapters/memory"))
  .settings(commonSettings)
  .dependsOn(domain)

lazy val adaptersWeb = Project("adapters-web", file("modules/adapters/web"))
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
lazy val inject = project.in(file("modules/inject"))
  .settings(commonSettings)
  .dependsOn(domain)
  .dependsOn(adaptersMemory)
  .dependsOn(adaptersWeb)

// テスト置き場
lazy val tests = project
  .in(file("tests"))
  .settings(commonSettings)
  .settings(testSettings)
  .dependsOn(inject)

// applications
lazy val exampleWeb = project.in(file("apps/web"))
  .settings(commonSettings)
  .dependsOn(inject)

lazy val exampleCli = project.in(file("apps/cli"))
  .settings(commonSettings)
  .dependsOn(inject)


lazy val aggregatedProjects = Seq[ProjectReference](
  domain,
  adaptersMemory,
  adaptersWeb,
  inject,
  tests,
  exampleWeb,
  exampleCli
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "example-clean-architecture-scala"
  )
  .aggregate(aggregatedProjects: _*)
