@file:OptIn(ExperimentalTypeInference::class)

package kollections

import kotlin.experimental.ExperimentalTypeInference

inline fun <T> buildMutableList(
    @BuilderInference builder: MutableList<T>.() -> Unit
) = mutableListOf<T>().apply(builder)

inline fun <T> buildList(
    @BuilderInference builder: MutableList<T>.() -> Unit
): List<T> = buildMutableList(builder) as List<T> // K1 fails to compile if you remove this

inline fun <T, R> List<T>.map(transform: (T) -> R): List<R> = buildList { for (item in this@map) add(transform(item)) }

inline fun <T, R> List<T>.flatMap(transform: (T) -> List<R>): List<R> = buildList { for (item in this@flatMap) addAll(transform(item)) }