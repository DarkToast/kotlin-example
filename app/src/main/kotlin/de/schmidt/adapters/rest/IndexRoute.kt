import de.schmidt.adapters.rest.Linked
import de.schmidt.adapters.rest.Method.GET
import de.schmidt.adapters.rest.Method.POST
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import kotlinx.serialization.Serializable
import java.net.URI

@Serializable
class Index : Linked<Index>() {
    init {
        addLink("_self", GET, URI("/"))
        addLink("add_person", POST, URI("/person"))
    }
}

fun Route.indexPage() {
    get("/") {
        call.respond(HttpStatusCode.OK, Index())
    }
}
