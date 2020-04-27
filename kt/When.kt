import java.util.Scanner

fun getScore1(name: String) = if (name == "Tom") {
  86
} else if (name == "Jim") {
  77
} else if (name == "Jack") {
  95
} else if (name == "Lily") {
  100
} else {
  0
}

fun getScore2(name: String) = when (name) {
    "Tom" -> 86
    "Jim" -> 77
    "Jack" -> 95
    "Lily" -> 100
    else -> 0
}

fun getScore3(name: String) = when {
    name == "Tom" -> 86
    name == "Jim" -> 77
    name == "Jack" -> 95
    name == "Lily" -> 100
    else -> 0
}

fun checkNumber(num: Number) = when (num) {
    is Int -> println("Number is int")
    is Double -> println("Number is Double")
    else -> println("number not supported")
}


fun main(args: Array<String>) {
    println("Score is " + getScore1("Tom"))
    println("Score is " + getScore2("Jack"))
    println("Score is " + getScore3("Jim"))

    val input = readLine()!!.split(' ').map(String::toInt)
    for (i in input) {
    	checkNumber(i)
    }
}
