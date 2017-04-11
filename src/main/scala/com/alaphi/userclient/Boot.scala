package com.alaphi.userclient

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory

object Boot extends App {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val config = ConfigFactory.load()

  val producer = KafkaProducer()

  val userMessageGeneratorService = UserMessageGeneratorService(producer)

  val routes = Routes(userMessageGeneratorService)

  val bindingFuture = Http().bindAndHandle(routes.userRoutes, "0.0.0.0", 8081)

}
