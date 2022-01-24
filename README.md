# TumotanApp

#画面構成


#アーキテクチャ
---

**Clean Architecture**を採用しました。
実装の流れは、data, domain, presentationごとにパッケージに分け、それぞれ必要な実装を行いました。
data → domain間での、ビジネスロジックの呼び出しのために、Repository のInterfaceを挟み、domainのUseCaseが、Repositoryの実装内容に関心を持たないフローの構造をとっています。
domain → presentationでは、UseCaseで呼び出した情報を、ViewModelのStateで管理しpresentationで呼び出しを行い、Viewへ反映させました。

##使用した技術
Jetpack Compose, Hilt, Retrofit, Room, Coroutine(Kotlin Flow)

#Jetpack Compose
---

宣言的UIである。Jetpack Composeを用いてUIの構築を行いました。

#Hilt
---

UseCaseをまとめた、data classの作成、Retorofit Instance, Room Instance, Repository Instanceの生成を、Moduleで行いました。

#Retrofit
---

**BaseURL = https://tumotan-service.herokuapp.com/**

``room``‥学習のできる教材の一覧を表示する
``room/{roomId}``‥選択した教材の詳細を表示する
``room/{roomId}/{roomLevelId}``‥選択したレベルに応じて、単語とそのイメージを表示し学習を開始する。

Room
---

2つのテーブルを定義し、学習画面で確認した単語をローカルのデータベースに保存するために使用しました。

``AcceptedWord``‥知っている単語を保存するためのテーブル
``RejectedWord``‥知らない単語を保存するためのテーブル

Coroutine(Kotlin Flow)
---

Retorofitで呼び出しで取得するListを、Flowを使って取得する。
それ以外の、DB関連の操作をsusupend fun で実装しました。


