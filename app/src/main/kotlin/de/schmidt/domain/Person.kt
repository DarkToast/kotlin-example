package de.schmidt.domain

import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val vorname: String,
    val nachname: String,
    val anrede: Anrede?
)

enum class Anrede {
    Herr, Frau
}