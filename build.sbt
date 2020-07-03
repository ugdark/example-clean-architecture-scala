import sbt.Keys.version

/**
 * <interface> これを定義する
 * Usecase<Interfaceを提供>
 *   - Command<UsecaseのInput型>
 *   - Reply<UsecaseのOutput型>
 */
lazy val useCase = project.in(file("useCase"))

/**
 * 業務ロジック置き場
 *
 *   - Entity<型>
 *   　- domainのrepository<Interfaceを提供>
 *     - domainのqueryProcessor<Interfaceを提供>
 *   - UseCaseの実装<Interactor>
 */
lazy val domain = project.in(file("domain"))
  .dependsOn(useCase)


/**
 * 実際に動かすサービスのインスタンス
 * controllerの実装
 * DIをする
 */
lazy val applicationsWeb = Project("applications-web", file("applications/web"))
  .enablePlugins(PlayScala)
  .settings(
    libraryDependencies ++= Seq( guice )
  )
  .dependsOn(domain)
  .dependsOn(useCase)
  .dependsOn(adaptersDbMySQL)

/**
 * Databasesを取り扱う
 * repositoryの実装
 * QueryProcessorの実装
 * repository以下はMysqlとかAWSとかつなぐとか何やっても良い
 */
lazy val adaptersDbMySQL = Project("adapters-dbs-mysql", file("adapters/dbs/mysql"))
  .dependsOn(domain)

lazy val aggregatedProjects = Seq[ProjectReference](
  useCase,
  domain,
  adaptersDbMySQL,
  applicationsWeb
)

lazy val root = (project in file("."))
  .settings(
    name := "example-clean-architecture-scala",
    version := "0.1",
    scalaVersion := "2.13.3",
  )
  .aggregate(aggregatedProjects: _*)
