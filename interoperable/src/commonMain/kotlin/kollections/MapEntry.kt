@file:JsExport

package kollections

import kotlin.collections.Map as KMap
import kotlin.js.JsExport

interface MapEntry<out K, out V> : KMap.Entry<K, V> {
    override val key: K
    override val value: V
    operator fun component1(): K
    operator fun component2(): V
}