package com.sivaprasad.practice

import java.lang.Exception

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
    println(evaluateTestSealedClass(SealedClassCircle(20)))
    println(evaluateTestSealedClass(SealedClassRectangle(20, 10)))
    println(evaluateTestSealedClass(SealedClassSquare(20)))


    getAPIResultUsingSealedClass2(SuccessSealedEx2(""))
    getAPIResultUsingSealedClass2(FailedSealedEx2("", Throwable("This is a testing procedure for sealed class")))
    getAPIResultUsingSealedClass2(LoadingSealedEx2(true))


}

sealed class ResultSealedExample2()
data class SuccessSealedEx2(val report: String) : ResultSealedExample2()
data class FailedSealedEx2(val reason: String, val throwable: Throwable) : ResultSealedExample2()
data class LoadingSealedEx2(val report: Boolean) : ResultSealedExample2()

fun getAPIResultUsingSealedClass2(result: ResultSealedExample2)
{
    when(result)
    {
        is SuccessSealedEx2 ->
        {
            result.report
        }
        is FailedSealedEx2 ->
        {
            result.reason
            result.throwable
        }
        is LoadingSealedEx2 ->
        {
            result.report
        }
    }
}