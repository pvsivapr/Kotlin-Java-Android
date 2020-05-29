package com.sivaprasad.practice


class OuterClass
{
    var outerVariableVal : String = "Sivaprasad"
    fun sayHelloOuter()
    {
        println("Hello Outer Class")
    }
    class TestingNestedClass
    {
//        var nestedVariableVal = outer
        fun sayHelloNested()
        {
            println("Hello Nested Class")
        }
    }
    inner class TestingInnerClass
    {
        var innerVariableVal = outerVariableVal;
        fun sayHelloInner() {
            println("Hello Inner Class")
        }
    }

}//KotlinClassesDataClassPractice.kt

fun main(args: Array<String>)
{
    println("2020-May-7th")
    println("::::::::::::: CLASSES TYPES :::::::::::::")
    println("::::::::::::: NESTED CLASS, INNER CLASS :::::::::::::")
    println("We can access the nested class by using class name without creating an object")
    OuterClass.TestingNestedClass().sayHelloNested()
    //OuterClass.TestingInnerClass().sayHelloInner()

    println("To access the inner class we have to create an object for the outer class")
    var outerClass = OuterClass();
    outerClass.TestingInnerClass().sayHelloInner();
    println("Accessing Outer Class Object from Inner Class, the value is ${outerClass.TestingInnerClass().innerVariableVal}")
}