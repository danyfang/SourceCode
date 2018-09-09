val greetings = new Array[String](3)
greetings(0) = "Hello"
greetings(1) = ","
greetings(2) = "World"

for (i <- 0 to 2){
    print(greetings(i))
    print(greetings.apply(i))
}

println("exit")
