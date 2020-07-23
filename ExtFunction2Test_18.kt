fun main(args: Array<String>) {
/*
 * 확장함수는 이미 정의된 클래스에 멤버함수를 정의하는 것
 * 확장함수 실행과 동시에 객체 정보를 공유할 수 있다
 * 확장함수로 넘겨진 파라메터는 val로 설정된다
 * 확장함수에 파라미터로 함수를 넘기면 객체설정 및 이벤트 핸들러를 구현하기 편해진다
 *
 *
 *
 */

    // 1. 이미 정의된 클래스에 확장함수
        // 이미 정의된 String이라는 클래스에 . 를 통해 확장적으로 함수를 사용할 수 있음
        // 사용 범위 밖에서는 이용이 불가능함
   fun String?.myFuntions (s : String, n : Int) : String?{
        var sTooManyTalk = "$this : added \n"
        (1..n).forEach { sTooManyTalk+= "${s+" good"}\n" }

        return sTooManyTalk
    }

    println("hello".myFuntions("HI",10))

    // 2. 파라메타로 확장함수 -> 객체에서 실행
        // 람다식 함수를 통해서 ani의 파라미터인 extFunc : Animal.() -> Unit 에 맞게
        // Animal의 함수인 crying(), eat() 변수인 nCount를 생성과 동시에 초기화 해줬음
    var obj = ani(4, {
        crying()
        eat()
        nCount = it
    })

    println("증가된 숫자는 ${obj.nCount}")

    // 3. 객체멤버 접근

    // 4. Android에서 보게될 코드
        // nCount와 message를 넘기고 extFunc가 작동할 코드를 작성한다
        // setOnEvent의 extFunc(nCount)는 결국 (1..nCount) 만큼 { } 내부의 코드를 반복하게 된다
    obj.setOnEvent(3,"울어",{nCount -> println("${nCount}번 운다")
        (1..nCount).map { crying() }})


}

// extFunc 라는 확장함수 변수는 Animal 의 파라메터를 받지 않고, return 타입이 없는 것
// n 은 외부에서 Animal 형의 확장함수를 초기화 하는것 뿐만 아니라 어떤 값을 받을 수 있는 것을 보여줌
fun ani(n : Int,  extFunc : Animal.(Int) -> Unit) : Animal{
    var anii = Animal()

    // extFunc를 생성한 적이 없으나 외부에서는 extFunc를 통해
    // Animal.() -> Unit 형태의 Animal 함수와 변수 값을 받게 되서 extFunc()에 실제 값이 들어오게 되고
    // Animal()를 받은 anii의 변수는 extFunc()가 외부를 통해 받은 값들을 리턴해주는 역할을 함
    anii.extFunc(n)
    return anii
}



class Animal {
    open var nCount = 0
    fun crying() = println("$this >> 어흥")
    fun eat() = println("$this >> 우걱우걱")
    open fun setOnEvent(nCount: Int, message: String, extFunc: Animal.(Int) -> Unit): Animal {
        when (message) {
            "울어" -> {
                extFunc(nCount)
            }
            "먹어" -> {
                var n = if (nCount < 3) 3 else nCount; extFunc(n)
            }
            else -> {
                println("알수없는 메시지 ${message}")
            }
        }
        return this
    }
}