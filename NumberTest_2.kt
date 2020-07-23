fun main() {
    var doubleV : Double = 110.1111
    var floatV : Float = 110.0f
    var longV : Long = 110
    var intV : Int = 20
    var shortV : Short = 30
    var byteV : Byte = 10

    println(doubleV)
    println(floatV)
    println(intV)

    // doubleV = intV as toDouble()
    // as 를 사용하는 형변환은 기본형타입이 아닌 참조형에서만 사용 가능

    doubleV = intV.toDouble() // doubleV = 20.0
    val sum = "123".toInt()+10
    println(sum)

}