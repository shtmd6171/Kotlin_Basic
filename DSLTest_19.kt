import  java.util.Random

fun main(args: Array<String>) {
  /*
   * 특정 앱이나 소프트웨어에서 사욜할 목적으로 만든 간이 언어
   *
   * ktl에서는 확장함수를 사용하여 구현가능함
   *
   */

    // 일반적인 방법으로 초기화
    var p0 = Player()
    p0.name = "Player 0"
    p0.status = Status()
    p0!!.status!!.job = "Wizard"
    p0!!.status!!.level = 20
    println(p0)

    // data class임을 이용한 방법으로 초기화
    var p1 = Player("Player 1", Status("Archer",23))
    println(p1)

    // 1. 반복되고 제한된 환경을 위한 간이언어
    // 2. 확장함수를 이용함
    // MakePlayer를 이용한 방법으로 초기화
    var p2 = MakePlayer {
        name = "Player " + Random().nextInt(200).toString()
        status {
            job = "paladin"
            level = Random().nextInt(70)
        }
    }
    println(p2)

}

// DSL 이용을 위한 함수 정의
// Player의 멤버들을 받는 block이라는 함수가 있고 외부에서 block에 Player의 멤버를 받으면
// 그 것을 Player에게 초기화 해주는 역할을 해줌
fun MakePlayer(block : Player.() -> Unit) : Player {
    return Player().apply(block)
}

// 이미 정의된 클래스인 Player의 확장 함수로 status를 생성하고
// status는 클래스 Status의 객체 값을 받아
// 초기화 시에 MakePlayer 내부에서 초기화가 이루어지게 함
fun Player.status(block : Status.() -> Unit) {
    status = Status().apply(block)
}
data class Player (var name : String? = null, var status : Status? = null)

data class Status (var job : String? = null, var level : Int? = null)