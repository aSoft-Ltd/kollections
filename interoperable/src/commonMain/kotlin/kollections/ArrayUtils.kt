package kollections

import kollections.internal.MutableListWrapper

inline fun <E> Array<E>.toIList(): List<E> = MutableListWrapper(toMutableList())