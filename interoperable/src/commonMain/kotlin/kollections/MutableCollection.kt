@file:JsExport

package kollections

import kotlin.js.JsExport

interface MutableCollection<E> : MutableCollectionLike<E>, Collection<E>