package de.schmidt.domain

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class Person(
    val anrede: Anrede?,
    val vorname: String,
    val nachname: String
) {
    @Transient
    private val vornameRegex: Regex = "^[a-zA-ZöäüÖÄÜßéèê -]{1,32}".toRegex()

    @Transient
    private val nachnameRegex: Regex = "^[a-zA-ZöäüÖÄÜßéèê -]{1,32}".toRegex()

    init {
        val failures  = mutableListOf<FieldFailure>()
        if(vorname.isEmpty()) failures += FieldFailure("Person", "vorname", "Vorname is empty")
        if(vorname.length > 33) failures += FieldFailure("Person", "vorname", "Vorname is longer than 32 characters.")
        if(!vornameRegex.matches(vorname)) failures += FieldFailure("Person", "vorname", "Vorname contains irregular characters.")

        if(nachname.isEmpty()) failures += FieldFailure("Person", "nachname", "Nachname is empty")
        if(nachname.length > 33) failures += FieldFailure("Person", "nachname", "Nachname is longer than 32 characters.")
        if(!nachnameRegex.matches(nachname)) failures += FieldFailure("nachname", "Nachname", "Nachname contains irregular characters.")

        if(failures.isNotEmpty()) throw DomainException(failures)
    }
}

enum class Anrede {
    Herr,
    Frau,
}
