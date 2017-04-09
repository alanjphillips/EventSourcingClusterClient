enablePlugins(JavaAppPackaging)

name := "userclient"

version := "latest"

scalaVersion := "2.12.1"

val akkaVersion          = "2.4.17"
val akkaHttpVersion      = "10.0.4"
val akkaKafkaVersion     = "0.14"
val catsVersion          = "0.9.0"
val circeVersion         = "0.7.0"
val akkaHttpCirceVersion = "1.11.0"

resolvers ++= Seq(
  Resolver.bintrayRepo("hseeberger", "maven")
)

libraryDependencies ++= Seq(
  "de.heikoseeberger" %% "akka-http-circe"      % akkaHttpCirceVersion,
  "org.typelevel"     %% "cats"                 % catsVersion,
  "io.circe"          %% "circe-core"           % circeVersion,
  "io.circe"          %% "circe-generic"        % circeVersion,
  "io.circe"          %% "circe-parser"         % circeVersion,
  "com.typesafe.akka" %% "akka-actor"           % akkaVersion,
  "com.typesafe.akka" %% "akka-stream"          % akkaVersion,
  "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream-kafka"    % akkaKafkaVersion
)

packageName in Docker := "userclient"
version in Docker     := "latest"
        