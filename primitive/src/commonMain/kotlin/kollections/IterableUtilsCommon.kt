@file:OptIn(ExperimentalTypeInference::class)

package kollections

import kotlin.experimental.ExperimentalTypeInference
import kotlin.jvm.JvmName
import kotlin.collections.List as KList
import kotlin.collections.buildList as kBuildList

inline fun <T> Iterable<T>.contains(item: T): Boolean = find { it == item } != null

inline fun <T> Iterable<T>.toKList(): KList<T> = kBuildList { this@toKList.forEach { add(it) } }

inline fun <T> Iterable<T>.partition(crossinline predicate: (item: T) -> Boolean): Pair<List<T>, List<T>> {
    val passed = mutableListOf<T>()
    val failed = mutableListOf<T>()
    forEach { (if (predicate(it)) passed else failed).add(it) }
    return passed to failed
}

inline fun <T, I : Iterable<T>> I.onEach(crossinline fn: (item: T) -> Unit): I {
    forEach { fn(it) }
    return this
}

inline fun <T, R : Any> Iterable<T>.mapNotNull(crossinline fn: (item: T) -> R?): List<R> = buildList {
    this@mapNotNull.forEach {
        val res = fn(it)
        if (res != null) add(res)
    }
}

inline fun <T> Iterable<T>.filterNotNull(): List<T & Any> = filter { it != null } as List<T & Any>

inline fun <T> Iterable<T>.reduce(crossinline reducer: (acc: T, item: T) -> T): T {
    var count = 0
    var reduced: T? = null
    forEach {
        val r = reduced
        if (r == null) {
            reduced = it
        } else {
            reduced = reducer(r, it)
        }
        count++
    }
    if (count == 0) throw NoSuchElementException("Collection is empty")
    return reduced as T
}

@JvmName("sumOfDouble")
@OverloadResolutionByLambdaReturnType
inline fun <T> Iterable<T>.sumOf(@BuilderInference crossinline fn: (item: T) -> Double): Double {
    var sum = 0.0
    forEach { sum += fn(it) }
    return sum
}

@JvmName("sumOfInt")
@OverloadResolutionByLambdaReturnType
inline fun <T> Iterable<T>.sumOf(crossinline fn: (item: T) -> Int): Int {
    var sum = 0
    forEach { sum += fn(it) }
    return sum
}

@JvmName("sumOfUInt")
@OverloadResolutionByLambdaReturnType
inline fun <T> Iterable<T>.sumOf(crossinline fn: (item: T) -> UInt): UInt {
    var sum = 0u
    forEach { sum += fn(it) }
    return sum
}

@JvmName("sumOfLong")
@OverloadResolutionByLambdaReturnType
inline fun <T> Iterable<T>.sumOf(crossinline fn: (item: T) -> Long): Long {
    var sum = 0L
    forEach { sum += fn(it) }
    return sum
}

@JvmName("sumOfULong")
@OverloadResolutionByLambdaReturnType
inline fun <T> Iterable<T>.sumOf(crossinline fn: (item: T) -> ULong): ULong {
    var sum = 0uL
    forEach { sum += fn(it) }
    return sum
}

@JvmName("sumOfDouble")
inline fun Iterable<Double>.sum(): Double = sumOf { it }

@JvmName("sumOfLong")
inline fun Iterable<Long>.sum(): Long = sumOf { it }

@JvmName("sumOfInt")
inline fun Iterable<Int>.sum(): Int = sumOf { it }

fun <E, R : Comparable<R>> Iterable<E>.maxOf(selector: (E) -> R): R {
    val iterator = toList().iterator()
    if (!iterator.hasNext()) throw NoSuchElementException()
    var maxValue = selector(iterator.next())
    while (iterator.hasNext()) {
        val v = selector(iterator.next())
        if (maxValue < v) {
            maxValue = v
        }
    }
    return maxValue
}

fun <E, R : Comparable<R>> Iterable<E>.minByOrNull(selector: (E) -> R): E? {
    val iterator = toList().iterator()
    if (!iterator.hasNext()) return null
    var minElem = iterator.next()
    if (!iterator.hasNext()) return minElem
    var minValue = selector(minElem)
    do {
        val e = iterator.next()
        val v = selector(e)
        if (minValue > v) {
            minElem = e
            minValue = v
        }
    } while (iterator.hasNext())
    return minElem
}

fun <E> Iterable<E>.take(n: Int): List<E> {
    if (n <= 0) return emptyList()
    return buildList {
        var count = 0
        this@take.forEach {
            if (count < n) add(it)
            count++
        }
    }
}

fun <K, V> kollections.Map<K, V>.toKMap(): kotlin.collections.Map<K, V> = this.mapValues {
    it
}.values.toKList().associate {
    it.key to it.value
}
