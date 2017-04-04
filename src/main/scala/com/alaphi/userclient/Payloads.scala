package com.alaphi.userclient

trait Payload

case class GenerateUserData(name: String) extends Payload

case class GenerateUserDataResponse(name: String) extends Payload
