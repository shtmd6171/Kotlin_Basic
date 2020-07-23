fun main(args: Array<String>) {
  /*
   * 문법 정도만 인지
   *
   * 다중 인자를 받는 함수를 단일 인자를 받는 함수로 만드는 함수
   *
   * 데이터형 : (인자) -> (인자) -> 리턴값값
   * 함수정의 : 함수 (a) : 리턴값 = 함수 (b) = 함수 (c) : 리턴값 {}
   *
   * 사용법 : 일반함수(a,b,c) 함수 (a)(b)(c)
   *
   */
    // WorkForMoney를 통한 인자 삽입이 전혀 이루어져 있지 않기 때문에
    // alba를 실행하고나서 변수를 삽입해야 한다
    val alba :  (Double) -> (Int) -> (String) -> String = ::WorkForMoney

    // (Double) 타입을 WorkForMoney의 매개변수를 통해 삽입함
    val normal_people : (Int) -> (String) -> String = WorkForMoney(25000.0)

    val developer : (Int) -> (String) -> String = WorkForMoney(35000.0)

    // (Double) 타입과 (Int) 타입을
    // WorkForMoney의 매개변수, 단일 인자로 분리한 함수 통해 삽입함
    // 각 함수는 단일 인자로 ( ) 를 분리해 사용함
    val HighIncome : (String) -> String = WorkForMoney(35000.0)(8*5*5)

    // listof로 각 람다식 함수를 리스트를 받는데
    // 제너릭 형태도 함수 형태에 맞게 ()->String 형태로 선언하고
    // 함수에서 리턴되는 값을 출력한다다
   listOf<()->String>(
        {alba(7800.0)(8*5*4)("알바")},
        {normal_people(8*5*4)("일반인")},
        {developer(8*5*4)("개발자")},
        {HighIncome("?")}
    ).map { println(it()) }


}

// 다중 인자를 받던 (Int, String) 대신 (Int) -> (String) 로 분해하고
// Int와 String 타입 하나씩만을 받는 함수를 = 을 통해 정렬한다
fun WorkForMoney (moneyByHour : Double) :
            (Int) -> (String) -> String
            = fun (time : Int)
            = fun (job : String) : String {
        return if (time > 8 * 5 * 4) "${job}손해"
            else "${job}, ${moneyByHour * time}을 받는다"

    }