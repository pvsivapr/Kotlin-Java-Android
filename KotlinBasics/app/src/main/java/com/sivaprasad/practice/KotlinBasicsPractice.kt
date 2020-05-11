package com.sivaprasad.practice

import com.example.kotlinbasics.*;
import java.lang.Integer.parseInt;
import java.util.Scanner;

val somethin : Int = 140
lateinit var lateinitvalue : String

infix fun Int.isMultipleOf(multiple : Int)  = this % multiple == 0

fun main(args: Array<String>)
{
    println("Hello World");
    //2020-may-4
    //exampleValVar//For variables
    //exampleNullableBasics//For Variables
    //exampleFunctions();//For Functions
    //exampleIfExpression();//For If Expression
    //exampleWhenExpresson();//For When Operations
    //2020-may-5
    exampleForExpression();//For For Operations

}

fun exampleForExpression()
{
    println("for is same as both for lop and foreach in Kotlin, there will be no initialization of variable");
    forOperations()
}
fun  forOperations()
{
    println("range, works as for(i:Int in 1 .. 10) but not works for for(i:Int in 10 .. 1), for this we have to use downTo")
    for(i:Int in 1 .. 10){
        println(i)
    }//12345678910

    println("\n range in steps")
    val topIndex = 10
    for (i in topIndex downTo 0 step 2){
        println(i)
    }//1086420

    println("\ntraverse tru a collection")
    val collection = listOf(1,2,3)
    //val collection = listOf("a","b","c")
    val collectionArray = arrayListOf<Int>(10,20,30)
    for(item in collection)
    {
        println("$item")
    }

    println()
    val stringVal : String = "Hello World"
    for(c:Char in stringVal){
        println("$c")
    }
}

fun exampleWhenExpresson()
{
    whenOperations(2);
}
fun whenOperations(x : Int, s : String = "5")
{
    when (x)
    {
        1 ->
        {
            println("x == 1")
            println("x == 1")
            println("x == 1")
        }
        2 -> println("x == 2")
        else -> {
            println("x is neither 1 nor 2")
        }
    }

    when (x)
    {
        0, 1 -> println("x == 0 or x == 1")
        else -> {
            println("Other wise")
        }
    }

    when
    {
        (x<3) -> println("x == 0 or x == 1 or x == 2")
        (x == 2) -> println("x is 2")
        else -> {
            println("Other wise")
        }
    }

    when (x)
    {
        parseInt(s) -> println("s encodes x")
        else -> {
            println("s does not encode x")
        }
    }
}

fun exampleIfExpression()
{
    println(findMax1(7, 6))//
    println(findMax2(8, 9))//
    println(findMax3(5, 11))//
}
fun findMax1(a : Int, b : Int) : Int
{
    println("This is a general expression")
    if(a > b)
    {
        return a
    }
    else
    {
        return b
    }
}
fun findMax2(a : Int, b : Int) : Int
{
    println("returns the last value of the block")
    return if(a > b)
    {
        a
    }
    else
    {
        b
    }
}
fun findMax3(a : Int, b : Int) : Int
{
    println("assigns the last value of the block")
    val maxValue = if(a > b)
    {
        a
    }
    else
    {
        b
    }
    return maxValue;
}

fun exampleFunctions()
{
    println(optFun())
    println(optFun(false, "Hello Hello", 10))
    println(optFun(whyIsItFun = "Testing with single parameter"))
    println(optFun(someParam = 8, whyIsItFun = "Testing jumbling", isItFun = false))

    println(add(3,6))
}
fun optFun(isItFun : Boolean = true, whyIsItFun : String = "Because", someParam : Int = 9) : String
{
    if(isItFun)
    {
        return whyIsItFun + someParam
    }
    else
    {
        return "It is Not Fun"
    }
}
fun add(a : Int, b : Int) = a+b

fun exampleNullableBasics()
{
    var a : String = "Some String"
    println("Value of a is \"$a\", Length is \"${a.length}\"")

    //a = null

    //a?.length

}

fun exampleValVar()
{
    val a: Int = 10;
    println("Value of a is $a, \"val\" does not allow to reassign")

    //a = 16 // This cannot be done as val is creating an immutable object

    var b: Int = 10;
    println("Value of b is $b, This is initial value");
    b=20; // This can be done as var is creating an mutable object
    println("Value of b is $b, This is recently assigned value");
}

fun javaInterOps()
{
    var javaTest : ScratcPadJava = ScratcPadJava()

}