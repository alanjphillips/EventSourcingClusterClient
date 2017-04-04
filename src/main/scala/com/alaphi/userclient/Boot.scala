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

  val userMessageGeneratorService = UserMessageGeneratorService(executionContext)

  val routes = Routes(userMessageGeneratorService)

  val bindingFuture = Http().bindAndHandle(routes.UserRoutes, "0.0.0.0", 8081)

}
