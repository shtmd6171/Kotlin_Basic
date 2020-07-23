fun main() {
  /*
   * Object keyword는 3가지 형태로 사용된다
   * - class명 앞에서 사용해서 static class로 선언
   *
   * - class 내부의 특정멤버들만 static(companion object)
   *
   * - 미구현(abstract) 클래스를 상속받아 구현해야 하는 메소드를 객체에 담아 사용할 때
   *
   *
   *
   *
   *
   */

    // static class처럼 변수를 선언하지 않고 직접 함수를 실행함
    SingleTon.showMessage("싱글톤입니다")

    // 일반적으로 사용하는 멤버변수
    val obj = StaticTest()
    println(obj.msg)

    // static으로 생성한 멤버변수와 멤버메소드를 변수 선언없이 직접 실행함
    println(StaticTest.staticVar)
    StaticTest.staticFunc()


    // abstract 클래스를 변수에 저장하기 위해서는
    // 먼저 abstract의 메소드가 구현되어있어야 쓸 수 있기 때문에
    // object : 를 통해서 저장과 동시에 메소드를 구현할 수 있다
    var obj2 = object : fakeClickHandler(){
        override fun onClick() {
            println("Click")
        }
    }
    obj2.onClick()




}

// class 명 대신 object를 사용해서 static class로 사용하는 방법
object SingleTon {
    var showMessage = { msg : String -> println(msg)}
}

class StaticTest{
    var msg : String = "일반 객체로 이 변수 액세스"

    companion object{
        var staticVar = "StaticTest.staticVar"
        fun staticFunc() = println("StaticTest.statucFunc")
    }
}

abstract  class fakeClickHandler {
    abstract fun onClick()
}