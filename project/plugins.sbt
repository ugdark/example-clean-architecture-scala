// Play
//addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.7.0")

// update等が早くなる
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.3")

// ドキュメント作成用
addSbtPlugin("com.lightbend.paradox" % "sbt-paradox" % "0.8.0")

// scalaのコードフォーマッター
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.2")

// Scala用のlintツール（静的解析ツール）
addSbtPlugin("org.wartremover" % "sbt-wartremover" % "2.4.2")

// ecr　登録時に使用
//addSbtPlugin("com.mintbeans" % "sbt-ecr" % "0.14.1")

// sbtプロジェクトの依存関係の更新を表示(これだとプロジェクトのみ)
// https://github.com/rtimush/sbt-updatesを参考に。
//addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.5.1")
