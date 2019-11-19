package klib.functions

inline fun runRandom(range: IntRange = IntRange(1, 10), target: Int = 5, block: () -> Unit) {
    if (range.random() == target) {
        block()
    }
}