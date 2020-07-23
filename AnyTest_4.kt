import java.util.*

fun main() {
    /* ktl에서 Any형은 동적타입을 지원함
     * - 어떠한 형을 대입시켜도 처리가능한 변수형
     * - 최종 대입된 값으로 형이 결정됨
     * - null은 마찬가지로 엄격히 구분 '?'로 정의
     *
     * 왜 사용함?
     * - Any를 자주 사용하는 함수 (문자열 처리를 위해)
     * - Unit형 (값이 없음을 정의하는 형)
     * - Nothing형 (미래가 없음을 알리는 형)
     */

    var everybody : Any

    everybody = 1111
    everybody = "문자열 테스트"
    everybody = 221.01010
    everybody = 12.00f

    // is 는 변수형을 확인하는 논리연산자이다
    if (everybody !is String){
        if (everybody is Float){
            println("Float")
        }
    }

    // ?  를 통해 정의해야만 null 값을 대입할 수 있음
    //var everybody2 : Any? = null

    // 비교연산자 2개 방식을 이용해 확인하는 방법
    println(everybody == 12.00f)
    println(everybody.equals(12.00f))



    // 함수를 Any형 변수로 처리했기 때문에 변수 a가 어떤 형태이든 값 처리를 용이하게 함함
    Allprint(123123)
    Allprint('a')
    Allprint(Date())

    // Unit형
    // 변수형과 리턴값이 존재하지 않는 함수형 변수를 선언만 했음
    var pFuncTEST : (Unit) -> Unit

    // 여기서 pFunc는 함수형 변수로
    // String 타입을 매개변수로 받지만 return 타입이 없는 (void와 같음) 것을 선언함
    // 함수형 변수는 = { } 를 통해서 함수 내용을 정의할 수 있음
    // it은 넘겨진 매개변수 하나의 값을 의미함
    var pFunc : (String) -> Unit = { println(it)}
    pFunc("hello, there")


    // Nothing형
    // Exception을 발생시키고 프로그램 종료를 위해 필요함
    // todo 내용 밑부터는 실행되지 않고 종료되는데 다른사람과의 협업 등에 사용됨
    TODO("이거 구현해야 해요. 일단 실행했으니 종료함")

}

fun Allprint ( a : Any) = println(a.toString())