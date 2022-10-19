@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kollections

import kotlin.collections.mutableListOf as kMutableListOf
import kollections.internal.MutableListWrapper
import kollections.internal.EmptyList
import kotlin.js.JsExport
import kotlin.js.JsName

@JsName("emptyMutableList")
fun <E> iMutableListOf(): MutableList<E> = MutableListWrapper(kMutableListOf())

@JsName("mutableListOf")
fun <E> iMutableListOf(vararg elements: E): MutableList<E> = MutableListWrapper(kMutableListOf(*elements))

@JsName("emptyListOf")
fun <E> iListOf(): List<E> = EmptyList

@JsName("emptyList")
fun <E> iEmptyList(): List<E> = EmptyList

@JsName("listOf")
fun <E> iListOf(vararg elements: E): List<E> = iMutableListOf(*elements)