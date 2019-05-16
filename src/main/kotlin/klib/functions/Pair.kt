package klib.functions

/**
 * Create a Pair of A and B
 *
 * @param first First Pair Element
 * @param second Second Pair Element
 * @return Pair(first, second)
 *
 * @see pairOf
 *
 * @since 1.1.0
 * @author Nils Rider
 */
fun <A, B> p(first: A, second: B) = pairOf(first, second)

/**
 * Create a Pair of A and B
 *
 * @param first First Pair Element
 * @param second Second Pair Element
 * @return Pair(first, second)
 *
 * @since 1.1.0
 * @author Nils Rider
 */
fun <A, B> pairOf(first: A, second: B) = Pair(first, second)