@file:JsExport

package kollections

import kotlinx.JsExport

interface Collection<out E> : CollectionLike<E>, FunctionalCollection<E>