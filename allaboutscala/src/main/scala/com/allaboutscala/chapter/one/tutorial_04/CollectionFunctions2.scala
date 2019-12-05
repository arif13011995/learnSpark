package com.allaboutscala.chapter.one.tutorial_04

object CollectionFunctions2 extends App{
  //Foreach Function
  println("Step 1: How to initialize a Sequence of donuts")
  val donuts: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts")

  println("\nStep 2: How to loop through all the elements in the sequence using the foreach function")
  donuts.foreach(println(_))

  println("\nStep 3: How to loop through and access all the elements in the sequence using the foreach function")
  donuts.foreach(donutName => println(s"donutName = $donutName"))

  println("\nStep 4: How to declare a value function to format a donut names into upper case format")
  val uppercase:(String) => String = (s) => {
    val upper = s.toUpperCase
    println(upper)
    upper
  }

  println(s"Value function formatting donut names to uppercase = $uppercase")

  println("\nStep 5: How to format all donuts to uppercase using value function from Step 4")
  donuts.foreach(uppercase)

  //GroupBy Function
  println("Step 1: How to initialize a Sequence of donuts")
  val donuts1: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts1")

  println("\nStep 2: How to group elements in a sequence using the groupBy function")
  val donutsGroup:Map[Char,Seq[String]] = donuts1.groupBy(string => string.charAt(0))
  println(s"Group elements in the donut sequence by the first letter of the donut name = $donutsGroup")

  println("\nStep 3: How to create a case class to represent Donut objects")
  case class Donut(name: String, price: Double)

  println("\nStep 4: How to create a Sequence of type Donut")
  val donuts2:Seq[Donut] = Seq(Donut("Plain Donut", 5.50), Donut("Plain Donut", 1.50), Donut("Strawberry Donut", 2.0), Donut("Glazed Donut", 2.5))
  println(s"Elements of donuts2 = $donuts2")

  println(s"\nStep 5: How to group case classes donut objects by the name property")
  val donutsGroup2 = donuts2.groupBy(string => string.name)
  println(s"Group element in the sequence of type Donut grouped by the donut name = $donutsGroup2")

  // Head Function
  println("Step 1: How to initialize a Sequence of donuts")
  val donuts3: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts3")


  println("\nStep 2: How to access the first element of the donut sequence")
  println(s"First element of donut sequence = ${donuts(0)}")

  println("\nStep 3: How to access the first element of the donut sequence using the head method")
  println(s"First element of donut sequence using head method = ${donuts.head}")

  println("\nStep 4: How to create an empty sequence")
  val donuts4: Seq[String] = Seq.empty[String]
  println(s"Elements of donuts2 = $donuts4")

  println("\nStep 5: How to access the first element of the donut sequence using the headOption function")
  println(s"First element of empty sequence = ${donuts4.headOption.getOrElse("No donut was found!")}")

  //IsEmpty Function
  println("Step 1: How to initialize a Sequence of donuts")
  val donuts5: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts5")

  println("\nStep 2: How to find out if a sequence is empty using isEmpty function")
  println(s"Is donuts sequence empty = ${donuts.isEmpty}")

  //Intersect Function
  println("Step 1: How to initialize a Set of donuts")
  val donuts6: Set[String] = Set("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts1 = $donuts6")

  println("\nStep 2: How to initialize another Set of donuts")
  val donuts7: Set[String] = Set("Plain Donut", "Chocolate Donut", "Vanilla Donut")
  println(s"Elements of donuts2 = $donuts7")

  println("\nStep 3: How to find the common elements between two Sets using intersect function")
  println(s"Common elements between donuts1 and donuts2 = ${donuts1 intersect donuts2}")
  println(s"Common elements between donuts2 and donuts1 = ${donuts2 intersect donuts1}")

  println("\nStep 4: How to find the common elements between two Sets using & function")
//  println(s"Common elements between donuts1 and donuts2 = ${donuts1 & donuts2}")

  //Last Function
  //get last collection
  println("\nStep 2: How to access the last element of the donut sequence by index")
  println(s"Last element of donut sequence = ${donuts(donuts.size - 1)}")

  println("\nStep 3: How to access the last element of the donut sequence by using the last function")
  println(s"Last element of donut sequence = ${donuts.last}")

  //Using lastOption.getOrElse("") to get empty collection


  //Map Function
  println("Step 1: How to initialize a Sequence of donuts")
  val donuts8: Seq[String] = Seq("Plain", "Strawberry", "Glazed")
  println(s"Elements of donuts1 = $donuts8")

  println("\nStep 2: How to append the word Donut to each element using the map function")
  val donuts9: Seq[String] = donuts1.map(_ + " Donut")
  println(s"Elements of donuts2 = $donuts9")

  println("\nStep 3: How to create a donut sequence with one None element")
  val donuts10: Seq[AnyRef] = Seq("Plain", "Strawberry", None)
  donuts10.foreach(println(_))

  println("\nStep 4: How to filter out the None element using map function")
  val donuts11:Seq[String] = donuts10.map{
    case donut: String => donut + " Donut"
    case None => "Unknown Donut"
  }
  println(s"Elements of donuts4 = $donuts11")

  println("\nStep 5: How to define couple of functions which returns an Option of type String")
  def favoriteDonut: Option[String] = Some("Glazed Donut")

  def leastFavoriteDonut: Option[String] = None

  println("\nStep 6: How to use map function to filter out None values")
  favoriteDonut.map(donut => println(s"Favorite donut = $donut"))
  leastFavoriteDonut.map(donut=> println(s"Least favorite donut = $donut"))

  //Max Function -> String : return the longest string


  //maxBy Function
  //take function as parameter
  println("\nStep 2: How to create a Sequence of type Donut")
  val donuts13: Seq[Donut] = Seq(Donut("Plain Donut", 1.5), Donut("Strawberry Donut", 2.0), Donut("Glazed Donut", 2.5))
  println(s"Elements of donuts = $donuts")

  println("\nStep 4: How to declare a value predicate function for maxBy function")
  val donutsMaxBy: (Donut) => Double = (donut) => donut.price
  println(s"Value function donutMaxBy = $donutsMaxBy")

  println("\nStep 5: How to find the maximum element using maxBy function and pass through the predicate function from Step 4")
  println(s"Maximum element in sequence using function from Step 3 = ${donuts13.maxBy(donutsMaxBy)}")

  //Min
  //MinBy

  //MkString Function

  //NonEmpty Function
  //The nonEmpty method will test whether a given collection is not empty and will return either true or false

  //Par Function
  //The par method on collection provides a very easy high level API to allow computation to run in parallel to take advantage of multi-core processing. When you call the par method on a collection, it will copy all the elements into an equivalent Scala Parallel Collection

  //Partition Function
  println("Step 1: How to initialize a sequence which contains donut names and prices")
  val donutNamesAndPrices: Seq[Any] = Seq("Plain Donut", 1.5, "Strawberry Donut", 2.0, "Glazed Donut", 2.5)
  println(s"Elements of donutNamesAndPrices = $donutNamesAndPrices")

  println("\nStep 2: How to split the sequence by the element types using partition function")
  val namesAndPrices: (Seq[Any], Seq[Any]) = donutNamesAndPrices.partition{
    case donut: String => true
    case price: Double => false
  }
  println(s"Elements of namesAndPrices = $namesAndPrices")

  println("\nStep 3: How to access the donut String sequence from Step 2")
  println(s"Donut names = ${namesAndPrices._1}")

  println("\nStep 4: How to access the donut prices sequence from Step 2")
  println(s"Donut prices = ${namesAndPrices._2}")

  println("\nStep 5: How to extract the pair returned by partition function")
  val (donutNames, donutPrices) = donutNamesAndPrices.partition{
    case name: String => true
    case _ => false
  }
  println(s"donutNames = $donutNames")
  println(s"donutPrices = $donutPrices")

  // Reduce Function
  //The reduce method takes an associative binary operator function as parameter and will use it to collapse elements from the collection. Unlike the fold method, reduce does not allow you to also specify an initial value.
  println("Step 1: How to initialize a sequence of donut prices")
  val donutPrices1: Seq[Double] = Seq(1.5, 2.0, 2.5)
  println(s"Elements of donutPrices = $donutPrices1")

  println("\nStep 2: How to find the sum of the elements using reduce function")
  val sum: Double = donutPrices1.reduce(_ + _)
  println(s"Sum of elements from donutPrices = $sum")

  println("\nStep 3: How to find the sum of elements using reduce function explicitly")
  val sum1: Double = donutPrices1.reduce((a, b) => a + b)
  println(s"Sum of elements from donutPrices by calling reduce function explicitly= $sum1")

  println("\nStep 4: How to find the cheapest donut using reduce function")
  println(s"Cheapest donut price = ${donutPrices1.reduce(_ min _)}")

  println("\nStep 5: How to find the most expensive donut using reduce function")
  println(s"Most expensive donut price = ${donutPrices1.reduce(_ max _)}")

  println("\nStep 6: How to initialize a Sequence of donuts")
  val donuts15: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts15")

  println("\nStep 7: How to concatenate the elements from the sequence using reduce function")
  println(s"Elements of donuts sequence concatenated = ${donuts15.reduce((left, right) => left + ", " + right)}")

  println("\nStep 8: How to declare a value function to concatenate donut names")
  val concatDonutNames: (String, String) => String = (left, right) => {
    left + ", " + right
  }
  println(s"Value function concatDonutNames = $concatDonutNames")

  println("\nStep 9: How to pass a function to reduce function")
 // println(s"Elements of donuts sequence concatenated by passing function to the reduce function = ${donuts reduce concatDonutNames}")
  println("\nStep 10: How to use option reduce to avoid exception if the collection is empty")
  println(s"Using reduce option will NOT throw any exception = ${Seq.empty[String].reduceOption(_ + ", " + _)}")

  //Reverse Function

  //ReverseIterator Function


  //Scan
  //Scan method iterations
  //0 + 1             =  1
  //1 + 2             =  3
  //1 + 2 + 3         =  6
  //1 + 2 + 3 + 4     = 10
  //1 + 2 + 3 + 4 + 5 = 15
  //val runningTotal2: Seq[Int] = numbers.scan(0)((a, b) => a + b)  with initial value like fold

  //scanRight method iterations
  //5 + 4 + 3 + 2 + 1 = 15
  //5 + 4 + 3 + 2     = 14
  //5 + 4 + 3         = 12
  //5 + 4             = 9
  //5 + 0             = 5
  //0                 = 0

  //Size Function
  //The size method calculates the number of elements in a collection and return its size.
  println(s"Number of times element Plain Donut appear in donuts sequence = ${donuts.count(_ == "Plain Donut")}")


  //Slice Function
  //The slice method takes a start and end index and will use them to return a new collection with elements that are within the start and end index range.
  //def slice(from: Int, until: Int): Repr

  //SortBy Function
  println("\nStep 1: How to create a case class to represent Donut objects")
  case class Donut2(name: String, price: Double)
  println("\nStep 2: How to create a Sequence of type Donut")
  val donuts20: Seq[Donut2] = Seq(Donut2("Plain Donut", 1.5), Donut2("Strawberry Donut", 2.0), Donut2("Glazed Donut", 2.5))
  println(s"Elements of donuts = $donuts20")
  println("\nStep 3: How to sort a sequence of case class objects using the sortBy function")
  println(s"Sort a sequence of case class objects of type Donut, sorted by price = ${donuts20.sortBy(donut => donut.price)}")

  //sorted
  println("Step 1: How to initialize donut prices")
  val prices: Seq[Double] = Seq(1.50, 2.0, 2.50)
  println(s"Elements of prices = $prices")
  ("\nStep 2: How to sort a sequence of type Double using the sorted function")
  println(s"Sort a sequence of type Double by their natural ordering = ${prices.sorted}")


  //SortWith

  //Tail Function
  //The tail method returns a collection consisting of all elements except the first one.


  //take Function
  //The take method takes an integer N as parameter and will use it to return a new collection consisting of the first N elements.


  //takeRight Function
  //The takeRight method takes an integer N as parameter and will use it to return a new collection consisting of the last N elements.


  //The takeWhile method takes a predicate function and will use it to return a new collection consisting of elements which match the predicate function.
  //def takeWhile(p: (A) ⇒ Boolean): Repr
  println("Step 1: How to initialize a List of donuts")
  val donuts18: Seq[String] = List("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts")

  println("\nStep 2: How to take elements from the List using the takeWhile function")
  println(s"Take donut elements which start with letter P = ${donuts18.takeWhile(_.charAt(0) == 'P')}")


  // Transpose Function
  println("Step 1: How to initialize a Sequence of donuts")
  val donuts19: Seq[String] = Seq("Plain Donut", "Strawberry Donut", "Glazed Donut")
  println(s"Elements of donuts = $donuts19")

  println("\nStep 2: How to initialize donut prices")
  val prices19: Seq[Double] = Seq(1.50, 2.0, 2.50)
  println(s"Elements of prices = $prices19")

  println("\nStep 3: How to create a List of donuts and prices")
  val donutList19 = List(donuts, prices)
  println(s"Sequence of donuts and prices = $donutList19")


  println("\nStep 4: How to pair each element from both donuts and prices Sequences using the transpose function")
  println(s"Transposed list of donuts paired with their individual prices = ${donutList19.transpose}")

  //Union Function


  //Unzip Function

  //Unzip3 Function

  //Zip

  //ZipWithIndex
  println(Some(5).contains(5))






}
