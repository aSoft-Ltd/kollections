package kollections

actual inline fun IntArray.toList(): List<Int> = buildList {
    forEach { push(it) }
}