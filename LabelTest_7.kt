fun main() {
  /*
   * return@레이블 반환값 : 해당 레이블로 값을 가지고 복귀한다
   * break@레이블 : 반복문을 종료하고 지정한 레이블로 나간다
   * continue@레이블 : 다음 라인을 무시하고 지정한 레이블로 이동한다
   *
   *
   */
    ExitLoop()
    println(lambdaReturn().toString())

    // it은 변수지정없이 자동으로 범위 값에서 증감하는 값을 의미하고
    // return@forEach를 통해 forEach 함수를 탈출한것임
    (0..10).forEach {num ->
        if(num > 3 )return@forEach else println(num)
    }

}

fun  ExitLoop() {
    HereToExit@ for (i in 0 .. 2){
        for (j in 0 .. 10){
            if (j == 5)
                break@HereToExit
            println("i->$i, j->$j")
        }
        println("j loop end")
    }
    println("i loop end")
}

// 이름없는 함수(람다식)의 리턴
// 람다식에서는 return의 위치를 반드시 지정해줘야 함
var lambdaReturn = Exit@{
    if (true){
        return@Exit 3
    }
    // return 1000과 같음
    1000
}