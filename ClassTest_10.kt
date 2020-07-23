fun main() {
    /*
     * ktl에서는 class와 파일명이 달라도 상관없음
     * 클래스는 class 이름 {} 의 형태
     * 생성자는 constructor(){} 또는 class이름 (변수명 : 변수형){}
     *
     * ktl에서는 기본으로 상속이 금지되어 있고,
     * 부모클래스를 open class 이름{}으로 해야 상속이 가능
     * 상속은 class 이름 : 부모클래스명(생성자인자){} 형식이다다
     */

    Test1().showInfo()
    Test1("PSW",50).showInfo()

    // 여기서 홍길동은 Test2 (name : String) 에서의
    // 함수처럼 생성한 생성자의 name으로 둘리와는 다른 값으로 지정된다
    Test2("홍길동").showInfo()
    Test2("둘리",500).showInfo()

    // ChildClass의 m은 부모클래스의 생성자인수로 넘어간다
    ChildClass("Hi").sayHello()

}

class Test1 {
    var sName : String = "Test1"
    var nAge : Int = 10

    constructor(){
        println(this.toString())
    }

    constructor(name : String, Age : Int){
        sName = name
        nAge = Age
    }

    fun showInfo () = println("${sName} : ${nAge}")
}

// class의 () 에서 생성자에서 생성할 매개변수를 초기에 만들어 줄 수 있다
// 마치 생성자를 함수식으로 생성하는 것
class Test2 (name : String){
    var sName : String = "Test2"
    var nAge : Int = 10

    // 생성자 인자를 초기화 할 때 씀
    init {
        sName = name
    }

    // 여기서 name은 class에서 초기에 넘어오는 값과 다른 값으로
    // 생성자에서 동일한 이름으로 다른 값을 받고 싶다면
    // : this(name) 를 통해 위의 name과 다름을 알려줘야 한다
    constructor(name : String, age : Int) : this(name){
        sName = name
        nAge = age
    }

    fun showInfo () = println("${sName} : ${nAge}")
}

// 부모 클래스는 open class로 만들어줘야 한다
open class ParentClass (msg : String) {
    var message = msg
    fun sayHello() = println(message)
}

class ChildClass(m : String) : ParentClass( m ){
}