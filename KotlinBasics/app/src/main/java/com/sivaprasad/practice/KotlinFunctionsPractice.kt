package com.sivaprasad.practice

import java.util.*

fun main()
{
    println("Date = 2020/05/12")

    simpleFunction1(10)
    simpleFunction2(10)
    simpleFunction3(10, "Test", 20)
    simpleFunction3(b = "test", a = 10, c = 20)


    //LAMDA FUNCTION
    println("\n\n\n")
    println("::::::::::::: LAMDA FUNCTION :::::::::::::")
    println("This is a lamda function")
    var helloWorldFunction = {
        println("Hello World, Welcome to lamda function")
    }
    helloWorldFunction()

    var productFunction = { a: Int, b: Int -> a*b }
    var result = productFunction(20, 40)
    println("Result ::::: $result")
    println("In Lamda functions this character '->' seperates the parameters from the method functionality")


    //HIGHER ORDER FUNCTIONS
    println("\n\n\n")
    println("::::::::::::: HIGHER ORDER FUNCTIONS :::::::::::::")
    println("Accepts function as an input and returns function as return type")
    val helloWorldHigherOrderFunction1 = {
        println("Hello World, Welcome to Higher order function, This is Test 1")
    }
    var helloWorldHigherOrderFunction2 = {
        println("Hello World, Welcome to Higher order function, This is Test 2")
    }
    var getProductHigherOrderFunction1 = {
       a: Int, b: Int -> a * b
    }
    callMeNowTest1(helloWorldHigherOrderFunction1)
    callMeNowTest2(helloWorldHigherOrderFunction2)
}

fun callMeNowTest1(passLamdaFunction : () -> Unit)
{
    passLamdaFunction()
}

fun callMeNowTest2(passLamdaFunction : () -> Unit)
{
    //passLamdaFunction()
}

fun productHigherOrderFunction1(productHigherOrder : (a: Int, b: Int) -> Int)
{
//    productHigherOrder();
}

fun simpleFunction1(a : Int) : Int
{
    return a * a
}

fun simpleFunction2(a: Int) = a * a

fun simpleFunction3(a: Int, b: String, c: Int)
{

}