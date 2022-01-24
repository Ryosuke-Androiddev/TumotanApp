# TumotanApp

画面構成　SplashScreen, HomeScreen, DetailScreen, StudyScreen, ResultScreen(StudyScreenでの一部実装が終わっていないので、まだ実装が終わっていない)

Splash Screen → HomeScreen
![homeScreen](https://user-images.githubusercontent.com/80034173/150848417-b53cb41b-ac1e-4bd8-8dc2-a98b5cff21d8.gif)

HomeScreen → DetailScreen
![DetailScreen](https://user-images.githubusercontent.com/80034173/150848511-9c2b36c3-f428-4871-a263-20f89b90849f.gif)

DetailScreen → StudyScreen
![StudyScreen](https://user-images.githubusercontent.com/80034173/150848754-47cb1260-a0cf-4df8-87d8-b1dc11208a92.gif)


アーキテクチャ
---

**Clean Architecture**を採用しました。
実装の流れは、data, domain, presentationごとにパッケージに分け、それぞれ必要な実装を行いました。
data → domain間での、ビジネスロジックの呼び出しのために、Repository のInterfaceを挟み、domainのUseCaseが、Repositoryの実装内容に関心を持たないフローの構造をとっています。
domain → presentationでは、UseCaseで呼び出した情報を、ViewModelのStateで管理しpresentationで呼び出しを行い、Viewへ反映させました。

##使用した技術
Jetpack Compose, Hilt, Retrofit, Room, Coroutine(Kotlin Flow)

Jetpack Compose
---

宣言的UIである。Jetpack Composeを用いてUIの構築を行いました。

Hilt
---

UseCaseをまとめた、data classの作成、Retorofit Instance, Room Instance, Repository Instanceの生成を、Moduleで行いました。

Retrofit
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


