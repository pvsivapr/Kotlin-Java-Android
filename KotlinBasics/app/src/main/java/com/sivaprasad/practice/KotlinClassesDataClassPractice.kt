package com.sivaprasad.practice


data class PersonData1(var name: String, var age: Int)
{
    fun sayHello()
    {

    }
}//KotlinClassesDataClassPractice.kt

fun main(args: Array<String>)
{
    println("2020-May-7th")
    println("::::::::::::: CLASSES TYPES :::::::::::::")
    println("::::::::::::: DATA CLASS :::::::::::::")
    var personData1Test1 : PersonData1 = PersonData1("Sivaprasad", 29);
    println("Person1 data: ${personData1Test1.toString()}")
}