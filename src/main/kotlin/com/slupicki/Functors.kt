package com.slupicki

inline infix fun <T1, T2, T3> ((T1) -> T2).map(crossinline g: (T2) -> T3): (T1) -> T3 = { x -> g(this(x)) }

fun main() {

    val fString = { a: Int -> "Step1($a)" } map { a: String -> "Step2{$a}" } map { a: String -> "Step3<$a>" }

    println("fString(42) = ${fString(42)}" )
}