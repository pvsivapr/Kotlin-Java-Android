package com.sivaprasad.practice

open class BaseClass(val name: String)
{
    init {
        println("Initializing Base Class")
    }

    open val size: Int = name.length.also { println("Initializing size in BaseClass : $it") }
}
class DerivedClass(name: String, val lastName: String) : BaseClass(name.capitalize().also { println("Argument fo BaseClass: $it") })
{
    init {
        println("Initializing DerivedClass")
    }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in DerivedClass : $it") }
}


open class RectangleClass
{
    open fun draw(){println("Drawing a rectangle")}
    val borderColor: String get() = "black"
}

//Derieved class calling super class
class FilledRectangle1 : RectangleClass(){
    override fun draw() {
        super.draw()
        println("Filling the Rectangle")
    }

    val fillColor: String get() = super.borderColor
}

//InnerClass calling superclass
class FilledRectangle2 : RectangleClass(){
    override fun draw() {
        super.draw()
        println("Filling the Rectangle")
    }

    val fillColor: String get() = super.borderColor

    inner class Filler{
        fun fill(){
            //Empty
        }

        fun drawAndFill(){
            super@FilledRectangle2.draw()//calls Rectangle's implementation of draw
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle2.borderColor}")
        }
    }
}


fun main(args: Array<String>)
{

    println("Hello World Inheritance Deep Dive");
    val explanationString : String = "All classes in Kotlin are by default final classes. \n" +
            "They cannot be inherited. \n" +
            "To inherit a class the parent should be declared with \"open\" keyword. \n" +
            "To override the methods of inherited classes the methods should also be declared with \"open\" keyword. \n"
    println(explanationString);
    //2020-may-5
    println("Constructing DerivedClass(\"hello\", \"world\")")
    val d = DerivedClass("hello", "world")

    println("Calling Super class from DERIEVEDClass")
    val r = FilledRectangle1()

    println("Calling Super class from INNERClass")
    val i = FilledRectangle2()


}