import java.util.*

fun main() {


    // 문자열 + 기능 지원
    var sName = "박씨"
    println(sName + " The Gamer")

    // """ """ 를 이용해 줄넘김 문자도 문자열 내 동시에 처리
    var sLines = """
        1
        2
        3
        4
        5
        6
        7
        8
        9
                 """
    println(sLines)

    // $(코딩) 이용한 문자열 내의 코딩 결과값 치환가능
    var sFormatter = "$sName <-- sName의 값"
    println(sFormatter)

    //${}를 사용해 함수호출이나 수식처리를 내부에 가능하게 함
   var sBash = "${"지금 시각은" + Date()}" // java class를 import함
    println(sBash)
}