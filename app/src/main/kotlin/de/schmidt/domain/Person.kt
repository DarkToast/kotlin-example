package de.schmidt.domain

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Person(
    val anrede: Anrede?,
    val vorname: String,
    val nachname: String,
) {
    @Transient
    private val vornameRegex: Regex = "^[a-zA-ZöäüÖÄÜßéèê -]{0,32}".toRegex()

    @Transient
    private val nachnameRegex: Regex = "^[a-zA-ZöäüÖÄÜßéèê -]{0,32}".toRegex()

    init {
        val failures = mutableListOf<FieldFailure>()

        fun validate(field: String, message: String, assert: () -> Boolean) {
            if (assert()) failures += FieldFailure("Person", field, message)
        }

        validate("vorname", "Vorname is empty") { vorname.isEmpty() }
        validate("vorname", "Vorname is longer than 32 characters.") { vorname.length > 33 }
        validate("vorname", "Vorname contains irregular characters.") { !vornameRegex.matches(vorname) }

        validate("nachname", "Nachname is empty") { nachname.isEmpty() }
        validate("nachname", "Nachname is longer than 32 characters.") { nachname.length > 33 }
        validate("nachname", "Nachname contains irregular characters.") { !nachnameRegex.matches(nachname) }

        if (failures.isNotEmpty()) throw DomainException(failures)
    }
}

enum class Anrede {
    Herr,
    Frau,
}
