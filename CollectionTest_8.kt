fun main() {
  /*
   * list에는 읽기전용과 읽기쓰기전용이 있다
   *
   * 읽기 전용 리스트
   * fun <T> listOf(vararg elements: T): List<T>
   * 리턴 값은 List<T>
   * val list = listOf(1,2,3,"가") 와 같은 다양한 값을 collection으로 사용 가능
   * .size : 크기를 가져옴
   * .contains(값) : 리스트에 값이 있는지 확인한다
   * .indexOf(위치) : 해당 위치를 가져온다
   * list[위치] : 해당 위치의 값을 가져온다
   *
   * 읽기 쓰기 리스트
   * fun <T> mutableListOf() : MutableList<T>
   * 리턴 값은 MutableList<T>
   * var list = mutablelistOf(1,2,3,"가") 와 같은 다양한 값을 collection으로 사용 가능
   * .add : 값을 추가한다
   * .removeAt(위치) : 위치에 있는 값을 삭제
   * .remove(값) : 해당 값을 삭제
   * .addAll : 해당 collection을 더한다 / list.addAll(listOf(1,2,3))
   *
   * 맵
   * fun <K, V> hashMapOf() : hashMap<K, V>
   * 리턴 값은 hashMap<K, V>
   * var m = hashMapOf("고양이"to 1, "강아지" to 2) 와 같은 Key Value 쌍으로 사용 가능
   * m[키] = 값 : 값을 추가
   * remove(키) : 값을 삭제
   * replace(키,값) : 키를 찾아서 값을 바꿈
   *
   */

    // val lst1 = listOf<>() 에서 <> 안에 제너릭을 사용하면
    // 해당 변수형만 삽입이 가능하다
    val lst = listOf(1,"A",12.00f,false,true)
    for(i in 0 .. lst.size - 1 ){
        // println(lst.get(i).toString())
    }
    println()

    var lstEditable = mutableListOf<String>()
    lstEditable.add("가")
    lstEditable.add("나")
    lstEditable.add("다")
    lstEditable.add("라")
    lstEditable.add("마")

    // lstEditable 리스트 크기 만큼 알아서 조건을 주고
    // 해당 리스트의 값을 가져오는 방식
    for (s in lstEditable){
        println(s)
    }
    println()
    lstEditable.removeAt(0)
    lstEditable.remove("다")

    for (s in lstEditable){
        println(s)
    }
    println()

    var lstEditable2 = mutableListOf<String>()
    lstEditable2.addAll(lstEditable)

    for (s in lstEditable2){
        println(s)
    }
    println()

    var m = hashMapOf("A" to 1, "B" to 2)
    println(m["A"])
    m["C"] = 3
    m.replace("A",4)
    m.remove("B")

    for (s in m){
        println(s)
    }

}