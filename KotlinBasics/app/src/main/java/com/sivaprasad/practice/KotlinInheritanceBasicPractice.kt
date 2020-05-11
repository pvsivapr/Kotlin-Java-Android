package com.sivaprasad.practice

open class Base(p: Int = 0)
class Derived(p: Int) : Base(p)

open class Shape{
    open fun draw(){//Empty

    }//Overriding functions

    fun fill(){//Empty
    }

    open val vertexCount: Int = 0  //Overriding properties
}

class Circle() : Shape(){
    override fun draw() {//Empty
    }

    override val vertexCount: Int = 0;
}

open class Rectangle : Shape()
{
    final override fun draw() {//Empty
    }
}

open class Square : Rectangle(){
    override val vertexCount: Int = 4;
    //cannot be done as the method is declared "final" in the parent class
    /*
    override fun draw() {//Empty
    }
    */
}

fun main(args: Array<String>)
{
    println("Hello World Inheritance basic practice");
    val explanationString : String = "All classes in Kotlin are by default final classes. \n" +
            "They cannot be inherited. \n" +
            "To inherit a class the parent should be declared with \"open\" keyword. \n" +
            "To override the methods of inherited classes the methods should also be declared with \"open\" keyword."
    println(explanationString);
    //2020-may-5
    //exampleForExpression();//For For Operations

}