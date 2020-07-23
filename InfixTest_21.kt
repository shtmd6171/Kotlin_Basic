fun main(args: Array<String>) {
/*
 * 수학에서 infix는 중위표기법으로 사칙연산자와 같이 좌측 우측 값이 존재하는 연산자를 의미
 *
 * .연산자(객체의 메소드 호출)를 대처하는 메소드 표기법
 *
 *  객체 메소드 값의 형식
 *
 */
    var MyCompany = RankMyCompany()
    MyCompany AddPoint "일이 좋다"
    MyCompany AddPoint "자부심"
    MyCompany AddPoint "높은 연봉"
    MyCompany AddPoint "유명 회사"
    // 일반적인 방식
    MyCompany.AddPoint2("야근 당연")
    println(MyCompany.Rank)

}

class RankMyCompany {
    var m = mapOf<String,Int>(
        "일이 좋다" to 25,
        "자부심" to 30,
        "높은 연봉" to 25,
        "유명 회사" to 20,
        "야근 당연" to -60

   )
    var Rank : Int = 0

    // infix는 확장함수나 멤버함수로 구현되어야 한다
    infix fun AddPoint(s : String) : Int {
        this.Rank += m[s]!!
        return this.Rank
    }

    fun AddPoint2(s : String) : Int {
        this.Rank += m[s]!!
        return this.Rank
    }

}