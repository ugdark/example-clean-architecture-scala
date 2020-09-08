
# example-clean-architecture-scala 

- クリーンアーキテクチャの理解

### format使い方

```bash
$ sbt scalafmtCheck test:scalafmtCheck scalafmtSbtCheck // fmt検証 fmtとcheckもうちょっと理解したい
$ sbt scalafmt test:scalafmt scalafmtSbt // fmt実行 ideaにてpluginで適応されてるなら不要
```


# Webの起動方法

```bash
sbt "project exampleWeb" run
```

## 動作確認


- create a new building
```bash
curl -H "Content-Type: application/json" --request POST 'localhost:8080/buildings'  -d '{"name":"NEW Building"}'
```



## 資料

- 変数名に困ったら[codic](https://codic.jp/engine)



