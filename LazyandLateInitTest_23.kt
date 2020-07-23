import java.util.*

fun main(args: Array<String>) {
/*
 * 늦은 초기화는 메모리 효율이나 에러 방지차원으로 주로 사용함
 * lateinit 과 lazy 키워드를 사용함
 *
 * lateinit ( lateinit var 변수명 : 타입 )
 * - lateinit 예약어는 클래스에서 초기화 없이 변수 : 타입 만으로 선언 가능
 * - var 만 사용이 가능하고, 변수형이 nullable이 아니더라도 컴파일이 가능함
 * - 초기화 전에는 사용이 불가함
 * - primitive 형은 불가능
 *
 * lazy ( val 변수명 : 타입 by lazy { 초기화 항목 } )
 * - 코드 어디선가 사용할 때, 1회 초기화 실행된다
 * - val 로 선언하고, primitive 형도 가능하다
 * - 초기화 실행시 코딩도 가능함
 *
 */

    //lateinit
    var l = LateInitTest()
    l.Test()

    var l2 = LazyInitTest()
    l2.Test2()






}

class LateInitTest {
    var normalValue : Int = 3
    var inittest : Int //선언시 초기화 해줘야 하는 일반 변수

    // 선언 = 초기화를 안해도 된다
    lateinit var late : String

    init {
        inittest = 0
    }

    fun Test(){
        this.late = "초기화!"
        println(this.late)
    }

}

class LazyInitTest {
    val lazy1 : String by lazy {
        "lazy 초기화!"
    }
    val lazy2 : Int by lazy {
        println("한번만 실행")
        Random().nextInt(100)
    }

    fun Test2() {
        println(lazy1)
        // 초기화가 한번 이루어지기 때문에 여러번 실행해도 같은 값이 등장한다
        println(lazy2)
        println(lazy2)
    }
}