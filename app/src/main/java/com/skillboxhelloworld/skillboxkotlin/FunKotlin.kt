package com.skillboxhelloworld.skillboxkotlin

fun main() {

    hasChildAccsess(height = 155, weight = 50, age = 20)
}
fun multiply(a: Int, b: Int): Int {
    val resoult = a*b
    return resoult
}
fun hasChildAccsess(height:Int, weight: Int, age:Int): Boolean{
    return height> 150 && weight > 50 && age > 10
}