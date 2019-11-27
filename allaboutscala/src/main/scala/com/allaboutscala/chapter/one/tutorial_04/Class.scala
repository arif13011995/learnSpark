package com.allaboutscala.chapter.one.tutorial_04

object Class extends App{
  //Scala Tutorial - Learn How To Create Classes And Objects In Scala
  //1. How to define a simple class to represent a Donut object

  class Donut(name: String, productCode: Long){
    def print = println(s"Donut name = $name, productCode = $productCode")
  }

  //2. How to create instances of Donut class
  println("\nStep 2: How to create instances of Donut class")

  val glazedDonut = new Donut("Glazed Donut", 1111)
  val vanillaDonut = new Donut("Vanilla Donut", 2222)

  //3. How to call the print function for each of the donut object
  println("\nStep 3: How to call the print function for each of the donut object")

  glazedDonut.print
  vanillaDonut.print

  //4. How to access the properties of class Donut
  //
  println("\nStep 4: How to access the properties of class Donut")
//  glazedDonut.name
//  glazedDonut.productCode

  //Scala Tutorial - Learn How To Create And Use Companion Objects
  //2. How to declare a companion object for the Donut class
  //
  //A Companion Object is defined using the object keyword and the name of the object should be identical to the class name.
  println("\nStep 2: How to declare a companion object for the Donut class")
  object Donut{
    def apply(name: String, productCode: Long): Donut ={
      new Donut(name, productCode)
    }
  }

  //3. How to create instances of the Donut class using the companion object
  println("\nStep 3: How to create instances of the Donut class using the companion object")
  val glazedDonut1 = Donut("Glazed Donut", 1111)
  val vanillaDonut1 = Donut("Vanilla Donut", 2222)

  //4. How to call the print function for each of the donut object
  println("\nStep 4: How to call function on each Donut object")
  glazedDonut1.print
  vanillaDonut1.print


  //Scala Tutorial - Learn How To Use Companion Objects' Apply Method As A Factory (Class Hierarchy Via Inheritance)
  //1. How to define a simple class to represent a Donut object
  println("Step 1: How to define a simple class to represent a Donut object")
  class Donut1(name: String, productCode: Option[Long]= None){
    def print = println(s"Donut name = $name, productCode = ${productCode.getOrElse(0)}")
  }

  //2. How to declare class hierarchy through inheritance using extends keyword
  println("\nStep 2: How to declare class hierarchy through inheritance using extends keyword")
  class GlazedDonut(name: String) extends Donut1(name)
  class VanillaDonut(name: String) extends Donut1(name)

  //3. How to declare apply method of companion object as a factory
  println("\nStep 3: How to declare apply method of companion object as a factory")
  object Donut1{
    def apply(name: String): Donut1 = {
      name match{
        case "Glazed Donut" => new Donut1(name)
        case "Vanilla Donut" => new Donut1(name)
        case _ => new Donut1(name)
      }
    }
  }

  //4. How to call apply method of companion object which is a factory
  println("\nStep 4: How to call apply method of companion object which is a factory")
  val glazedDonut2 = Donut1("Glazed Donut")
  println(s"The class type of glazedDonut = ${glazedDonut2.getClass}")
  glazedDonut2.print

  val vanillaDonut2 = Donut1("Vanilla Donut")
  println(s"The class type of vanillaDonut = ${vanillaDonut2.getClass}")
  vanillaDonut.print

  //Scala Tutorial - Learn How To Declare Values And Fields In Companion Object

  println("Step 1: How to define a simple class to represent a Donut object")
  class Donut2(name: String, productCode: Option[Long] = None){

    def print = println(s"Donut name = $name, productCode = ${productCode.getOrElse(0)}, uuid = ${Donut2.uuid}")

  }

  object Donut2{
    private val uuid = 1

    def apply(name: String, productCode: Option[Long] = None): Donut2 = new Donut2(name, productCode)

    def apply(name: String): Donut2 = new Donut2(name)
  }

  //3. How to create instances of the Donut class using the Companion Object
  println("\nStep 3: How to create instances of the Donut class using the companion object")
  val glazedDonut3 = Donut2("Glazed Donut", Some(1111))
  val vanillaDonut3 = Donut2("Vanilla Donut")

  //4. How to call function on each Donut object
  println("\nStep 4: How to call function on each Donut object")
  glazedDonut3.print
  vanillaDonut3.print


  //Scala Tutorial - Learn How To Declare And Use Singleton Object
  //1. How to define a global field
  println("Step 1: How to declare a Singleton Object")
  object DonutShoppingCartCalculator {

    println("\nStep 2: How to define a global field")
    val discount: Double = 0.01


    println("\nStep 3: How to define utility function called calculateTotalCost")
    def calculateTotalCost(donuts: List[String]): Double = {
      // calculate the cost of donuts
      return 1
    }
  }
  //2. How to call global discount field from Step 2
  println("\nStep 4: How to call global discount field from Step 2")
  println(s"Global discount = ${DonutShoppingCartCalculator.discount}")

  //3.How to call the utility function calculateTotalCost from Step 3

  println("\nStep 5: How to call the utility function calculateTotalCost from Step 3")
  println(s"Call to calculateTotalCost function = ${DonutShoppingCartCalculator.calculateTotalCost(List())}")

  //Scala Tutorial - Learn How To Define And Use Case Class
  //1. How to define a case class to represent a Donut object
  println("Step 1: How to define a case class to represent a Donut object")
  case class Donut4(name: String, price: Double, productCode: Option[Long] = None)

  //2. How to create instances or objects for the Donut case class
  println("\nStep 2: How to create instances or objects for the Donut case class")
  val vanillaDonut4: Donut4 = Donut4("Vanilla Donut", 1.50)
  val glazedDonut4: Donut4 = Donut4("Glazed Donut", 2.0)
  println(s"Vanilla Donut = $vanillaDonut4")
  println(s"Glazed Donut = $glazedDonut4")

  //3. How to access fields of the Donut object
  println("\nStep 3: How to access fields of the Donut object")
  println(s"Vanilla Donut name field = ${vanillaDonut4.name}")
  println(s"Vanilla Donut price field = ${vanillaDonut4.price}")
  println(s"Vanilla Donut productCode field = ${vanillaDonut4.productCode}")

  //4.How to define the hashCode and equals method for Donut object
  println("\nStep 5: How to define the hashCode and equals method for Donut object")
  val shoppingCart: Map[Donut4, Int] = Map(vanillaDonut4 -> 4, glazedDonut4 -> 3)
  println(s"All items in shopping cart = ${shoppingCart}")

  println(s"Quantity of vanilla donuts in shopping cart = ${shoppingCart(vanillaDonut4)}")
  println(s"Quantity of glazed donuts in shopping cart = ${shoppingCart(glazedDonut4)}")

  //A case class also comes with a handy copy() method which you can use to copy an object and override any field. In return, the copy() method will create new instances of the given object.
  println("\nTIP: How to create a new object of Donut by using the copy() method of the case class")
  val chocolateVanillaDonut: Donut4 = vanillaDonut4.copy(name = "Chocolate And Vanilla Donut", price = 5.0)
  println(s"Chocolate And Vanilla Donut = $chocolateVanillaDonut")


  //Scala Tutorial - Learn How To Use Type Alias: Type Aliasing Versus Case Class
  //1.How to use type alias to name a Tuple2 pair into a domain type called CartItem
  println("\nStep 3: How to use type alias to name a Tuple2 pair into a domain type called CartItem")
  type CartItem[Donut, Int] = Tuple2[Donut, Int]

  //2. How to create instances of the aliased typed CartItem
  println("\nStep 4: How to create instances of the aliased typed CartItem")
  val cartItem = new CartItem(vanillaDonut4, 4)
  println(s"cartItem = $cartItem")
  println(s"cartItem first value = $cartItem._1")
  println(s"cartItem second value = $cartItem._2")

  //3.How to use an aliased typed into a function parameter
  println("\nStep 5: How to use an aliased typed into a function parameter")
  def calculateTotal(shoppingCartItems: Seq[CartItem[Donut4, Int]]): Double = {
    // calculate the total cost
    shoppingCartItems.foreach { cartItem =>
      println(s"CartItem donut = ${cartItem._1}, quantity = ${cartItem._2}")
    }
    10 // some random total cost
  }

  //4.How to use a case class instead of an aliased typed
  println("\nStep 6: How to use a case class instead of an aliased typed")
  case class ShoppingCartItem(donut: Donut4, quantity: Int)

  val shoppingItem: ShoppingCartItem = ShoppingCartItem(Donut4("Glazed Donut", 2.50), 10)
  println(s"shoppingItem donut = ${shoppingItem.donut}")
  println(s"shoppingItem quantity = ${shoppingItem.quantity}")

  //5.How to use case class from Step 6 to represent a Sequence of Donut items in a shopping cart
  println("\nStep 7: How to use case class from Step 6 to represent a Sequence of Donut items in a shopping cart")
  def calculateTotal2(shoppingCartItems: Seq[ShoppingCartItem]): Double = {
    // calculate the total cost
    shoppingCartItems.foreach { shoppingCartItem =>
      println(s"ShoppingCartItem donut = ${shoppingCartItem.donut}, quantity = ${shoppingCartItem.quantity}")
    }
    10 // some random total cost
  }

  //Scala Tutorial - Learn How To Use Implicit Class - Extension Methods




  //Scala Tutorial - Learn How To Use Package Object




  //Scala Tutorial - Learn How To Extend Class - Class Inheritance
  //1. How to define an abstract class called Donut
  println("Step 1: How to define an abstract class called Donut")
  abstract class Donut5(name: String){

    def printName: Unit

  }

  //2. How to extend abstract class Donut and define a sub-class of Donut called VanillaDonut
  println("\nStep 2: How to extend abstract class Donut and define a sub-class of Donut called VanillaDonut")
  class VanillaDonut5(name: String) extends Donut5(name){

    override def printName: Unit = println(name)
  }
  
  object VanillaDonut5{
    def apply(name: String): Donut5 = new VanillaDonut5(name)
  }

  //3. How to extend abstract class Donut and define another sub-class of Donut called GlazedDonut
  println("\nStep 3: How to extend abstract class Donut and define another sub-class of Donut called GlazedDonut")
  class GlazedDonut5(name: String) extends Donut5(name) {

    override def printName: Unit = println(name)

  }

  object GlazedDonut5 {

    def apply(name: String): Donut5 = {
      new GlazedDonut5(name)
    }

  }

  //4. How to instantiate Donut objects
  println("\nStep 4: How to instantiate Donut objects")
  val vanillaDonut5: Donut5 = VanillaDonut5("Vanilla Donut")
  vanillaDonut5.printName

  val glazedDonut5: Donut5 = GlazedDonut5("Glazed Donut")
  glazedDonut5.printName

  //Scala Tutorial - Learn How To Extend Case Class - Case Class Inheritance
  println("\nStep 2: How to extend abstract class Donut and define a case class called VanillaDonut")
  case class VanillaDonut6(name: String) extends Donut5(name) {

    override def printName: Unit = println(name)

  }

  println("\nStep 3: How to extend abstract class Donut and define another case class called GlazedDonut")
  case class GlazedDonut6(name: String) extends Donut5(name) {

    override def printName: Unit = println(name)

  }

  println("\nStep 4: How to instantiate Donut objects")
  val vanillaDonut6: Donut5 = VanillaDonut6("Vanilla Donut")
  vanillaDonut6.printName

  val glazedDonut6: Donut5 = GlazedDonut6("Glazed Donut")
  glazedDonut6.printName


  //Scala Tutorial - Learn How To Create Typed Class


  //Scala Tutorial - Learn How To Create Covariance Type Class


  //Scala Tutorial - Learn How To Create Contra-Variance Type Class



}
