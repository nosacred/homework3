package com.skillboxhelloworld.skillboxkotlin

import kotlin.math.abs

//Консольная программа должна иметь следующий функционал:
//
//1. Ввести число N с клавиатуры.
//
//2. После этого ввести следующие N чисел каждое с новой строки (если пользователь ввел не число - игнорируется эта строка) ( использовать цикл и нуллабельные типы)
//
//3. Сохранить числа в список.
//
//4. Шаги 2-3 вынести в функцию, которая принимает число N и возвращает список из N чисел, введённых с клавиатуры.
//
//5. Вывести в консоль количество введенных положительных чисел. (Использовать if)
//
//6. Вывести в консоль только четные введённые числа. (Использовать фильтрацию коллекции.)
//
//7. Вывести в консоль количество уникальных введенных чисел. (Использовать set.)
//
//8. Вычислить сумму всех введенных чисел с помощью агрегирующей функции коллекции sum.
//
//9. Для каждого числа посчитать наибольший общий делитель (НОД) для этого числа и суммы из пункта 7.
//
//(Создать функцию для вычисления НОД, которая использует рекурсию с модификатором tailrec.)
//
//10. Создать отображение число - НОД из пункта 8. (Использовать map)
//
//11. Вывести все числа с НОД в формате: Число <>, сумма <>, НОД <>.
//
//Для каждого из чисел использовать новую строку.


fun main() {

    println("Введите положительное число")
    val N: Int? = readLine()?.toIntOrNull() ?: return //п.1

    var newList: List<Int> = mutableListOf()
    if(N is Int && N >= 0) newList = numbersInput(N)
    var currentNumber = 0
    for(number in newList) if (number > 0) currentNumber++
    println("Колличество введеных  положительных чисел: $currentNumber") // п.5

    println("Четные введеные числа:  ${newList.filter{it%2==0}}")  // п.6

    val uniqueNumbers = newList.toSet().size
    val uniqueNumbersSum= newList.toSet().sum() // Сумма уникальных чисел
    println("Количество уникальных чисел равно : $uniqueNumbers") // п.7

//    println("Уникальные числа : ${newList.toSet()}")
//    println("Сумма всех чисел равна : ${newList.sum()}")

    val totalNumbersSum = newList.sum() //п.8 (сумма всех чисел)

    val numbersMapTotal = mutableMapOf<Int, Int>()
    val numbersMapUnique = mutableMapOf<Int, Int>()

    for (i in newList) numbersMapUnique.put(i, gCD(abs(i), abs(uniqueNumbersSum))) //п.9

    for (i in newList) numbersMapTotal.put(i, gCD(abs(i), abs(totalNumbersSum))) //п.10

    for (i in numbersMapTotal) println("Число <${i.key}>, сумма <$totalNumbersSum>, НОД <${i.value}>")//п.11
    }

    fun numbersInput(N:Int):List<Int>{ //п.4
        var currentNumber = 0
        val listOfNumbers =  mutableListOf<Int>()
        while (currentNumber < N) {
            println("Введите число")
            var n: Int? = readLine()?.toIntOrNull() ?: continue
            println("Вы ввели  $n")
            currentNumber++
            if(n is Int) listOfNumbers.add(n)
        }
        return listOfNumbers
    }

tailrec fun gCD(a :Int, b:Int):Int{ //п.9
    if (a == b || b == 0) return a else if (a==0) return b
    else if (a > b) return gCD(b, a%b)
    else return gCD(a, b%a)
}