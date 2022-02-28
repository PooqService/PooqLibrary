package dev.pooq.pooqservice.cloud

import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = launch(args)

fun launch(args: Array<String>){

  val service = Pooq.getService()

  embeddedServer(Netty)
}