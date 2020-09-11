
# example-clean-architecture-scala 

- クリーンアーキテクチャの理解とか学習用

## プロジェクト構成図

```
  全体図
  apps     -> inject -> domain <- adapters
  tests    -> inject
  testsで全部testを書く
  但しOnMySQL等がある場合にDB固有の確認がしたい場合はtestはそちらで書くとする。
```

- apps は主に実際に動かすサービスレベルの物
- injectは実体置き場で基本的にinjectを使ってappsやtestを実行する。

### DIまわりについて

Dwangoさんとこの(Minimal Cake Pattern)を参考に実装。
ただUsesとかMixInではなくPrefixにしたかったので

- 依存するなら`BuildingRepository.Dependent`
- 注入するなら`BuildingRepository.Inject`
として定義してる。
基本的に実体はすべてInject.modulesに定義してる。

Guice, Airframe, MacWireなども検討したのだけど、ま〜好みです。

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
- [Scalaにおける最適なDependency Injectionの方法を考察する 〜なぜドワンゴアカウントシステムの生産性は高いのか〜](https://qiita.com/pab_tech/items/1c0bdbc8a61949891f1f)

- 変数名に困ったら[codic](https://codic.jp/engine)



