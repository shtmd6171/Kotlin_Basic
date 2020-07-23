import javax.xml.crypto.Data

fun main() {
  /*
   * 상속 불가, data 처리하기 위해 특화된 클래스
   * () 안에 필드들을 정의할 수 있다
   * { } 안에서도 멤버필드나 메소드를 정의할 수도 있다,주로 메소드를 구현 또는 override를 함
   * data클래스도 멀티리턴처럼 보일 수 있다 (Destructuring Declarations)
   * copy() 함수를 사용한다
   * copy() : 지정한 값을 교체하고 나머지 값들은 원래 그대로 복사해온다
   */

    // 일반 클래스로 데이터 할당하기
    var a = A()
    a.name = "뱀"
    a.power = 3
    // 일반 클래스에서는 클래스를 담은 변수를 출력하면
    // 변수의 주소값이 나온다
    println(a)

    // data 클래스로 데이터 할당하기
    var d  = DataA("곰",10)
    // data class를 변수로 출력하면
    // 클래스가 가지고 있는 생성자 인수 값이 나온다
    println(d)
    // 임의의 값만 설정할 수도 있음
    var d2 = DataA(nLeverl = 3)
    println(d2)

    var d3 = DataA(nLeverl = 11)
    // data class 생성자 인수가 아닌 일반 변수는 변수이름으로 접촉해야 한다
    d3.job = "궁수"
    println(d3.job)

    // d4에서는 d3의 이름만 해당 값으로 바꾸고 나머지는 그대로 복사해온다
    var d4 = d3.copy(name = "동작구")
    println(d4)
    println(d4.job)

    // ( )안에 특정 변수를 나열하고, data class를 값으로 주게되면
    // data class의 변수들이 차례로 들어오게 된다
   var (name, power) = d4
    println("$name $power")

}

class A {
    var name : String = ""
    var power : Int = 0
}



data class DataA(var name : String = "", var nLeverl : Int){
    var job : String = ""
    operator fun plus (d : DataA) {
        this.nLeverl + d.nLeverl
    }
}