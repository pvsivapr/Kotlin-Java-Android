package com.sivaprasad.practice

/*
class PersonKotlin constructor(_name : String, _age : Int, _salary : Int) {
    //Member properties (variable) of the class
    var name : String
    var age : Int
    var salary : Int
    init {
        this.name = _name
        age = _age
        salary = _salary
        println("In init block, name: $name, age: $age, salary: $salary")
    }
}

class PersonDeaultValues constructor(_name : String, _age : Int, _salary : Int = 25000){
    var name : String
    var age : Int
    var salary : Int
    init {
        this.name = _name
        age = _age
        salary = _salary
        println("In init block, name: $name, age: $age, salary: $salary")
    }
}

class PersonSecondaryConstructor1{
    var name : String = "";
    var age : Int = 0;
    var salary : Int = 0;

    //This works
    constructor(_name : String, _age : Int, _salary : Int) {
        println("Secondary Constructor called")
        name = _name
        age = _age
        salary = _salary
        println("In Secondary constructor block with, name: $name, age: $age, salary: $salary")
    }
}

class PersonSecondaryConstructor2 (_name : String = "Francis"){
    var name : String
    init {
        this.name = _name
        println("In init block PersonSecondaryConstructor with, name: $name")
    }

    var age : Int = 0;
    var salary : Int = 0;

    //This wont works as the class a primary constructor, to create a secondary constructor the primary should be also called
    /*
    constructor(_age : Int, _salary : Int){
    }
    */

    //This works
    constructor(_age : Int, _salary : Int) : this("Joe"){
        println("Secondary Constructor called")
        age = _age
        salary = _salary
        println("In Secondary constructor block with, age: $age, salary: $salary")
    }
}


fun main(args : Array<String>)
{
    //val personKotlin = PersonKotlin("Jhon", 28, 30000)
    //val personDefaultValues = PersonDeaultValues("Jhon", 28)
    //val personSecondaryConstructor1 = PersonSecondaryConstructor1("Jhon", 22, 23456)
    val personSecondaryConstructor2 = PersonSecondaryConstructor2(22, 23456)
}
*/