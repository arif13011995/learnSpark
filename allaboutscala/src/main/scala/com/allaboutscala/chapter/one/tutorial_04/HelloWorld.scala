package com.allaboutscala.chapter.one.tutorial_04

object HelloWorld extends App{
  println("Step 1: Using String interpolation to print a variable")
  val favoriteDonut: String = "Glazed Donut"
  println(s"My favorite donut = $favoriteDonut")

  println("\nStep 2: Using String interpolation on object properties")
  case class Donut(name: String, tasteLevel: String)

  val favoriteDonut1 : Donut = Donut("Glazed Donut", "Very Tasty")
  println(s"My favorite donut name = ${favoriteDonut1.name}, tasteLevel = ${favoriteDonut1.tasteLevel}")

  println("\nStep 3: Using String interpolation to evaluate expressions")
  val qtyDonutsToBuy: Int = 10
  println(s"Are we buying 10 donuts = ${qtyDonutsToBuy == 10}")

  println("\nStep 4: Using String interpolation for formatting text")
  val donutName: String = "Vanilla Donut"
  val donutTasteLevel: String = "Tasty"
  println(f"$donutName%25s $donutTasteLevel")

  println("\nStep 5: Using f interpolation to format numbers")
  val donutPrice: Double = 2.50
  println(s"Donut price = $donutPrice")
  println(f"Formatted donut price = $donutPrice%.2f")

  println("\nStep 6: Using raw interpolation")
  println(raw"Favorite donut\t$donutName")

//  StripMargin
  val donutJson4: String =
  """
    |{
    |"donut_name":"Glazed Donut",
    |"taste_level":"Very Tasty",
    |"price":2.50
    |}
  """
    .stripMargin
  println(donutJson4)

  //  StripMargin
  val donutJson5: String =
    """
      #{
      #"donut_name":"Glazed Donut",
      #"taste_level":"Very Tasty",
      #"price":2.50
      #}
    """
      .stripMargin('#')
  println(donutJson5)

  //Scala Variable
  println("\nStep 2: Scala Types")
  val donutsBoughtToday = 5
  val bigNumberOfDonuts = 100000000L
  val smallNumberOfDonuts = 1
  val priceOfDonut = 2.50
  val donutPrice1 = 2.50f
  val donutStoreName = "Allaboutscala Donut Store"
  val donutByte = 0xa
  val donutFirstLetter = 'D'
  val nothing = ()

  println("\nStep 3: Using Scala compiler to convert from one data type to another")
  val numberOfDonuts: Short = 1
  val minimumDonutsToBuy: Int = numberOfDonuts
  println(minimumDonutsToBuy)
  //conversion int to string
  println("Convert int to String :" + minimumDonutsToBuy.toString)
  println("1".toInt)


  //for loops
  //1. A simple for loop from 1 to 5 inclusive
  println("Step 1: A simple for loop from 1 to 5 inclusive")
  for(numberOfDonuts <- 1 to 5){
    println(s"Number of donuts to buy = $numberOfDonuts")
  }

  //2.A simple for loop from 1 to 5, where 5 is NOT inclusive
  println("\nStep 2: A simple for loop from 1 to 5, where 5 is NOT inclusive")
  for(numberOfDonuts <- 1 until 5){
    println(s"Number of donuts to buy = $numberOfDonuts")
  }

  //3.Filter values using if conditions in for loop
  println("\nStep 3: Filter values using if conditions in for loop")
  val donutIngredients = List("flour", "sugar", "egg yolks", "syrup", "flavouring")
  for(ingredient <- donutIngredients if ingredient == "sugar"){
    println(s"Found sweetening ingredient = $ingredient")
  }

  //4.Filter values using if conditions in for loop and return the result back using the yield keyword
  println("\nStep 4: Filter values using if conditions in for loop and return the result back using the yield keyword")
  val sweeteningIngredients = for {
    ingredient <- donutIngredients
    if (ingredient == "sugar" || ingredient == "syrup")
  } yield ingredient
  println(s"Sweetening ingredients = $sweeteningIngredients")

  //5.Using for comprehension to loop through 2-Dimensional array
  val twoDimensionalArray = Array.ofDim[String](2,2)
  twoDimensionalArray(0)(0) = "flour"
  twoDimensionalArray(0)(1) = "sugar"
  twoDimensionalArray(1)(0) = "egg"
  twoDimensionalArray(1)(1) = "syrup"
  for { x <- 0 until 2
        y <- 0 until 2
  } println(s"Donut ingredient at index ${(x,y)} = ${twoDimensionalArray(x)(y)}")


  //Using Range in Scala
  //1.Create a simple numeric range from 1 to 5 inclusive
  println("Step 1: Create a simple numeric range from 1 to 5 inclusive")
  val from1To5 = 1 to 5
  println(s"Range from 1 to 5 inclusive = $from1To5")

  //2. Create a numeric range from 1 to 5 but excluding the last integer number 5
  println("\nStep 2: Create a numeric range from 1 to 5 but excluding the last integer number 5")
  val from1Until5 = 1 until 5
  println(s"Range from 1 until 5 where 5 is excluded = $from1Until5")

  //3. Create a numeric range from 0 to 10 but increment with multiples of 2
  println("\nStep 3: Create a numeric range from 0 to 10 but increment with multiples of 2")
  val from0To10By2 = 0 to 10 by 2
  println(s"Range from 0 to 10 with multiples of 2 = $from0To10By2")

  //4. Create an alphabetical range to represent letter a to z
  println("\nStep 4: Create an alphabetical range to represent letter a to z")
  val alphabetRangeFromAToZ = 'a' to 'z'
  println(s"Range of alphabets from a to z = $alphabetRangeFromAToZ")

  //5. Character ranges with user specified increment\
  println(s"\nStep 5: Character ranges with user specified increment")
  val alphabetRangeFromAToZBy2 = 'a' to 'z' by 2
  println(s"Range of every other alphabet = $alphabetRangeFromAToZBy2")

  //for (a<- 'a' to 'z' by 2){print(a)}

  //6. Convert the Scala Range into collections
  println("\nStep 6: Storing our ranges into collections")
  val listFrom1To5 = (1 to 5).toList
  println(s"Range to list = ${listFrom1To5.mkString(" ")}")

  val setFrom1To5 = (1 to 5).toSet
  println(s"Range to set = ${setFrom1To5.mkString(" ")}")

  val sequenceFrom1To5 = (1 to 5).toSeq
  println(s"Range to sequence = ${sequenceFrom1To5.mkString(" ")}")

  val arrayFrom1To5 = (1 to 5).toArray
  println(s"Range to array = ${arrayFrom1To5.mkString(" ")}")

  //println(from1To5.mkString(","))
  //from1To5.foreach(print(_)) === from1To5.foreach(u => print(_))

  //while and do while
  //1. How to use while loop in Scala
  println("Step 1: How to use while loop in Scala")
  var numberOfDonutsToBake = 10
  while (numberOfDonutsToBake > 0) {
    println(s"Remaining donuts to be baked = $numberOfDonutsToBake")
    numberOfDonutsToBake -= 1
  }

  //2. How to use do while loop in Scala
  println("\nStep 2: How to use do while loop in Scala")
  var numberOfDonutsBaked = 0
  do {
    numberOfDonutsBaked += 1
    println(s"Number of donuts baked = $numberOfDonutsBaked")
  } while (numberOfDonutsBaked < 5)

  //Pattern Matching
  //1. Pattern matching 101 - a very basic example
  println("Step 1: Pattern matching 101 - a very basic example")
  var donutType = "Glazed Donut"
  donutType match {
    case "Glazed Donut" => println("Very Tasty")
    case "Plain Donut" => println("Tasty")
  }

  //2. Pattern matching and return the result
  println("\nStep 2: Pattern matching and return the result")
  var tasteLevel = donutType match {
    case "Glazed Donut" => "Very tasty"
    case "Plain Donut" => "Tasty"
  }
  println(s"Taste level of $donutType = $tasteLevel")

  //3. Pattern matching using the wildcard operator
  println("\nStep 3: Pattern matching using the wildcard operator")
  var tasteLevel2 = donutType match {
    case "Glazed Donut" => "Very tasty"
    case "Plain Donut" => "Tasty"
    case _ => "Tasty"
  }
  println(s"Taste level of $donutType = $tasteLevel2")

  //4. Pattern matching with two or more items on the same condition
  println("\nStep 4: Pattern matching with two or more items on the same condition")
  val tasteLevel3 = donutType match {
    case "Glazed Donut" | "Strawberry Donut" => "Very tasty"
    case "Plain Donut" => "Tasty"
    case _ => "Tasty"
  }
  println(s"Taste level of $donutType = $tasteLevel3")

  //5. Pattern matching and using if expressions in the case clause
  println("\nStep 5; Pattern matching and using if expressions in the case clause")
  var tasteLevel4 = donutType match {
    //case donut if(donut.contains("Glazed") || donut.contains("Strawberry")) => "Very Tasty"
    case "Plain Donut" => "Tasty"
    case _ => "Tasty"
  }
  println(s"Taste Level of $donutType = $tasteLevel4")

  //6. Pattern matching by types
  println("\nStep 6: Pattern matching by types")
  val priceOfDonut1: Any = 2.50
  val priceType = priceOfDonut1 match {
    case price: Int => "Int"
    case price: Double => "Double"
    case price: Float => "Float"
    case price: String => "String"
    case price: Boolean => "Boolean"
    case price: Char => "Char"
    case price: Long => "Long"
  }

  println(s"Donut price type = $priceType")

  //Tuples
  //1. Using Tuple2 to store 2 data points
  println("Step 1: Using Tuple2 to store 2 data points")
  val glazedDonutTuple = Tuple2("Glazed Donut", "Very Tasty")
  println(s"Glazed Donut with 2 data points = $glazedDonutTuple")

  //2. Access each element in tuple
  println("\nStep 2: Access each element in tuple")
  val donutType1 = glazedDonutTuple._1
  val donutTasteLevel1 = glazedDonutTuple._2
  println(s"$donutType1 taste level is $donutTasteLevel1")

  //3. Using TupleN classes to store more than 2 data points
  println("\nStep 3: Using TupleN classes to store more than 2 data points")
  val glazedDonut = Tuple3("Glazed Donut", "Very Tasty", 2.50)
  println(s"${glazedDonut._1} taste level is ${glazedDonut._2} and it's price is ${glazedDonut._3}")


  //4. How to use pattern matching on Tuples
  println("\nStep 4: How to use pattern matching on Tuples")
  val strawberryDonut = Tuple3("Strawberry Donut", "Very Tasty", 2.50)
  val plainDonut = Tuple3("Plain Donut", "Tasty", 2)
  val donutList = List(glazedDonut, strawberryDonut, plainDonut)
  val priceOfPlainDonut = donutList.foreach { tuple => {
      tuple match {
        case ("Plain Donut", taste, price) => println(s"Donut type = Plain Donut, price = $price")
        case d if d._1 == "Glazed Donut" => println(s"Donut type = ${d._1}, price = ${d._3}")
        case _ => None
      }
    }
  }

  //more elegant ways
  println("\nTip 1: A more elegant pattern matching within foreach function")
  donutList.foreach {
    case ("Plain Donut", taste, price) => println(s"Donut type = Plain Donut, price = $price")
    case d if d._1 == "Glazed Donut" => println(s"Donut type = ${d._1}, price = ${d._3}")
    case _ => None
  }

  //5. Shortcut for creating Tuples
  println("\nStep 5: Shortcut for creating Tuples")
  val chocolateDonut = ("Chocolate Donut", "Very Tasty", 3.0)
  println(s"Chocolate donut taste level = ${chocolateDonut._2}, price = ${chocolateDonut._3}")



  //Learn How To Use Option - Avoid Null (ISNULL)
  //1. How to use Option and Some - a basic example
  println("Step 1: How to use Option and Some - a basic example")
  val glazedDonutTaste: Option[String] = Some("Very Tasty")
  println(s"Glazed Donut taste = ${glazedDonutTaste.get}")

  //2. How to use Option and None - a basic example
  println("\nStep 2: How to use Option and None - a basic example")
  val glazedDonutName: Option[String] = None
  println(s"Glazed Donut name = ${glazedDonutName.getOrElse("Glazed Donut")}")

  //3. How to use Pattern Matching with Option better ways
  println("\nStep 3: How to use Pattern Matching with Option")
  glazedDonutName match {
    case Some(name) => println(s"Received donut name = $name")
    case None       => println(s"No donut name was found!")
  }


  //You can use the map() function as a more elegant way of filtering out None.
  println("\nTip 1: Filter None using map function")
  glazedDonutTaste.map(taste => println(s"glazedDonutTaste = $taste"))
  glazedDonutName.map(name => println(s"glazedDonutName = $name"))


  //Learn How To Create And Use Enumerations (enum)
  //1. How to create an Enumeration
  println("Step 1: How to create an enumeration")
  object Donut extends Enumeration{
    type Donut = Value

    val Glazed      = Value("Glazed")
    val Strawberry  = Value("Strawberry")
    val Plain       = Value("Plain")
    val Vanilla     = Value("Vanilla")
    val strawberry = Value("Strawberry")
  }

  //2. How to print the String value of the enumeration
  println("\nStep 2: How to print the String value of the enumeration")
  println(s"Vanilla Donut string value = ${Donut.Vanilla}")

  //3. How to print the id of the enumeration
  println("\nStep 3: How to print the id of the enumeration")
  println(s"Vanilla Donut's id = ${Donut.Vanilla.id}")

  //4. How to print all the values listed in Enumeration
  println("\nStep 4: How to print all the values listed in Enumeration")
  println(s"Donut types = ${Donut.values}")

  //5. How to pattern match on enumeration values
  println("\nStep 5: How to pattern match on enumeration values")
  Donut.values.foreach {
    case d if (d == Donut.Strawberry || d == Donut.Glazed) => println(s"Found favourite donut = $d")
    case _ => None
  }

  //6. How to change the default ordering of enumeration values
  println("\nStep 6: How to change the default ordering of enumeration values")
  object DonutTaste extends Enumeration{
    type DonutTaste = Value

    val Tasty       = Value(0, "Tasty")
    val VeryTasty   = Value(1, "Very Tasty")
    val Ok          = Value(-1, "Ok")
  }

  println(s"Donut taste values = ${DonutTaste.values}")
  println(s"Donut taste of OK id = ${DonutTaste.Ok.id}")

}
