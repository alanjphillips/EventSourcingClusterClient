enablePlugins(JavaAppPackaging)

name := "EventSourcingClusterClient"

version := "1.0"

scalaVersion := "2.12.1"

val akkaVersion = "2.4.14"

resolvers ++= Seq(
  Resolver.bintrayRepo("hseeberger", "maven")
)

libraryDependencies ++= Seq(
  "de.heikoseeberger"         %% "akka-http-circe"        % "1.11.0",
  "io.circe"                  %% "circe-core"             % "0.7.0-M1",
  "io.circe"                  %% "circe-generic"          % "0.7.0-M1",
  "io.circe"                  %% "circe-parser"           % "0.7.0-M1",
  "com.typesafe.akka"         %% "akka-actor"             % akkaVersion,
  "com.typesafe.akka"         %% "akka-stream-kafka"      % "0.13",
  "com.typesafe.akka"         %% "akka-http"              % "10.0.0"
)

        