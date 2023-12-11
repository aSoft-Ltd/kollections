@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kollections

import kollections.internal.MapEntryImpl
import kollections.internal.MutableMapWrapper
import kotlin.collections.mutableMapOf
import kotlinx.JsExport
import kotlin.js.JsName

private fun <K, V> MapEntry<K, V>.toPair() = Pair(key, value)

fun <K, V> pairOf(key: K, value: V): MapEntry<K, V> = MapEntryImpl(key, value)

infix fun <K, V> K.to(value: V): MapEntry<K, V> = MapEntryImpl(this, value)

@JsName("mutableMapOf")
fun <K, V> iMutableMapOf(vararg pairs: MapEntry<K, V>): MutableMap<K, V> = MutableMapWrapper(pairs.associate { it.toPair() }.toMutableMap())

@JsName("emptyMapOf")
fun <K, V> iMapOf(): Map<K, V> = MutableMapWrapper(mutableMapOf())

@JsName("emptyMap")
fun <K, V> iEmptyMap(): Map<K, V> = MutableMapWrapper(mutableMapOf())

@JsName("mapOf")
fun <K, V> iMapOf(vararg pairs: MapEntry<K, V>): Map<K, V> = MutableMapWrapper(pairs.associate { it.toPair() }.toMutableMap())