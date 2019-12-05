package com.allaboutscala.chapter.one.tutorial_04

object CollectionFunctions extends App {
  //Aggregate Function
  println("Step 1: How to initialize a Set of type String to represent Donut elements")
  val donutBasket1: Set[String] = Set("Plain Donut", "Strawberry Donut")
  println(s"Elements of donutBasket1 = $donutBasket1")

  println("\nStep 2: How to define an accumulator function to calculate the total length of the String elements")
  val donutLengthAccumulator: (Int, String) => Int = (accumulator, donutName) => (accumulator + donutName.length)

  println("\nStep 3: How to call aggregate function with the accumulator function from Step 2")
  val totalLength = donutBasket1.aggregate(0)(donutLengthAccumulator, _+_)
  println(s"Total length of elements in donutBasket1 = $totalLength")

  println("\nStep 4: How to initialize a Set of Tuple3 elements to represent Donut name, price and quantity")
  val donutBasket2: Set[(String, Double, Int)] = Set(("Plain Donut", 1.50, 10), ("Strawberry Donut", 2.0, 10))
  println(s"Elements of donutBasket2 = $donutBasket2")

  println("\nStep 5: How to define an accumulator function to calculate the total cost of Donuts")
  val totalCostCustomer: (Double, Double, Int) => Double = (accumulator, price, quantity) => accumulator + (price * quantity)

  println("\nStep 6: How to call aggregate function with accumulator function from Step 5")
  val totalCost = donutBasket2.aggregate(0.0)((accumulator: Double, tuple:(String, Double, Int)) => totalCostCustomer(accumulator, tuple._2, tuple._3), _+_)
  println(s"Total cost of donuts in donutBasket2 = $totalCost")

  //collect
  println("Step 1: How to initialize a Sequence which contains donut names and prices")
  val donutNamesandPrices: Seq[Any] = Seq("Plain Donut", 1.5, "Strawberry Donut", 2.0, "Glazed Donut", 2.5)
  println(s"Elements of donutNamesAndPrices = $donutNamesandPrices")

  //How to use collect function to cherry pick all the donut names
  println("\nStep 2: How to use collect function to cherry pick all the donut names")
  val donutNames: Seq[String] = donutNamesandPrices.collect{ case name:String => name}
  println(s"Elements of donutNames = $donutNames")

  println("\nStep 3: How to use collect function to cherry pick all the donut prices")
  val donutPrices: Seq[Double] = donutNamesandPrices.collect{case price: Double => price}
  println(s"Elements of donutPrices = $donutPrices")



  //Diff Function
  println("Step 1: How to initialize a Set containing 3 donuts")
  val donutBasket3: Set[String] = Set("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donutBasket1 = $donutBasket3")

  println("\nStep 2: How to initialize a Set containing 2 donuts")
  val donutBasket4: Set[String] = Set("Glazed Donut", "Vanilla Donut")
  println(s"Elements of donutBasket2 = $donutBasket4")

  println("\nStep 3: How to find the difference between two Sets using the diff function")
  val diffDonutBasket1From2: Set[String] = donutBasket3 diff donutBasket4
  println(s"Elements of diffDonutBasket1From2 = $diffDonutBasket1From2")

  println("\nStep 4: How to find the difference between two Sets using the diff function")
  val diffDonutBasket2From1: Set[String] = donutBasket4 diff donutBasket3
  println(s"Elements of diff DonutBasket2From1 = $diffDonutBasket2From1")

  println("\nStep 5: How to find the difference between two Sets using the --")
  println(s"Difference between donutBasket1 and donutBasket2 = ${donutBasket3 -- donutBasket4}")
  println(s"Difference between donutBasket2 and donutBasket1 = ${donutBasket4 -- donutBasket3}")

  //Drop Function
  println("Step 1: How to initialize a Sequence of donuts")
  val donuts: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts")

  println("\nStep 2: How to drop the first element using drop function")
  println(s"Drop the first element in the sequence = ${donuts.drop(1)}")

  println("\nStep 3: How to drop the first two elements using the drop function")
  println(s"Drop the first and second elements in the sequence = ${donuts.drop(2)}")


  //dropWhile
  println("Step 1: How to initialize a Sequence of donuts")
  val donuts2: Seq[String] = Seq("Plain Donut 1", "Plain Donut 2", "Strawberry Donut", "Plain Donut 3", "Glazed Donut")
  println(s"Elements of donuts = $donuts2")

  println("\nStep 2: How to drop elements from the sequence using the dropWhile function")
  println(s"Drop donut elements whose name starts with letter P = ${donuts2.dropWhile(_.charAt(0) == 'P')}")
  println(s"Drop donut elements whose name starts with letter P = ${donuts2.dropWhile(_.startsWith("P"))}")

  println("\nStep 3: How to declare a predicate function to be passed-through to the dropWhile function")
  val dropElementsPredicate: String => Boolean = (donutName) => donutName.charAt(0) == 'P'
  println(s"Value function dropElementsPredicate = $dropElementsPredicate")
  println(donuts2.map(donutName => dropElementsPredicate(donutName)))

  println("\nStep 4: How to drop elements using the predicate function from Step 3")
  println(s"Drop elements using function from Step 3 = ${donuts2.dropWhile(dropElementsPredicate)}")


  //exists
  println("Step 1: How to initialize a Sequence of donuts")
  val donuts3: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts3")

  println("\nStep 2: How to check if a particular element exists in the sequence using the exists function")
  val doesPlainDonutExists: Boolean = donuts3.exists(donutName => donutName == "Plain Donut" )
  println(s"Does Plain Donut exists = $doesPlainDonutExists")

//  val plainexist: String => Boolean = (donut) => donut.exists(donut => donut == "Plain Donut")
//  println(donuts3.map(donut => plainexist(donut)))

  println("\nStep 3: How to declare a predicate value function for the exists function")
  val plainDonutPredicate: String => Boolean = (donut) => donut == "Plain Donut"
  println(s"Value function plainDonutPredicate = $plainDonutPredicate")

  println("\nStep 4: How to find element Plain Donut using the exists function and passing through the predicate function from Step 3")
  println(s"Does Plain Donut exists = ${donuts3.exists(plainDonutPredicate)}")

  println("\nStep 5: How to declare a predicate def function for the exists function")
  def plainDonutPredicateFunction(name: String):Boolean = name == "Plain Donut"

  println("\nStep 6: How to find element Plain Donut using the exists function and passing through the predicate function from Step 5")
  println(s"Does plain Donut exists = ${donuts3.exists(plainDonutPredicateFunction(_))}")

  //Filter And FilterNot
  println("Step 1: How to initialize a Sequence of donuts")
  val donuts4: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut", "Vanilla Donut")
  println(s"Elements of donuts = $donuts")

  println("\nStep 2: How to keep only Plain and Glazed Donuts using the filter method")
  val sequenceWithPlainAndGlazedDonut: Seq[String] = donuts4.filter(donutName => donutName.contains("Plain") || donutName.contains("Glazed"))
  println(s"Sequence with Plain and Glazed donuts only = $sequenceWithPlainAndGlazedDonut")

  println("\nStep 3: How to filter out element Vanilla Donut using the filterNot function")
  val sequenceWithoutVanillaDonut = donuts4.filterNot(donutName => donutName == "Vanilla Donut")
  println(s"Sequence without vanilla donut = $sequenceWithoutVanillaDonut")


  //Find Function
  println("Step 1: How to initialize a Sequence of donuts")
  val donuts6: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts6")

  println("\nStep 2: How to find a particular element in the sequence using the find function")
  val plainDonut: Option[String] = donuts6.find(donutName => donutName == "Plain Donut")
  println(s"Find Plain Donut = ${plainDonut.getOrElse("Not Found")}")

  println("\nStep 3: How to find element Vanilla Donut which does not exist in the sequence using the find function")
  val vanillaDonut: String = donuts6.find(_ == "Vanilla Donut").getOrElse("Vanilla Donut was not found!")
  println(s"Find Vanilla Donuts = $vanillaDonut")


  //FlatMap Function
  println("Step 1: How to initialize a Sequence of donuts")
  val donuts7: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts1 = $donuts7")

  println("\nStep 2: How to initialize another Sequence of donuts")
  val donuts8: Seq[String] = Seq("Vanilla Donut", "Glazed Donut")
  println(s"Elements of donuts2 = $donuts8")

  println("\nStep 3: How to create a List of donuts initialized using the two Sequences from Step 1 and Step 2")
  val listDonuts: List[Seq[String]] = List(donuts7, donuts8)
  println(s"Elements of listDonuts = $listDonuts")

  println("\nStep 4: How to return a single list of donut using the flatMap function")
  val listDonutsFromFlatMap: List[String] = listDonuts.flatMap(seq => seq)
  val listDonutsFromFlatMap1: List[String] = listDonuts.flatMap(seq => seq.filter(string => string == "Glazed Donut"))
  val listDonutsFromFlatMap2: List[Array[Byte]] = listDonuts.flatMap(seq => seq.map(seq => seq.getBytes))

  println(s"Elements of listDonutsFromFlatMap as a flatMap as a single list = $listDonutsFromFlatMap")
  println(s"Elements of listDonutsFromFlatMap as a flatMap as a single list = $listDonutsFromFlatMap1")
  println(s"Elements of listDonutsFromFlatMap as a flatMap as a single list = $listDonutsFromFlatMap2")

  println("Step 1: How to initialize a Sequence of donuts")
  val donuts9: Seq[String] = Seq("Plain", "Strawberry", "Glazed")
  println(s"Elements of donuts1 = $donuts9")

  println("\nStep 2: How to initialize another Sequence of donuts")
  val donuts10: Seq[String] = Seq("Vanilla", "Glazed")
  println(s"Elements of donuts2 = $donuts10")


  println("\nStep 3: How to create a List of donuts initialized using the two Sequences from Step 1 and Step 2")
  val listDonuts1: List[Seq[String]] = List(donuts9, donuts10)
  println(s"Elements of listDonuts = $listDonuts1")

  println("\nStep 4: How to return a single list of donut using the flatten function")
  val listDonutsFromFlatten: List[String] = listDonuts1.flatten
  println(s"Elements of listDonutsFromFlatten = $listDonutsFromFlatten")

  println("\nStep 5: How to append the word Donut to each element of listDonuts using flatten and map functions")
  val listDonutsFromFlatten2 = listDonuts1.flatten.map(string => string + " Donut") //  val listDonutsFromFlatten2 = listDonuts1.flatten.map(_ + " Donut")

  println(s"Elements of listDonutsFromFlatten2 = $listDonutsFromFlatten2")


  //Fold
  println("Step 1: How to initialize a sequence of donut prices")
  val prices: Seq[Double] = Seq(1.5, 2.0, 2.5)
  println(s"Donut prices = $prices")

  println("\nStep 2: How to sum all the donut prices using fold function")
  val sum = prices.fold(0.0)(_+ _)
  println(s"Sum = $sum")

  println("\nStep 3: How to initialize a Sequence of donuts")
  val donuts13: Seq[String] = Seq("Plain", "Strawberry", "Glazed")
  println(s"Elements of donuts1 = $donuts13")

  println("\nStep 4: How to create a String of all donuts using fold function")
  println(s"All donuts = ${donuts13.fold("")((Acc, s) => Acc + s + " Donut ")}")

  println("\nStep 5: How to declare a value function to create the donut string")
  val concatDonuts: (String, String) => String = (s1, s2) => s1 + s2 + " Donut "
  println(s"Value function concatDonuts = $concatDonuts")
  println(s"Value function concatDonuts = $concatDonuts")

  println("\nStep 6: How to create a String of all donuts using value function from Step 5 and fold function")
  println(s"All donuts = ${donuts13.fold("")(concatDonuts)}")

  //FoldLeft


  //FoldRight

  println("\nStep 4: How to create a String of all donuts using foldRight function")
  println(s"All donuts = ${donuts13.foldRight("")((a, b) => a + " Donut " + b)}")
  println(s"All donuts = ${donuts13.foldLeft("")((a, b) => a + " Donut " + b)}")
  println(s"All donuts = ${donuts13.foldRight("")((a, b) => a +  b + " Donut " )}")

  donuts13.foreach(println(_))






}
