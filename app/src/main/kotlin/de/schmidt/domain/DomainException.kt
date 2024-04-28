package de.schmidt.domain

data class FieldFailure(val type: String, val field: String, val message: String = "")

class DomainException(val failure: List<FieldFailure>) : Exception("Failure in domain validation")
