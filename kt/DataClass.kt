data class Cellphone(val brand: String, val price: Double)

fun main(){
    val cp1 = Cellphone("Huawei", 3999.99)
    val cp2 = Cellphone("Huawei", 3999.99)

    println(cp1)
    println("Cellphone 1 equals cellphone 2" + (cp1 == cp2))
}
