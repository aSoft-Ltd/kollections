package kollections

import kotlin.collections.toList as kToList

actual inline fun IntArray.toList(): List<Int> = kToList()