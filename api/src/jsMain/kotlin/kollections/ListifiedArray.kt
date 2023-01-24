package kollections

internal class ListifiedArray<out T> : AbstractList<T>() {
    override val size: Int get() = this.unsafeCast<Array<T>>().size
    override fun get(index: Int): T = this.unsafeCast<Array<T>>()[index]

    override fun equals(other: Any?): Boolean = when (other) {
        is Array<out Any?> -> if (other.size != size) {
            false
        } else {
            var areEqual = false
            for (i in 0 until size) {
                areEqual = other[i] == get(i)
                if (!areEqual) break
            }
            areEqual
        }

        is List<Any?> -> if (other.size != size) {
            false
        } else {
            var areEqual = false
            for (i in 0 until size) {
                areEqual = other[i] == get(i)
                if (!areEqual) break
            }
            areEqual
        }

        else -> false
    }
}