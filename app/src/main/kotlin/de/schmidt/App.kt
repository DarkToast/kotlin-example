package de.schmidt

import io.github.oshai.kotlinlogging.KotlinLogging
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.netty.EngineMain
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import io.ktor.server.routing.routing

fun main(args: Array<String>): Unit = EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    routing {
        configureRouting()
    }
}

fun Route.configureRouting() {
    val logger = KotlinLogging.logger {}

    route("/") {
        get {
            logger.info { "GET root path" }
            call.respond("Hallo Welt")
        }
    }
}