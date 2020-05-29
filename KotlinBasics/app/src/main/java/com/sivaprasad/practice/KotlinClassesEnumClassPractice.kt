package com.sivaprasad.practice

import java.lang.Exception
import java.util.*

enum class ResultEnumExapmle
{
    SUCCCESS,
    FAILURE,
    LOADING
}

fun getAPIResultUsingEnum(result: ResultEnumExapmle) : String
{
    return when(result)
    {
        ResultEnumExapmle.SUCCCESS ->
        {
            "result is successful"
        }
        ResultEnumExapmle.FAILURE ->
        {
            "result failed"
        }
        ResultEnumExapmle.LOADING ->
        {
            "result is loading"
        }
    }
}

enum class MonthEnumExample(var monthName: String)
{
    Jan("January"),
    Feb("February"),
    Mar("March"),
    Apr("April"),
    May("May"),
    Jun("June"),
    Jul("July"),
    Aug("August"),
    Sep("September"),
    Oct("October"),
    Nov("November"),
    Dec("December")
}
fun getMonthUsingEnum(_monthName: MonthEnumExample) : String
{
    return _monthName.monthName;
}


sealed class ResultSealedExample()
data class SuccessSealedEx(var report: Any) : ResultSealedExample()
data class FailedSealedEx(var exception: Exception) : ResultSealedExample()
data class LoadingSealedEx(var report: String) : ResultSealedExample()

fun getAPIResultUsingSealedClass(result: ResultSealedExample) : Any
{
    return when(result)
    {
        is SuccessSealedEx ->
        {
            "result is successful"
        }
        is FailedSealedEx ->
        {
            "result failed"
        }
        is LoadingSealedEx ->
        {
            "result is loading"
        }
    }
}


fun main(args: Array<String>)
{
    println("2020-May-7th")
    println("::::::::::::: CLASSES TYPES :::::::::::::")
    println("::::::::::::: ENUM CLASS :::::::::::::")
    println(getAPIResultUsingEnum(ResultEnumExapmle.LOADING))
    println(getAPIResultUsingEnum(ResultEnumExapmle.FAILURE))
    println(getAPIResultUsingEnum(ResultEnumExapmle.SUCCCESS))

    println(getMonthUsingEnum(MonthEnumExample.Jan))
    println(getMonthUsingEnum(MonthEnumExample.Aug))
    println(getMonthUsingEnum(MonthEnumExample.Sep))
    println(getMonthUsingEnum(MonthEnumExample.Nov))
}
