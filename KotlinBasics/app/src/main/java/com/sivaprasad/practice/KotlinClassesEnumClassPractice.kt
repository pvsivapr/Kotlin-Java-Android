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



sealed class ResultSealedExample()
data class SuccessSealedEx(var report: Any) : ResultSealedExample()
data class FailedSealedEx(var exception: Exception) : ResultSealedExample()
data class LoadingSealedEx(var report: String) : ResultSealedExample()

fun getAPIResultUsingSealedClass(result: ResultSealedExample) : Any
{
    when(result)
    {
        is SuccessSealedEx ->
        {
            return "result is successful"
        }
        is FailedSealedEx ->
        {
            return "result failed"
        }
        is LoadingSealedEx ->
        {
            return "result is loading"
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
}
