package com.sivaprasad.practice

sealed class SealedClassArea()
data class SealedClassCircle(var radius: Int) : SealedClassArea()
data class SealedClassRectangle(var length: Int, var breadth: Int) : SealedClassArea()
data class SealedClassSquare(var sideLength: Int) : SealedClassArea()
object none : SealedClassArea()



enum class enumClassArea
{
//    Circle(10),
//    Rectangle(10),
//    Square(10)

    Circle,
    Rectangle,
    Square
}

fun evaluateTestSealedClass(area: SealedClassArea) : Int
{
    when (area)
    {
        is SealedClassCircle ->
        {
            return 2 * (22/7) * area.radius
        }
        is SealedClassRectangle ->
        {
            return area.length * area.breadth
        }
        is SealedClassSquare ->
        {
            return area.sideLength * area.sideLength
        }
        none ->
        {
            return 0//area.toString()
        }
    }
}

fun main(args: Array<String>)
{
    println("2020-May-7th")
    println("::::::::::::: CLASSES TYPES :::::::::::::")
    println("::::::::::::: SEALED CLASS :::::::::::::")
    println(evaluateTestSealedClass(SealedClassCircle(20)));
    println(evaluateTestSealedClass(SealedClassRectangle(20, 10)));
    println(evaluateTestSealedClass(SealedClassSquare(20)));
}
