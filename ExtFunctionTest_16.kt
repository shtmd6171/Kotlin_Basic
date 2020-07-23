fun main() {
   /*
    * 중요한 함수 4가지
    *
    * - let : .let{ } 다음 결과를 {} 안에 넘긴다 ->를 사용할 경우 변수명 지정이 가능하다
    * - apply() : .apply{ } 객체(생성과 동시) 결과를 {}를 통해 넘긴다
    * - run()  : .run{ } 객체는 생성되어있어야 하고 주로 .let과 이용한다
    * - also : .also{ } 객체의 값을 넘겨주지 않는다
    */

    //1. let
        // 모든 객체(상수,변수,함수 등)에서 확장 함수로 사용 가능, 객체의 최종 값을 넘겨받는 역할
        // 변수로 함수를 받는 방법과 같으나 더 간단한 표현 방식임 !
        // 원래의 형식은 f1().let ( { value -> println(value)} )와 같고
        // let()내부에서 람다식을 사용하는 것과 같음
        // 함수의 값을 이용해 다양한 수행작업들을 람다식을 통해 구현 가능
    f1().let { value -> println(value)}
    f1().let{ println (it)} // default 값은 it

        // 상수에서 사용
    1234.let{it + 1}.let { it * 3 }.let { println(it) }

    var add = {a : Int, b : Int -> a + b}
    add(1,2).let { println(it) }

    var bug : () -> Any? = { null }
    bug()?.let { println(it) } // ? 를 통해서 값이 null이라 뒷 부분이 실행되지 않음

    // 2. apply()
        // 객체를 생성과 동시에 (클래스인수가 아닌) 일반 멤버변수 값을 초기화해 변수에 저장하는 기능을 함
        // 원래 객체 멤버변수 초기화를 위해선 클래스변수에 값을 옮기거나 하나씩 적용해야 했다
    var obj = Test().apply { sName = "둘리" ; nAge = 250 ;}
    obj.aboutMe()

    // 3. run()
        // 생성과 동시가 아닌 이미 생성된 객체에서만 사용할 수 있다
        // 객체 내부의 값을 지정하거나 수정하는 작업 내용의 값을 넘겨주고 싶을 때 사용한다
        // let은 객체의 마지막 값만을 받기 때문에 it에는 sName인 마이콜만 받게 된다
    obj.run { sName }.let { println(it) }
    obj.run { sName = "마이콜" ; nAge = 28 ; sName}.let { println(it) }
        //  실행결과를 변수 선언과 같은 작업 없이 수행하고 싶을 때 주로 사용함
    run{333 + 7}.let { println(it) }

    // 4. also
        // 결과값을 넘겨주지 않아 뒷 값에 영향을 주지 않는다
    100.let { println(it); it }
        .also { println(it + 1000) }
        .also { println(it + 20) }
        .let { println(it); it }


}

fun f1() = 10

class Test {
    var sName : String = "고길동"
    var nAge : Int = 49
    fun aboutMe() = println("이름은 ${sName}이고 나이는 ${nAge}살이다")
    fun aging() = nAge++
}





