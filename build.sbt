import Dependencies._


/**
  * <interface> これを定義する
  * UseCase<Interfaceを提供>
  *   - Command<UseCaseのInput型>
  *   - Reply<UseCaseのOutput型>
  */
lazy val useCase = project
  .in(file("useCase"))
  .settings(commonSettings)
  .settings(testSettings)

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
  .settings(testSettings)
  .dependsOn(useCase)

/**
  * 実際に動かすサービスのインスタンス
  * controllerの実装
  * DIをする
  */
//lazy val applicationsWeb = Project("applications-web", file("applications/web"))
//  .enablePlugins(PlayScala)
//  .settings(
//    libraryDependencies ++= Seq( guice )
//  )
//  .dependsOn(domain)
//  .dependsOn(useCase)
//  .dependsOn(adaptersDbMySQL)

/**
  * Databasesを取り扱う
  * repositoryの実装
  * QueryProcessorの実装
  * repository以下はMysqlとかAWSとかつなぐとか何やっても良い
  */
//lazy val adaptersDbMySQL = Project("adapters-dbs-mysql", file("adapters/dbs/mysql"))
//  .dependsOn(domain)

//lazy val adaptersMemory = Project("adapters-memory", file("adapters/memory"))
//  .dependsOn(domain)

lazy val aggregatedProjects = Seq[ProjectReference](
  useCase,
  domain
  //  adaptersMemory,
  //  applicationsWeb
)

lazy val root = (project in file("."))
  .settings(commonSettings)
  .settings(
    name := "example-clean-architecture-scala"
  )
  .aggregate(aggregatedProjects: _*)
