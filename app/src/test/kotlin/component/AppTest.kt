package component

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.server.testing.testApplication
import junit.framework.TestCase.assertEquals
import kotlin.test.Test

class AppTest {
    @Test
    fun testRoot() = testApplication {
        val response = client.get("/")
        assertEquals(OK, response.status)
        assertEquals("Hallo Welt", response.bodyAsText())
    }

}