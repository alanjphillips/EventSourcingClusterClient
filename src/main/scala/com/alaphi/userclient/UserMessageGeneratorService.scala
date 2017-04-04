package com.alaphi.userclient

import scala.concurrent.{ExecutionContext, Future}


class UserMessageGeneratorService(implicit ec: ExecutionContext) {

  def startGenerating(): Future[String] = {
    Future {
      "Started"
    }
  }

}

object UserMessageGeneratorService {
  def apply(implicit ec: ExecutionContext): UserMessageGeneratorService = new UserMessageGeneratorService()
}