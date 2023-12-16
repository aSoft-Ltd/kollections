@file:Suppress("NOTHING_TO_INLINE")

package kollections

import kotlin.collections.List

actual inline fun <T> listOf(): List<T> = kotlin.collections.listOf<T>() as List<T>

actual inline fun <T> listOf(vararg items: T): List<T> = kotlin.collections.listOf(*items) as List<T>

actual inline fun <T> mutableListOf(): MutableList<T> = kotlin.collections.mutableListOf()

actual inline fun <T> mutableListOf(vararg items: T): MutableList<T> = kotlin.collections.mutableListOf(*items)

actual inline fun <T> List<T>.toList(): List<T> = this as List<T>