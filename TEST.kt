fun main() {
    // ktl에서는 변수형을 선언하지 않아도 값에 따라 자동으로 정해진다
    // ';' 를 사용하지 않아도 된다
    // var name : Int = 222 와 같은 형식으로 형을 정해줄 수도 있다
    var name = 222

    // null 값에 대해 엄격하기 때문에 null 허용을 위한 변수는 ? 로 정의해야 한다
    //var name2 : String = null (오류)
    var name2: String? = null

    // kt 파일은 내부적으로  Class로 재구성한다 (컴파일시 out 밑에 생성)

    println("종결자 없이도 가능")

    //var는 읽기쓰기 / val는 읽기전용
    var nCount : Int = 0
    var name3 = "psw"

    // 읽기전용의 변수에서는 값을 변경할 수 없음음
    var age = 0
    // age++




}