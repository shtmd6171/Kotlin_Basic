fun main() {
 /*
  * Property : 변수를 가져오거나 대입할 때, 함수처럼 프로그래밍이 가능한 것
  *
  * get(), set() 함수로 읽고 쓰기를 관리한다
  *
  * 자기 자신을 가리키는 예약어는 field
  *
  * getter나 setter를 호출하지 않아도 변수에 값을 설정하거나 불러올 때
  * 자동으로 수행내용을 실행하는 구조
  *
  */

    // 기본 사용
    passwd = "123412341234"
    println(passwd)

    // 확장 Property
    val empty = EmptyClass().apply { newProb = "안녕";
                                     newProb = "반가워요";
                                     newProb = "새로운 클래스" }
    println(empty.newProb)

    // MutableList에 확장 Property
    // 인덱스 순서로 삽입을 한다 [0..2]
    val mLog = mutableListOf<String>("Success:100", "Pass:203", "fail:001")
    //mLog.map { println(it) }

    // firstHead에서는 set을 하면 [0]에 삽입하기 때문에 한자리 씩 밀려 후입선출이 된다
    mLog.firstHead = "Success:100"
    mLog.firstHead = "shutdown:-1"
    mLog.forEach { println(">$it") }
    println(mLog.firstHead)


}


var passwd : String = ""
    // getter 작성법
  get() {
      if(field.length > 5){
          field = "길이를 초과했음"
      }
      return field
  }
    // setter 작성법
    // setter를 호출하지 않아도 passwd에 값을 설정하면 자동으로 실행됨
  set(s : String){
      println("${s}를 저장함")
      field = s
  }

class EmptyClass {
    var message : String = ""
}

// 확장 properties
var EmptyClass?.newProb : String
    get(){
        return this!!.message
    }
    // setter를 호출하지 않아도 newProb에 값을 설정하면 message에 값이 쌓인다
    set(value){
        this!!.message = value + "-" + this!!.message
    }

// MutableList에 확장 Properties 추가
var MutableList<String>?.firstHead : String
    get() {
        return this!!.get(0)
    }
    set(value) {
        this!!.add(0, value)
    }
