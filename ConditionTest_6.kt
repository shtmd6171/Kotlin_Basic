fun main() {

    loopTest(8)
    caseTest(3)
    ifTest(17.0f)

    var a = "ABCD"
    // if, case문을 변수의 값에 그대로 삽입이 가능함
    var result = when(a){
        is String -> {true}
        else -> {false}
    }
    println(result)
    // if, case문을 print문에 그대로 삽입이 가능함
    println(if("AAA".length > 3) true else "짧아요" )

}

fun loopTest(count : Int){
    // for 문 내에 변수는 선언하지 않아도
    // 자동으로 0으로 생성되고 증감식 없이도 증가함
    // for(변수 in 배열or 범위){}
    for (i in (0..count)){
        println("i ->" + i)
    }

    var i : Int = 0
    while (i < count){
        i++
        println("$i 입니다")
    }

}

fun caseTest ( o : Any?){
    // when을 사용해 switch 문처럼 사용가능하고
    // 각 case는 is in else가 자연스럽게 사용되며
    // 해당 조건에 따른 내용은 -> {} 로 표헌함
    // when(변수){ 조건 -> {실행문}}
    when(o){
        "Test" -> { println("문자" + o)}
        is Float -> { println("Float" + o)}
        in (0..9) -> { println("0~9사이 숫자 : $o")}
        else -> {println("?")}
    }
}

// if 문 내에서 Any 타입을 자연스럽게 쓴다
fun ifTest(a : Any?){
    // 문자열도 .equal 없이 == 로 비교 가능
    if(a == "Test"){
        println(a)
        // is 이용해 변수의 변수형을 알아낼 수 있다
    }else if ( a is Float){
        println("Float")
        // in(..)을 사용해서 범위 내 값을 지정할 수 있다
    }else if ( a in (0..9)){
        println("0-10 사이의 숫자 : $a")
    }else if (a == null){
        println("null")
    }
}