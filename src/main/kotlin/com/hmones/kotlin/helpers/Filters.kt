package com.hmones.kotlin.helpers

inline fun <reified T> T.filterIfAllNulls(): T? {
    if (T::class.isData) {
        val properties = T::class.java.declaredFields ?: return null
        for (property in properties) {
            property.isAccessible = true
            if (property[this] != null) {
                return this
            }
        }
        return null
    }

    return this
}
