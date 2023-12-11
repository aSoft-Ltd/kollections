@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kollections

import kotlin.collections.mutableSetOf as kMutableSetOf
import kollections.internal.MutableSetWrapper
import kollections.internal.EmptySet
import kotlinx.JsExport
import kotlin.js.JsName

@JsName("emptyMutableSet")
fun <E> iMutableSetOf(): MutableSet<E> = MutableSetWrapper(kMutableSetOf())

@JsName("mutableSetOf")
fun <E> iMutableSetOf(vararg elements: E): MutableSet<E> = MutableSetWrapper(kMutableSetOf(*elements))

@JsName("emptySetOf")
fun <E> iSetOf(): Set<E> = EmptySet

@JsName("emptySet")
fun <E> iEmptySet(): Set<Nothing> = EmptySet

@JsName("setOf")
fun <E> iSetOf(vararg elements: E): Set<E> = iMutableSetOf(*elements)