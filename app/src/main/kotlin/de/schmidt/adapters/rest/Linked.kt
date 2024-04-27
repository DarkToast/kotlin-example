package de.schmidt.adapters.rest

import kotlinx.serialization.Serializable
import java.net.URI

enum class Method {
    POST, GET, DELETE, PUT
}

@Serializable
data class Link(val href: String, val method: Method)

@Suppress("MemberVisibilityCanBePrivate")
@Serializable
abstract class Linked<out T : Linked<T>>(val links: MutableMap<String, Link> = mutableMapOf()) {

    @Suppress("UNCHECKED_CAST")
    open fun addLink(name: String, method: Method, href: URI): T {
        links[name] = Link(href.toString(), method)
        return this as T
    }
}
