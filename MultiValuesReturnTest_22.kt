fun main(args: Array<String>) {
  /*
   * MultiValuesReturn
   * 우측의 값을 좌측의 변수로 나누어 순서대로 대입하는 것
   *
   * 좌측 ()안에 변수를 나열하고 우측에는 Data class, List, Pair Collection의 반환값 적어
   * 순서대로 특정범위까지 가져오는 방식
   */

    // 1. Extract
        // listOf에 MultiValues 삽입
    val (v1, v2, v3) = listOf("Kotlin",32,123.0f)
    println("$v1$v2$v3")

        // DataClass에 MultiValues 삽입
    val(name, grade) = StudentA("name",32)
    // val(name, grade) = StudentB  일반 클래스에서는 사용이 불가능 함

    // 2. List 파티션으로 나누기
        // map은 인스턴스를 기준으로 배열을 만들어
        // 값을 삽입하기 위해 사용한다
        // 여기서 it은 앞의 반복 조건을 뜻함
    val list = (0..10).map{ StudentA("name : ${it}", it )}
    println(list)

        // partition을 사용하면 { }의 값을 기준으로 list를 Extract함
    val (l1,l2) = list.partition { it.grade in (0..4) }
    println("l1")
        // map은 l1의 객체들을 정렬된 배열형식으로 보여주기 위해 사용함
        // l1의 각 객체들을 .map을 통해 배열의 원소들이 분해된 상태로 저장되어 있고
        // 여기서 it은 분해된 배열 원소들을 뜻한다
        // 만약 println(l1)을 사용하게 되면 각 배열이 원소별 분해 없이 배열 전체가 덩어리로 출력된다
    l1.map { println(it) }
    println("l2")
    l2.map { println(it) }


    // 3. 순위별로 가져오기
    val (n1,n2,n3) = (0..100)
            // filter는 { }의 조건에 따라 배열을 새롭게 구성한다
            // 여기서는 filter를 통해서 0~100의 배열 중 짝수로만 구성된 배열을 생성한 것이다
        .filter { it % 2 == 0 }
            // sortedByDescending은 배열 값을 내림차순으로 배치하는 것이다
            // sortedBy 만을 쓰면 오름차순으로 정렬된다
        .sortedByDescending { it }
    println(n1.toString())
    println(n2.toString())
    println(n3.toString())

}

data class StudentA (var name : String, var grade : Int)
class StudentB (){
    var name : String = ""
    var grade : Int = 0
}