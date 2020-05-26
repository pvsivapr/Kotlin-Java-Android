package com.sivaprasad.practice

var name1 : String = "Cannot be null"
var name2 : String? = null

fun main()
{
    println("Date = 2020/05/12")
    
    //name1 = null
    name2 = "Can be assigned to null"
    name2 = null

    //NUll SESSIONS
    println("\n\n\n")
    println("::::::::::::: NUll SESSIONS :::::::::::::")
    println("")

    println("value of name1 cannot be null so can be declared as follows name1.length")
    println("name1 length = ${name1.length}")
    println("value of name2 is null so declared as follows name2?.length")
    println("name2 length = ${name2?.length}")
    println("printing 'hello null' if name2 is having null value")
    println( name2 ?: "Hello null")

}