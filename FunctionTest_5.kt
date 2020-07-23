fun main() {
 /*
  * fun 함수명 (변수명 : 데이터 형, ...) : 리턴 형 {return}
  * 한 줄로 표현 가능한 함수는 {} 대신 = 로 정의가 가능함
  * 함수형 변수의 값 : {변수정의 -> 코드구현}
  * 함수형 변수의 형 : (입력정의) -> 리턴정의
  */
 println(testFunc(3))
 println(testFunc2(3))
}

fun funByReturn (s : String) : Any? {
    return s
}

fun funByParameter(i : Int, s: String) {
    println(i.toString() + s)
}

fun funByLine(i : Int, j : Int) = i * j

// f라는 변수를 받는데, f는 함수로 취급할 것이기 때문에
// -> 를 사용해 매개변수타입과 리턴타입을 지정한다
// f인 변수는 매개변수 없이, 리턴타입은 자유롭게 받는다
// 여기서 f는  아래의 변수형 함수를 받기위해 생성한 것임
fun HigherFunc( f: () -> Any?) {
    f()
}



// 람다식
// 함수형 변수에 값을 넣는 방식
// {} 안에 -> 좌측에는 매개변수와 타입을 선언하고
// -> 우측에는 구현될 코드를 적는다
// 함수형 변수 = {매개변수명 : 매개변수 타입 -> 구현될 내용}
val funcVar = {s : String -> println(s)}
val funcVar2 : (String) -> Unit = { println(it)}
// 함수형 변수의 형을 지정하는 방법
// :: 는 해당 함수의 주소값을 넘겨줌 (해당 함수를 사용할 수 있게 함)
// 함수형 변수명 : 매개변수 타입 -> 리턴타입
var funcVarType : (String) -> Any? = ::funByReturn

// testFunc와 testFunc2는 같은 내용을 가지고 있다
var testFunc : (Int) -> Int = {i ->  i * 10}

fun testFunc2 (i : Int) : Int {
    return i * 10
}











