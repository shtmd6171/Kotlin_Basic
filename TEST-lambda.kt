fun main() {

    var testlambda2 : (Int,String) -> String = {integer : Int, s : String -> integer.toString() + s}

    print(testlambda2)
    print{integer : Int, s : String -> integer.toString() + s}

    print2(testlambda2,25,"살")
    print2({integer : Int, s : String -> integer.toString() + s},30,"살")

    print3(::testlambda,35,"살")



}

fun print (func : (Int,String) -> String ){
    println(func(20,"살"))
}

fun print2 (func : (Int,String) -> String, i : Int, s : String ){
    println(func(i,s))
}

fun print3 (func : (Int,String) -> String, i : Int, s : String ){
    println(func(i,s))
}




fun testlambda (i : Int, s : String ) : String {
    return i.toString()+s
}