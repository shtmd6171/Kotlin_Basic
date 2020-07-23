fun main(args: Array<String>) {
  /*
   * closure는 외부함수의 변수를 내부함수에서 그대로 기억하고 사용할 수 있다 (전역변수처럼 만들어서)
   *
   * 객체지향에서 사용하는 객체처럼 함수를 사용할 수 있다
   *
   *
   */


    var fn = Closure1(0)
    println(fn(10))
    println(fn(10))
    println(fn(10))

    // Closure2의 result는 람다식의 num을 뜻한다
    var  decByOne = Closure2({num -> num - 1})
    println(decByOne())
    println(decByOne())

    // Closure2의 result는 람다식의 num을 뜻한다
    fun Add(num : Int) = num + 10
    var addByTen = Closure2(::Add)
    println(addByTen())
    println(addByTen())
}


// Closure1의 return 형은 (Int) -> Int 인 함수형임
fun Closure1 (num : Int) : (Int) -> Int {
    // fun이 사용할 전역변수 역할의 변수로
    // 외부함수의 변수인 sum이 fun(내부함수)에서도 값을 그대로 사용할 수 있음
    var sum : Int = num

    // 이름없는 함수 fun은 sum을 전역변수처럼 사용한다
    // fun 내부는 sum과 이 함수에서 받은 num2를 더해 sum에 저장하는 역할을 한다
    return fun (num2 : Int) : Int {
        sum  = sum + num2
        return sum
    }
}

// 많이 쓰이는 방식
// 받는 매개변수도 함수형, return하는 변수도 함수형임
fun Closure2 (pFunc : (Int) -> Int) : () -> Int {
    var result : Int = 0
    return {
        result = pFunc(result)
        result // 실제 return되는 값
    }
}