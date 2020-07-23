fun main() {
  /* - 순수 함수 : 결과가 같은 함수, 외부레퍼런스를 사용하지 않는 함수
   *               전역적인 참고가 아닌 입력을 통한 처리
   *
   * - 고차 함수 : 함수형 변수를 입력받고 함수형 변수를 리턴하는 함수
   *
   * - lambdas
   *  함수형 프로그래밍의 필수요소 람다식
   *  식별자 없이 실행 가능한 표현식으로 가독성 위해 코드를 줄이는 것
   *  일반적인 형식  {변수 정의 -> 함수구현}
   *
   */

    // 1. 람다식으로 정의한 함수형 변수
       // -> 우측 부분은 return 값과 같다
    var pfunc = {a : Int, b : Int -> a + b}
    println(pfunc(10,20))

    // 2. 고차함수에 람다식을 넘기기
       // 람다식으로 구현된 변수를 넣을 수 있다
       // pfunc의 함수는 fn1의 매개함수인 func로 대체되고
       // pfunc(10,10)을 뜻하게 된다
    fn1(pfunc)
       // { }안에 람다식으로 직접 함수의 구현 형태를 적어 넣을 수 있다
       // pfunc 라는 것은 결국 변수로는 a,b 구현 내용으론 a+b 와 같으므로
       // pfunc가 아닌 구현 형태를 넣어 fn2 안에 매개함수 func 자체를 이용하는 것이다
    fn2 {n, n2 -> n + n2}

    // 3. 고차함수에 람다식과 값을 같이 넘기기
       // fn2는 다른 매개변수값이 필요없고 func의 형태만을 넘겨주면 되었기에 {} 만을 사용
       // fn3에서는 func가 가질 형태뿐 아니라 변수의 값도 넘겨주어야 하기 때문에 ()가 필요
    fn3 ({n, n2 -> n + n2},100,200)
    fn3 (pfunc,100,200)

    // 4. 함수의 주소값을 직적 대입시키는 방법
    fn4(::Add)
    // 5. 람다식의 간소화화
    var funParameter = {a : Int -> Add(a)}
    fn4(funParameter)

    fn4({a : Int -> Add(a)})

    fn4{a : Int -> Add(a)}

    fn4{a -> Add(a)}

    fn5(::Add)

    fn5{a,b -> Add(a,b)}

}

// fn1은 ( Int형 변수 2개를 매개변수로 갖고
// Int형 return 값을 가지는 함수 func ) 를 매개변수로 가지는 함수이다
// .let 뒤의 문자-> 를 통해서 문자가 it을 대체한다
fun fn1(func : (Int, Int) -> Int){
    func(10,10).let { 결과값 -> println("결과값은 $결과값 입니다")}
}

fun fn2(func : (Int, Int) -> Int) {
    println(func(10,10))
}

// 매개변수를 직접 넣는게 아닌 입력을 통한 처리를 수행함
fun fn3(func : (Int, Int) -> Int, a : Int, b : Int){
    println(func(a,b))
}

fun fn4(func : (Int) -> Int){
    println(func(1))
}

fun fn5(func : (String,String) -> String){
    println(func("h","o"))
}

fun Add(i : Int) : Int {return i+100}

fun Add(s : String, s1 : String) : String {return s+s1}

