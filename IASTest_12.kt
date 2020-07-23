fun main() {
  /*
   * interface는 interface 이름{} 으로 정의, override를 위해 open으로 정의할 필요가 없음
   *
   * abstract class는 구현상속할 메소드도 abstract로 정의해야 한다. 상속에서는 override정의
   *
   * static을 사용하려면 클래스 내에 companion object{}를 만들고
   * 그 안에 메소드나 멤버필드를 정의해야한다다
   *
   */

    //interface
    var face : InterTest = Imp1()
    interFaceTest(face)
    var face2 : InterTest = Imp2()
    face2.TestFunc()

    //abstract
    var abst = Imp4()
    abst.TestFunc()
    abst.abstFunc()
    // Imp4.testFunc() static 아니라서 안됨

    //static
    println(Imp4.staticVar)
    Imp4.staticFunc()


}

// Interface
fun interFaceTest (pInter : InterTest){
    pInter.TestFunc()
}

interface InterTest {
    fun TestFunc()
}

interface InterTest2 {
    fun TestFunc2()
}

// 구현을 위해 상속과 같이 : 를 사용한다
class Imp1 : InterTest{
    override fun TestFunc() {
        println("Imp1")
    }
}

class Imp2 : InterTest{
    override fun TestFunc() {
        println("Imp2")
    }
}

// Java와 같이 다중 상속을 지원함
class Imp3 : InterTest, InterTest2 {
    override fun TestFunc() {
    }
    override fun TestFunc2() {

    }
}


// abstract, static
abstract class AbstTest{
    fun TestFunc() = println("TEST")
    abstract fun abstFunc()
}

// abstract를 구현할 때는 interface와 다르게 생성자인수 부분을 포함하여야 한다
class Imp4 : AbstTest() {
    override fun abstFunc() {
        println("ABSTRACT TEST")
    }

    // static의 기능을 수행하는 내용
    companion object {
        var staticVar = "companion staticVar"
        fun staticFunc() = println("companion staticFunc")
    }
}