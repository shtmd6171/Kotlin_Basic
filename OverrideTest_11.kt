fun main() {
  /*
   * ktl에서의 오버로딩, 오버라이딩
   * - 부모 클래스에서 메소드와 필드를 open으로 정의한다
   * - 상속받은 클래스에서 override로 정의한다
   * - 오버로딩은 자바와 동일
   */

    // 클래스 생성시 객체 생성없이 변수에 삽입한다
    var obj1 = baseClass ()
    obj1.f1()

    var obj2 = chileClass()
    obj2.f1()
    obj2.f2()
    obj2.f2("문자열")
    obj2.f2("문자열",3)

    var s = Student("홍길동")
    (0..99).forEach { s.inc() }
    s.printMe()

    var s2 = Student("고길동")
    s2.nScore = 50

    println("두학생의 점수는 ${s2.plus(s)}")
}

open class baseClass{
    // 부모 클래스의 메소드와 필드를 전부 open으로 정의
    open var name = "base"
    open fun f1() = println(this.toString())

    private fun onlyMyFunc() = println("내부사용")

    constructor(){
        onlyMyFunc()
    }
}

class chileClass : baseClass(){
    // override 키워드를 붙여서 재정의함 (자바에서는 @Override)
    override var name = ""
    override fun f1() = println("${this.toString()} 재정의")

    fun f2() = println("f2")
    // overloading
    fun f2(s : String) = println("f2:$s")
    fun f2(s : String, num : Int) = println("f2:$s, $num")
}

// 연산자 오버로딩
class  Student (s : String){
    var name : String = s
    var nScore : Int = 0


    // operator를 통해서 연산자 오버로딩을 할 수 있다
    // class의 nScore와 메소드에서 생성한 nScore를 더한다
    operator fun plus (student: Student) : Int {
        return student.nScore + this.nScore
    }

    // class의 nScore를 증가시킨다
    operator fun inc() : Student {
        this.nScore++
        return this
    }

    fun printMe () = println("${name}은 점수가 $nScore")
}

