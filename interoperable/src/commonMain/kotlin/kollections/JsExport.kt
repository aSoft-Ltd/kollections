package kollections

@OptIn(ExperimentalMultiplatform::class)
//@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.FUNCTION, AnnotationTarget.FILE)
@SinceKotlin("1.4")
@OptionalExpectation
expect annotation class JsExport()
