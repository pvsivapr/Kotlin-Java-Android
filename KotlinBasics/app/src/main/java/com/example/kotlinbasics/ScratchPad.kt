package com.example.kotlinbasics

import java.lang.Integer.parseInt;
import java.util.Scanner;

val somethin : Int = 140
lateinit var lateinitvalue : String

infix fun Int.isMultipleOf(multiple : Int)  = this % multiple == 0

fun main(args: Array<String>)
{
    println("Hello World");

}

fun javaInterOps()
{
    var javaTest : ScratcPadJava = ScratcPadJava()

}

fun optFun(isItFun : Boolean = true,
           whyIsItFun : String = "Because",
           someParam : Int = 9) : String
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

fun ifToFindMax(a : Int, b : Int)
{
    var max = if(a > b)
    {
        println("Choose a")
        a;
    }
    else
    {
        println("Choose b")
        b;
    }
}