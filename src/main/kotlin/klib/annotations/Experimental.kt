package klib.annotations

import kotlin.Experimental

/**
 * Experimental Annotation for Experimental Public API Interfaces
 *
 * @since 0.1.5
 * @author Nils Rider
 */
@Target(AnnotationTarget.CLASS)
@Experimental(Experimental.Level.WARNING)
annotation class Experimental