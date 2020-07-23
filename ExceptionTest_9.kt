import java.lang.Exception

fun main() {
   /*
    * ktl에서는 try-catch 문이 선택조건이다.
    * 프로그래밍 로직에서 예외처리를 권장한다.
    * null 체크가 까다롭다
    * !! : null일 때 종료한다
    * ?  : null일때 뒷 부분을 실행하지 않는다
    */

    var divNumber = 0
    try {
        707 / divNumber // ArithmeticException: / by zero 발생을 위해 실행
    }catch (e : Exception) {
        println(e)
    }finally {
        println("Last")
    }

    var addNumber : Int? = null
    //var sum = addNumber + 100

    // 로직상으로 null을 막으면 코드가 수행 가능함
    if (addNumber != null){
        var sum = addNumber + 100
        println(sum)
    }

    // null 일때 !!를 사용해서 try-catch 없이 예외를 발생시킴킴
    // var sum = addNumber!! + 100
    // println(sum)

    // ?를 통해 addNumber가 null이면 실행되지 않게 함, let은 코딩을 수행하는 역할
    var sum = addNumber?.let{it + 100}
    println(sum)

}