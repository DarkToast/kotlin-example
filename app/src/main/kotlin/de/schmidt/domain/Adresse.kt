package de.schmidt.domain

data class Adresse(
    val strasse: String,
    val hausnummer: Int,
    val zusatz: String?,
    val plz: String,
    val ort: String,
)
