package de.schmidt.domain

import de.schmidt.domain.Anrede.Herr
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PersonTest {
    @ParameterizedTest
    @ValueSource(strings = ["Christian", "Alrik Daniel", "Hans-Georg", "FooäöüßéèÄÖÜ"])
    fun `vorname correct`(vorname: String) {
        assertDoesNotThrow {
            Person(Herr, vorname, "Schmidt")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "abcdefghijklmnopqrstuvwxyzABCDEFG", "0123"])
    fun `vorname wrong`(vorname: String) {
        val e = assertThrows<DomainException> {
            Person(Herr, vorname, "Schmidt")
        }

//        assertEquals("Person", e.type)
//        assertEquals("vorname", e.field)
    }

    @ParameterizedTest
    @ValueSource(strings = ["Schmidt", "FooäöüßéèÄÖÜ", "von Ramsch", "Müller-Piepenkötter"])
    fun `nachname correct`(nachname: String) {
        assertDoesNotThrow {
            Person(Herr, "Christian", nachname)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "abcdefghijklmnopqrstuvwxyzABCDEFG", "0123"])
    fun `nachname wrong`(nachname: String) {
        val e = assertThrows<DomainException> {
            Person(Herr, "Christian", nachname)
        }

//        assertEquals("Person", e.type)
//        assertEquals("nachname", e.field)
    }
}

