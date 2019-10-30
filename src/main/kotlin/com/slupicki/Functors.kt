package com.slupicki

inline fun <T1, T2, T3> ((T1) -> T2).map(crossinline f: (T2) -> T3): (T1) -> T3 = { x -> f(this(x)) }
inline fun <T1, T2> (() -> T1).map(crossinline f: (T1) -> T2): () -> T2 = { f(this()) }
inline fun <T1, T2> T1.map(crossinline f: (T1) -> T2): () -> T2 = { f(this) }

fun main() {
    val f = 10
            .map { a -> a.toString() }
            .map { a: String -> "Step2{$a}" }
            .map { a: String -> "Step3<$a>" }
            .invoke()

    val r = { a: Int -> a.toString() }
            .map { a: String -> "Step2{$a}" }
            .map { a: String -> "Step3<$a>" }

    println("f = ${f}")
    println("r(20) = ${r(20)}")
}