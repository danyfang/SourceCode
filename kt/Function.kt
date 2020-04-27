import kotlin.math.max


fun largeNumber1(num1: Int, num2: Int) : Int {
    return max(num1, num2)
}

fun largeNumber2(num1: Int, num2: Int) : Int {
    var value = 0
    if (num1 > num2) {
       value = num1
    } else {
       value = num2
    }
    return value
}

fun largeNumber3(num1: Int, num2: Int) : Int {
    val value = if (num1 > num2) { num1 } else { num2 }
    return value
}

fun largeNumber4(num1: Int, num2: Int) : Int {
    return if (num1 > num2) {num1} else {num2}
}

fun largeNumber5(num1: Int, num2: Int) = if (num1 > num2) {
    num1
} else {
    num2
}

fun largeNumber6(num1: Int, num2: Int) = if (num1 > num2) num1 else num2


fun main() {
    val a = 9
    val b = 10
    println("The larger one is: " + largeNumber1(a, b))
    println("The larger one is: " + largeNumber2(a, b))
    println("The larger one is: " + largeNumber3(a, b))
    println("The larger one is: " + largeNumber4(a, b))
    println("The larger one is: " + largeNumber5(a, b))
    println("The larger one is: " + largeNumber6(a, b))    
}