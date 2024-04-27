package de.schmidt

import de.schmidt.domain.Person
import io.github.oshai.kotlinlogging.KotlinLogging
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.netty.EngineMain
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import kotlinx.serialization.json.Json

fun main(args: Array<String>): Unit = EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }

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

        post("/person") {
            logger.info { "POST person" }
            val person = call.receive<Person>()
            call.respond("Person created $person")
            logger.info { "Person $person created" }
        }
    }
}