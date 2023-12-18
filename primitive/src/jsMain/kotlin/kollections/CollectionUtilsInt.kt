package kollections

actual fun Collection<Int>.toIntArray(): IntArray = toList().unsafeCast<Array<Int>>().toIntArray()