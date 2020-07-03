
# example-clean-architecture-scala 

- クリーンアーキテクチャの理解

- 実際にありそうな課題をどのように解決するか

## 課題 dbのRoom, Buildingの両方のTableに書き込み必要あり
通常だとRepository内でTransactionを完結させるのが理想
ただ現実には２つのTableに対して処理を行う事がありそれを自分なら
どう解決するのか試す

###　解決策
自分ならusecase層の実装(Interactor)でTransactionを持って対応すればよいと思う





