package com.alaphi.userclient

trait Payload

case class GenerateUserData(numMsgs: Int) extends Payload

case class GenerateUserDataResponse(name: String) extends Payload
