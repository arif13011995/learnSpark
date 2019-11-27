package com.allaboutscala.chapter.one.tutorial_04

object Function extends App{
  //Learn How To Create And Use Functions
  //1. How to define and use a function which has no parameters and has a return type
  println("Step 1: How to define and use a function which has no parameters and has a return type")
  def favoriteDonut(): String = {
    "Glazed Donut"
  }

  val myFavoriteDonut = favoriteDonut()
  println(s"My favorite donut is $myFavoriteDonut")

  //2. How to define and use a function with no parenthesis
  println("\nStep 2: How to define and use a function with no parenthesis")
  def leastFavoriteDonut = "Plain Donut"
  println(s"My least favorite donut is $leastFavoriteDonut")


  //3. How to define and use a function with no return type
  println("\nStep 3: How to define and use a function with no return type")
  def printDonutSalesReport(): Unit = {
    // lookup sales data in database and create some report
    println("Printing donut sales report... done!")
  }
  printDonutSalesReport()

  //Learn How To Create Function With Parameters

  //1. How to define function with parameters

  println("Step 1: How to define function with parameters")
  def calculateDonutCost(donutName: String, quantity: Int): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity")

    //make some calculation
    2.5 * quantity
  }

  //2. How to call a function with parameters
  println("\nStep 2: How to call a function with parameters")
  val totalCost = calculateDonutCost("Glazed Donut", 5)
  println(s"Total cost of donuts = $totalCost")

  //3. How to add default values to function parameters
  println("\nStep 3: How to add default values to function parameters")
  def calculateDonutCost2(donutName: String, quantity: Int, couponCode: String = "NO CODE"): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity, couponCode = $couponCode")
    // make some calculations ...
    2.50 * quantity
  }

  //4. How to call a function with parameters that has default values
  println("\nStep 4: How to call a function with parameters that has default values")
  val totalCostWithDiscount = calculateDonutCost2("Glazed Donut", 4, "COUPON_12345")
  val totalCostWithoutDiscount = calculateDonutCost2("Glazed Donut", 4)

  //Using Option in parameter
  println("Step 1: How to define an Option in a function parameter")
  def calculateDonutCost1(donutName: String, quantity: Int, couponCode: Option[String]): Double ={
    println(s"Calculating cost for $donutName, quantity = $quantity")
    couponCode match {
      case Some(value) =>
        val discount = 0.1 //Let's simulate a 10% discount
        val totalCost = 2.5 * quantity * (1- discount)
        totalCost

      case None => 2.50 * quantity
    }
  }

  //2. How to call a function which has an Option parameter
  println("\nStep 2: How to call a function which has an Option parameter")
  println(s"""Total cost = ${calculateDonutCost1("Glazed Donut", 5, None)}""")

  //3. How to assign a default value to an Option parameter
  println("\nStep 3: How to assign a default value to an Option parameter")
  def calculateDonutCostWithDefaultOptionValue(donutName: String, quantity: Int, couponCode: Option[String] = None): Double = {
    println(s"Calculating cost for $donutName, quantity = $quantity")

    couponCode match{
      case Some(coupon) =>
        val discount = 0.1 // Let's simulate a 10% discount
      val totalCost = 2.50 * quantity * (1 - discount)
        totalCost

      case _ => 2.50 * quantity
    }
  }

  //4. How to call a function whose Option parameter has a default value

  println("Step 4: How to call a function which has an Option parameter with a default value")
  println(s"""Total cost = ${calculateDonutCostWithDefaultOptionValue("Glazed Donut", 5)}""")
  println(s"""Total cost with discount = ${calculateDonutCostWithDefaultOptionValue("Glazed Donut", 5, Some("COUPON_1234"))}""")

  //How to use the map function to extract a valid Option value
  println(s"\nTip 1: Use the map function to extract a valid Option value")
  val favoriteDonut2: Option[String] = Some("Glazed Donut")
  favoriteDonut2.map(d => println(s"Favorite donut = $d"))

  val leastFavoriteDonut2: Option[String] = None
  leastFavoriteDonut2.map(d => println(s"Least Favorite donut = $d"))

  //Scala Tutorial - Learn How To Create Function With Option Return Type
  println(s"Step 1: Define a function which returns an Option of type String")
  def dailyCouponCode(): Option[String] ={
    // look up in database if we will provide our customers with a coupon today
    val couponFromDB = "COUPON_1234"
    Option(couponFromDB).filter(_.nonEmpty)
  }

  //2. How to call function with Option return type using getOrElse
  println(s"\nStep 2: Call function with Option return type using getOrElse")
  val todayCoupon: Option[String] = dailyCouponCode()
  println(s"Today's coupon code = ${todayCoupon.getOrElse("No coupon's Today")}")

  //3. How to call a function with Option return type using pattern matching
  println(s"\nStep 3: Call function with Option return type using pattern matching")
  dailyCouponCode() match {
    case Some(couponCode) => println(s"Today's coupon code = $couponCode")
    case None => println(s"Sorry there is no coupon code today!")
  }

  //4. How to call function with Option return type using map() function
  println(s"\nStep 4: Call function with Option return type using map")
  dailyCouponCode().map(couponCode => println(s"Today's coupon code = $couponCode"))

  //5. Review function calculateDonutCost() function from previous tutorial
  // apply daily coupon code if we have one
  println(s""" Total cost daily coupon code = ${calculateDonutCost1("Glazed Donut", 5, dailyCouponCode())}""")


  //using fold to extract the result from function which returns Option
  println(s"\nTip - 1: Call function with Option return type using fold")
  val todayCouponUsingFold: String = dailyCouponCode().fold("No coupon Available")(couponCode => couponCode)
  println(s"Today's coupon code = $todayCouponUsingFold")


  //Scala Tutorial - Learn How To Create Function With Implicit Parameters
  //1. How to define a function which has an implicit parameter
  println(s"Step 1: How to define a function with an implicit parameter")
  def totalCost(donutType: String, quantity: Int)(implicit discount: Double): Double = {
    println(s"Calculating the price for $quantity $donutType")
    val totalCost = 2.50 * quantity * (1 - discount)
    totalCost
  }

  //2. How to define an implicit value
  println("\nStep 2: How to define an implicit value")
  implicit val discount: Double = 0.1
  println(s"All customer will receive a ${discount * 100}% discount")

  //3. Hot to call a function which has an implicit parameter
  println("\nStep 3: How to call a function which has an implicit parameter")
  println(s"""Total cost with discount of 5 Glazed Donuts = ${totalCost("Glazed Donut", 5)}""")

  //4. How to define a function which takes multiple implicit parameters
  println("\nStep 4: How to define a function which takes multiple implicit parameters")
  def totalCost2(donutType: String, quantity: Int)(implicit discount: Double, storeName: String): Double = {
    println(s"[$storeName] Calculating the price for $quantity $donutType")
    val totalCost = 2.50 * quantity * (1 - discount)
    totalCost
  }

  //5. How to call a function which takes multiple implicit parameters

  println("\nStep 5: How to call a function which takes multiple implicit parameters")
  implicit val storeName: String = "Tasty Donut Store"
  println(s"""Total cost with discount of 5 Glazed Donuts = ${totalCost2("Glazed Donut", 5)}""")

  //6. How to manually pass-through implicit parameters
  println("\nStep 6: How to manually pass-through implicit parameters")
  println(s"""Total cost with discount of 5 Glazed Donuts, manually passed-through = ${totalCost2("Glazed Donut", 5)(0.1, "Scala Donut Store")}""")

  //Scala Tutorial - Learn How To Create Implicit Function
  //1. How to create a wrapper String class which will extend the String type
  println("Step 1: How to create a wrapper String class which will extend the String type")
  class DonutString(s: String) {

    def isFavoriteDonut: Boolean = s == "Glazed Donut"

  }

  //2. How to create an implicit function to convert a String to the wrapper String class
  println("\nStep 2: How to create an implicit function to convert a String to the wrapper String class")
  object DonutConversions{
    implicit  def stringToDonutString(s: String) = new DonutString(s)
  }

  //3. How to import the String conversion so that it is in scope
  println("\nStep 3: How to import the String conversion so that it is in scope")
  import DonutConversions._

  //4. How to create String values
  println("\nStep 4: How to create String values")
  val glazedDonut = "Glazed Donut"
  val vanillaDonut = "Vanilla Donut"

  //5. How to access the custom String function called isFavoriteDonut
  println("\nStep 5: How to access the custom String function called isFavaoriteDonut")
  println(s"Is Glazed Donut my favorite Donut = ${glazedDonut.isFavoriteDonut}")
  println(s"Is Vanilla Donut my favorite Donut = ${vanillaDonut.isFavoriteDonut}")

  //Scala Tutorial - Learn How To Create Typed Function
  //1. How to define a function which takes a String parameter
  println("Step 1: How to define a function which takes a String parameter")
  def applyDiscount(couponCode: String) {
    println(s"Lookup percentage discount in database for $couponCode")
  }

  //2. How to define a function which takes a parameter of type Double
  println("\nStep 2: How to define a function which takes a parameter of type Double")
  def applyDiscount(percentageDiscount: Double) {
    println(s"$percentageDiscount discount will be applied")
  }

  //3. Calling applyDiscount function with String or Double parameter types
  println("\nStep 3: Calling applyDiscount function with String or Double parameter types")
  applyDiscount("COUPON_1234")
  applyDiscount(10)

  //4. How to define a generic typed function which will specify the type of its parameter
  println("\nStep 4: How to define a generic typed function which will specify the type of its parameter")
  def applyDiscount[T](discount: T){
    discount match {
      case d: String =>
        println(s"Lookup percentage discount in database for $d")

      case d: Double =>
        println(s"$d discount will be applied")

      case _ =>
        println("Unsupported discount type")
    }
  }

  //5. How to call a function which has typed parameters
  println("\nStep 5: How to call a function which has typed parameters")
  applyDiscount[String]("COUPON_123")
  applyDiscount[Double](10)

  //6. How to define a polymorphic typed function which also has a generic return type
  println("\nStep 3: How to define a generic typed function which also has a generic return type")
  def applyDiscountWithReturnType[T](discount: T): Seq[T] = {
    discount match {
      case d: String =>
        println(s"Lookup percentage discount in database for $d")
        Seq[T](discount)

      case d: Double =>
        println(s"$d discount will be applied")
        Seq[T](discount)

      case d @ _ =>
        println("Unsupported discount type")
        Seq[T](discount)
    }
  }

  //7. How to call a generic polymorphic function which also has a generic return type
  println("\nStep 4: How to call a generic typed function which also has a generic return type")
  println(s"Result of applyDiscountWithReturnType with String parameter = ${applyDiscountWithReturnType[String]("COUPON_123")}")

  println()
  println(s"Result of applyDiscountWithReturnType with Double parameter = ${applyDiscountWithReturnType[Double](10.5)}")

  println()
  println(s"Result of applyDiscountWithReturnType with Char parameter = ${applyDiscountWithReturnType[Char]('U')}")

  //Scala Tutorial - Learn How To Create Variable Argument Function - varargs :_ *
  //1. How to define function which takes variable number of arguments
  def printReport(names: String*) {
    println(s"""Donut Report = ${names.mkString(" - ")}""")
  }

  //2. How to call function which takes variable number of String arguments
  println("\nStep 2: How to call function which takes variable number of String arguments")
  printReport("Glazed Donut", "Strawberry Donut", "Vanilla Donut")
  printReport("Chocolate Donut")

  //3. How to pass a List to a function with variable number of arguments
  println("\nStep 3: How to pass a List to a function with variable number of arguments")
  val listDonuts: List[String] = List("Glazed Donut", "Strawberry Donut", "Vanilla Donut")
  printReport(listDonuts: _*)


  //Scala Tutorial - Learn How To Create Functions As Symbols
  //1. How to create and instantiate a class
  class DonutCostCalculator{
    val totalCost = 100

    def minusDiscount(discount: Double): Double={
      totalCost - discount
    }

    // Step 3: How to define function whose name is just the symbol minus -
    def -(discount: Double): Double = {
      totalCost - discount
    }
  }


  println("Step 1: How to create and instantiate a class")
  val donutCostCalculator = new DonutCostCalculator()

  //2. How to call a function from an instantiated class
  println("\nStep 2: How to call a function from an instantiated class")
  println(s"Calling minusDiscount() function = ${donutCostCalculator.minusDiscount(10.5)}")


  println("\nStep 5: How to call a function using the operator style notation")
  println(s"Calling function - with operator style notation = ${donutCostCalculator - 10.5}")

  //Scala Tutorial - Learn How To Create Function Currying With Parameter Groups
  //1. How to define function with curried parameter groups
  println("Step 1: How to define function with curried parameter groups")
  def totalCost1(donutType: String)(quantity: Int)(discount: Double): Double = {
    println(s"Calculating total cost for $quantity $donutType with ${discount * 100}% discount")
    val totalCost = 2.50 * quantity
    totalCost - (totalCost * discount)
  }

  //2. How to call a function with curried parameter groups
  println("\nStep 2: How to call a function with curried parameter groups")
  println(s"Total cost = ${totalCost1("Glazed Donut")(10)(0.1)}")

  //3.How to create a partially applied function from a function with curried parameter groups
  println("\nStep 3: How to create a partially applied function from a function with curried parameter groups")
  val totalCostForGlazedDonuts = totalCost1("Glazed Donuts")_

  println("\nStep 4: How to call a partially applied function")
  println(s"\nTotal cost for Glazed Donuts ${totalCostForGlazedDonuts(10)(0.5)}")

  //Scala Tutorial - Learn How To Create Higher Order Function - Function As Parameter
  //1. How to define a higher order function which takes another function as parameter
  println("\nStep 2: How to define a higher order function which takes another function as parameter")
  def totalCostWithDiscountFunctionParameter(donutType: String)(quantity: Int)(f:Double => Double): Double ={
    println(s"Calculating total cost for $quantity $donutType")
    val totalCost = 2.50 * quantity
    f(totalCost)
  }

  //2. How to call higher order function and pass an anonymous function as parameter
  println("\nStep 3: How to call higher order function and pass an anonymous function as parameter")
  val totalCostOf5Donuts = totalCostWithDiscountFunctionParameter("Glazed Donuts")(5){totalCost =>
    val discount = 2
    totalCost - discount
  }
  println(s"Total cost of 5 Glazed Donuts with anonymous discount function = $totalCostOf5Donuts")

  //3.How to define and pass a function to a higher order function
  println("\nStep 4: How to define and pass a function to a higher order function")
  def applyDiscount1(totalCost: Double): Double ={
  val discount = 2
  totalCost - discount
  }

  println(s"Total cost of 5 Glazed Donuts with discount function = ${totalCostWithDiscountFunctionParameter("Glazed Donut")(5)(applyDiscount1(_))}")

  //Scala Tutorial - Learn How To Create Higher Order Function - Call-By-Name Function




  //Scala Tutorial - Learn How To Create Higher Order Function - Callback Function Parameter




  //Scala Tutorial - Learn How To Create Function Using The Val Keyword Instead Of Def
  println("\nStep 3: How to define and pass a val function to a higher order function")
  val applyDiscountValueFunction = (totalCost: Double) => {
    val discount = 2 // assume you fetch discount from database
    totalCost - discount
  }
  println(s"Total cost of 5 Glazed Donuts with discount val function = ${totalCostWithDiscountFunctionParameter("Glazed Donut")(5)(applyDiscountValueFunction)}")

  //Scala Tutorial - Learn Function Composition Using AndThen
  //1. Assume a pre-calculated total cost amount
  println("Step 1: Assume a pre-calculated total cost amount")
  val totalCost1: Double = 10

  //2. How to define a val function to apply discount to total cost
  println("\nStep 2: How to define a val function to apply discount to total cost")
  val applyDiscountValFunction = (amount: Double) => {
    println("Apply discount function")
    val discount = 2 // fetch discount from database
    amount - discount
  }

  //3. How to call a val function
  println("\nStep 3: How to call a val function")
  println(s"Total cost of 5 donuts with discount = ${applyDiscountValFunction(totalCost1)}")

  //4. How to define a val function to apply tax to total cost
  println("\nStep 4: How to define a val function to apply tax to total cost")
  val applyTaxValFunction = (amount: Double) => {
    println("Apply tax function")
    val tax = 1 // fetch tax from database
    amount + tax
  }

  //5. How to call andThen on a val function
  println("\nStep 5: How to call andThen on a val function")
  println(s"Total cost of 5 donuts = ${(applyDiscountValFunction andThen applyTaxValFunction)(totalCost1)}")

  println(s"Total cost of 5 donuts = ${(applyDiscountValFunction compose applyTaxValFunction)(totalCost1)}")

  //Scala Tutorial - Learn How To Create Tail Recursive Function - @annotation.tailrec
  println("Step 1: How to define an Array of type String")
  val arrayDonuts: Array[String] = Array("Vanilla Donut", "Strawberry Donut", "Plain Donut", "Glazed Donut")
  println("\nStep 2: How to define a tail recursive function")
  //@annotation.tailrec

  def search(donutName: String, donuts: Array[String], index: Int): Option[Boolean] ={
    if(donuts.length == index){
      None
    }else if(donuts(index) == donutName){
      Some(true)
    }else{
      val nextIndex = index + 1
      search(donutName, donuts, nextIndex)
    }
  }

  println("\nStep 3: How to call a tail recursive function")
  val found = search("Glazed Donut", arrayDonuts, 0)
  println(s"Find Glazed Donut = $found")

  val notFound = search("Chocolate Donut", arrayDonuts, 0)
  println(s"Find Chocolate Donut = $notFound")

  //Scala Tutorial - Learn How To Create Trampoline Tail Recursive Function Using scala.util.control.TailCalls._



  //Scala Tutorial - Learn How To Create Partial Function Using the PartialFunction Trait


  //Scala Tutorial - Learn How To Create Nested Function
  //1. How to define a function
  println("Step 1: How to define a function")
  def checkDonutAvailability(donutName: String): Boolean = {
    // retrieve donut list that is currently in stock
    val listDonutsFromStock: List[String] = List("Vanilla Donut", "Strawberry Donut", "Plain Donut", "Glazed Donut")

    val iDonutInStock = (donutName.nonEmpty && donutName.length > 0) && (listDonutsFromStock contains donutName)

    iDonutInStock
  }

  //2. How to call a function
  println("\nStep 2: How to call a function")
  println(s"Calling checkDonutAvailability with Vanilla Donut = ${checkDonutAvailability("Vanilla Donut")}")

  //3. How to define a Nested Function
  println("\nStep 3: How to define a Nested Function")
  def checkDonutAvailabilityWithNestedFunction(donutName: String): Boolean = {
    // retrieve donut list that is currently in stock
    val listDonutsFromStock = List[String]("Vanilla Donut", "Strawberry Donut", "Plain Donut", "Glazed Donut")

    // validate the donutName parameter by some business logic
    val validate = (name: String) => {
      name.nonEmpty && name.length > 0
    }

    // first run validate and then check if we have a matching donut from our list
    val isDonutInStock = validate(donutName) && (listDonutsFromStock contains donutName)

    isDonutInStock
  }

  //4. How to call a Nested Function
  println("\nStep 4: How to call a Nested Function")
  println(s"Calling checkDonutAvailabilityWithNestedFunction with Vanilla Donut = ${checkDonutAvailabilityWithNestedFunction("Vanilla Donut")}")




}
