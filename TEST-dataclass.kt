fun main(args: Array<String>) {

    var dogy = A2("doggy")
    println(dogy)

    var doggy = A3("dog",3,"mixed")

    // 일반 클래스의 클래스 인수로 각 매개변수를 받으면 이렇게 사용 할 수는 있지만..
    // 쓰는게 복잡하고 비효율적인거 같아.. 그럼?
    println("${doggy.name}, ${doggy.age}, ${doggy.species}")

    // data class 자체를 변수로 집어 넣으면 주소값이 아닌 들어 있는 해당값이 나와
    // 그러니까 위와 같이 일일히 '변수.멤버변수' 로 연결해주지 않아도 된다는거지
    var dogggy = B2("king",6,"shiba")
    println(dogggy)

    // doggy에 있는 내용을 복사하되, name만을 다른 값으로 주고 가져온거야
    var twins = dogggy.copy(name = "qeen")
    println(twins)
    println(twins.name) // 물론 멤버변수만 따로 가져올 수도 있어
    twins.bark("Grrrrrrr") // 클래스 인수가 아닌 일반 멤버 변수는 해당 클래스 변수를 불러야 해

    // 괄호와 안의 클래스 변수의 이름을 주면 data class에서 동일한 이름의 변수 값을 추출해 와
    // 그러면 별도의 클래스 변수 없이 바로 사용할 수 있어
    var (age, species) = twins
    println(age)
    println(species)

}

class A2(nickname: String) {
    var name: String = ""
    var age: Int = 0
    var species: String = ""

    init {
        this.name = nickname
    }

    constructor(name : String, age : Int , species : String) : this(name) {
       this.name = name
       this.age = age
       this.species = species
    }


}

// 일반클래스로 매개변수를 받기 위해서는 각 매개변수 항목을 채워줘야 하고
// 또 클래스 내부에서 사용할 변수를 똑같은 항목에 따라 만들어야 해
// 뿐만 아니라 초기화를 통해서 매개변수를 멤버변수에 넣어줘야 하고
class A3(name : String, age : Int , species : String){
    var name: String = ""
    var age: Int = 0
    var species: String = ""

    init {
        this.name = name
        this.age = age
        this.species = species
    }

}
// data class 내부에서는 각 매개변수 항목이 넘겨받는 값임과 동시에 실제로 멤버변수로 사용될 값이야
// 그러니까 선언 자체가 매개변수와 연결된 멤버변수인거지 !
data class B2(var name : String, var age : Int , var species : String){
    var bark = {wang : String -> println(wang)}
}