package kollections

actual fun <T> chainOf(): Chain<T> = js("[]").unsafeCast<ListifiedArray<T>>()