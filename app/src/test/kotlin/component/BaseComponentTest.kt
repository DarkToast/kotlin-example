package component

import kotlinx.serialization.json.Json

open class BaseComponentTest {
    protected val json = Json { isLenient = true }
}