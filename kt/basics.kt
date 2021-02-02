/**
* This is Kotlin learning basics
*/

// print a line
fun main() {
    println("Hello, World!")
    println(add(3, 2))
    println(largerOne(3, 2))
    println(largerOne2(3, 2))
}

//define a function
fun add (num1: Int, num2: Int): Int {
    return num1 + num2
}

// if clause
fun largerOne(num1: Int, num2: Int): Int {
    return if (num1 > num2) num1 else num2
}

fun largerOne2(num1: Int, num2: Int): Int = if (num1 > num2) num1 else num2

fun decode(encoded: IntArray, first: Int): IntArray {
    val ans = mutableListOf(first)
    var t = first
    encoded.forEach {
        ans.add(it.xor(t))
        t = it
    }
    return arrayOf(ans)
}

