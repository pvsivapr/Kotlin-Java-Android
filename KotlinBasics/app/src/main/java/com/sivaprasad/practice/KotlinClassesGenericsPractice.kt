package com.sivaprasad.practice


class TestingGenericsClass<T, K>(text1: T, text2: K)
{
    var t1 = text1
    var t2 = text2
}

fun main(args: Array<String>)
{
    println("2020-May-7th")
    println("::::::::::::: CLASSES TYPES :::::::::::::")
    println("::::::::::::: GENERICS :::::::::::::")
    var testingGenericsClass1 : TestingGenericsClass<String, Int> = TestingGenericsClass("Sivaprasad", 28)
    println("Person1 data: ${testingGenericsClass1.t1} \t ${testingGenericsClass1.t2}")
}