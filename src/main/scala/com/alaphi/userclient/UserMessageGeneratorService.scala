package com.alaphi.userclient

import scala.concurrent.{ExecutionContext, Future}


class UserMessageGeneratorService(producer: KafkaProducer, numPartitions: Int = 6)(implicit ec: ExecutionContext) {

  def startGenerating(numMsgs: Int): Future[String] = {
    producer.sendToKafka(numMsgs, numPartitions)
  }

}

object UserMessageGeneratorService {
  def apply(producer: KafkaProducer)(implicit ec: ExecutionContext): UserMessageGeneratorService = new UserMessageGeneratorService(producer)
}