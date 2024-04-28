package component

import Index
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.server.testing.testApplication
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.serialization.json.Json
import kotlin.test.Test

class IndexTest : BaseComponentTest() {
    @Test
    fun testRoot() = testApplication {
        val response = client.get("/")
        assertEquals(OK, response.status)

        val body: String = response.bodyAsText()
        val index: Index = json.decodeFromString<Index>(body)

        assertEquals("Index contains 2 links", 2, index.links.size)
        assertTrue("Index link does not contains '_self'", index.links.containsKey("_self"))
        assertTrue("Index link does not contains 'add_person'", index.links.containsKey("add_person"))
    }
}
