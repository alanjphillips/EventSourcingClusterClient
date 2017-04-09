package com.alaphi.userclient

import akka.actor.ActorSystem
import akka.kafka.ProducerSettings
import akka.kafka.scaladsl.Producer
import akka.stream.Materializer
import akka.stream.scaladsl.Source
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.common.serialization.{ByteArraySerializer, StringSerializer}

import scala.concurrent.{ExecutionContext, Future}

class KafkaProducer(implicit as: ActorSystem, mat: Materializer, ec: ExecutionContext) {

  val producerSettings = ProducerSettings(as, new ByteArraySerializer, new StringSerializer)
    .withBootstrapServers("kafka-1:9092,kafka-2:9093,kafka-3:9094")

  def sendToKafka(numMsgs: Int, numPartitions: Int) : Future[String] = {
    val done = Source(1 to numMsgs)
      .map { id =>
        val partition = id % numPartitions
        val msgBody = s"userId_$id"
        new ProducerRecord[Array[Byte], String]("user_status_commands", partition, null, msgBody)
      }
      .runWith(Producer.plainSink(producerSettings))

    done.map { d =>
      as.log.info(s"sendToKafka DONE: $d")
      d.toString
    }
  }

}

object KafkaProducer {
  def apply()(implicit as: ActorSystem, mat: Materializer, ec: ExecutionContext): KafkaProducer = new KafkaProducer()
}