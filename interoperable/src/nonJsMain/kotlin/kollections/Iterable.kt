@file:JsExport

package kollections

import kotlin.collections.Iterable as KIterable
import kotlin.js.JsExport

actual interface Iterable<out E> : KIterable<E>