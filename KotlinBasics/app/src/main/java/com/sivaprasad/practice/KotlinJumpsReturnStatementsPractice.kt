package com.sivaprasad.practice

//val somethin : Int = 140
//lateinit var lateinitvalue : String
//
//infix fun Int.isMultipleOf(multiple :Int) = this%multiple == 0

fun main(args: Array<String>)
{
    //JUMPS AND RETURN
    println("\n\n\n")
    println("2020-May-5th,6th")
    println("::::::::::::: JUMPS AND RETURN :::::::::::::")
    //println("Getter and Setter methods in Classes examples")
    //labeledJumps1();
    //println("'it' operator example for lamda functions")
    //someFunction1();
}

fun someFunction2()
{
    listOf(1,2,3,4,5).forEach lamda@{

    }

    listOf(1,2,3,4,5).forEach (fun(value: Int) {
        if (value == 3) return
        println(value)
    })
}

fun someFunction1()
{
    listOf(1,2,3,4,5).forEach lamda@{listvalue -> println(listvalue)}
    listOf(6,7,8,9,10).forEach lamda@{println(it)}
}

fun labeledJumps1()
{
    loop@ for(i in 1..3)
    {
        for(j in 5..7)
        {
            if(i == 2 && j == 6)
            {
                continue@loop
            }
            print((i*100)+j)
            print(" ")
        }
        //if(i == 2) break
        println(i.toString() + " loop ends")
    }
    println("We are done with labeledJump1()")
    labeledJumps2()
    println("'labeled jumps' we can declare a label as 'name<@>' i.e., 'somelabel@' and while to continue to that position access as 'continue @somelabel'")
    println("'continue' keyword breaks the current flow in the loop and continues the loop")
    println("'continue' keyword with 'loop name' like 'continue@loop' breaks the current loop continues the named loop")
}

fun labeledJumps2()
{
    for(i in 5..7)
    {
        for(j in 1..3)
        {
            if(i == 6 && j == 2)
            {
                continue
            }
            print((i*100)+j)
            print(" ")
        }
        //if(i == 2) break
        println(i.toString() + " loop ends")
    }
    println("We are done with labeledJump2()")
}