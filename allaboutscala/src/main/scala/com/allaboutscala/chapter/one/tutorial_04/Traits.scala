package com.allaboutscala.chapter.one.tutorial_04
object Traits extends App {

  //Scala Tutorial - Learn How To Create And Extend Trait In Scala
  //1. Create a trait which will define the methods for a data access layer
  println("Step 1: Create a trait which will define the methods for a data access layer")
  trait DonutShoppingCartDao{
    def add(donutName: String): Long

    def update(donutName: String): Boolean

    def search(donutName: String): String

    def delete(donutName: String): Boolean

  }

  //2. Create a DonutShoppingCart class which extends the trait from Step 1 and implements its methods
  println("\nStep 2: Create a DonutShoppingCart class which extends the trait from Step 1 and implements its methods")
  class DonutShoppingCart extends DonutShoppingCartDao{
    override def add(donutName: String): Long = {
      println(s"DonutShoppingCart -> add method -> donutName : $donutName")
      1
    }

    override def update(donutName: String): Boolean = {
      println(s"DonutShoppingCart-> update method -> donutName: $donutName")
      true
    }

    override def search(donutName: String): String = {
      println(s"DonutShoppingCart-> search method -> donutName: $donutName")
      donutName
    }

    override def delete(donutName: String): Boolean = {
      println(s"DonutShoppingCart-> delete method -> donutName: $donutName")
      true
    }
  }

  println("\nStep 3: Create an instance of DonutShoppingCart and call the add, update, search and delete methods")
  val donutShoppingCart1: DonutShoppingCart = new DonutShoppingCart()
  donutShoppingCart1.add("Vanilla Donut")
  donutShoppingCart1.update("Vanilla Donut")
  donutShoppingCart1.search("Vanilla Donut")
  donutShoppingCart1.delete("Vanilla Donut")


  println("\nStep 4: Create an instance of DonutShoppingCart and assign its type to the trait DonutShoppingCartDao")
  val donutShoppingCart2: DonutShoppingCartDao = new DonutShoppingCart()
  donutShoppingCart2.add("Vanilla Donut")
  donutShoppingCart2.update("Vanilla Donut")
  donutShoppingCart2.search("Vanilla Donut")
  donutShoppingCart2.delete("Vanilla Donut")
}
