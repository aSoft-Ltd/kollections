@file:JsExport

package kollections

import kotlin.js.JsExport

interface Collection<out E> : CollectionLike<E>, FunctionalCollection<E>