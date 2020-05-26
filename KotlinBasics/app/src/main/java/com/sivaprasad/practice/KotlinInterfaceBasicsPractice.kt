package com.sivaprasad.practice

interface MyInterface
{
    fun sayHello() : String

    fun sayImplementedInInterface() : String
    {
        return "This is implemented in 'MyInterface' interface"
    }

}

class ImplementMyInterface : MyInterface
{
    override fun sayHello() : String {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return "Declared in 'MyInterface' interface and implemented in 'ImplementMyInterface' class"
    }
}

fun main(args : Array<String>)
{
    //INTERFACES
    println("\n\n\n")
    println("2020-May-7th")
    println("::::::::::::: INTERFACES :::::::::::::")
    println("Interface example")
    val text1 = "//This is not the way of calling"+
            "//val implementMyInterface : MyInterface = ImplementMyInterface();"+
            "//MyInterface.sayHello();"
    println(text1);

    println("This is how you call the class implementing interface")
    var implementMyInterface = ImplementMyInterface()
    println(implementMyInterface.sayHello())
    println(implementMyInterface.sayImplementedInInterface())

    //EXTENSION FUNCTIONS
    println("\n\n\n")
    println("2020-May-7th")
    println("::::::::::::: EXTENSION FUNCTIONS :::::::::::::")
    println("EXTENSION FUNCTIONS example")
    val text2 = "Out side of the class it is possible to declare a method by 'fun classname.methodname' this type of declaration in extension functions \n"
    println(text2);

    var callingImplementMyInterface : CallingImplementMyInterface = CallingImplementMyInterface();
    fun CallingImplementMyInterface.NewExtendedFunction() : String
    {
        return "This is an extended function"
    }

    callingImplementMyInterface.NewExtendedFunction();
    val testingExtendedFunction = TestingExtendedFunction();//won't work extended function here
    println("but this extended function is restricted to that block only based on the access modifier of the extended function class, if you write this function for a existing library like a 'String class' then that can be used throughout the application")

    println("This extended function can also be used for libraries as shown below")

    var myString = "Hello"
    println(myString.getTheFirstCharacter())
}

fun String.getTheFirstCharacter() : String {
    return this.substring(0,1);
}

class TestingExtendedFunction()
{
    fun main(args : Array<String>)
    {
        //This won't work
        //var callingImplementMyInterface : CallingImplementMyInterface = CallingImplementMyInterface();
        //println(callingImplementMyInterface.NewExtendedFunction())
    }
}


class CallingImplementMyInterface
{
    fun main(args : Array<String>)
    {
        val text = "//This is not the way of calling"+
        "//val implementMyInterface : MyInterface = ImplementMyInterface();"+
        "//MyInterface.sayHello();"
        println(text);

        println("This is how you call the class implementing interface")
        var implementMyInterface = ImplementMyInterface()
        implementMyInterface.sayHello()
        implementMyInterface.sayImplementedInInterface();
    }
}