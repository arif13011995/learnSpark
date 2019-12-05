package com.allaboutscala.chapter.one.tutorial_04

object MutableCollection extends App {
  //Array

  println("Step 1: How to initialize a String Array with 3 elements")
  val array1: Array[String] = Array("Plain Donut","Strawberry Donut","Chocolate Donut")
  println(s"Elements of array1 = ${array1.mkString(", ")}")

  println("\nStep 2: How to access elements at specific index in an Array")
  println(s"Element at index 0 = ${array1(0)}")
  println(s"Element at index 1 = ${array1(1)}")
  println(s"Element at index 2 = ${array1(2)}")

  println("\nStep 4: How to create a 2D Array (2 dimension array)")
  val rows = 2
  val columns = 2
  val array3: Array[Array[String]] = Array.ofDim[String](rows,columns)
  array3(0)(0) = "Plain"
  array3(0)(1) = "Donut"
  array3(1)(0) = "Strawberry"
  array3(1)(1) = "Donut"
  println(s"Elements of 2 dimensional array = ${array3.deep.toList}")

  println("\nStep 6: How to create an Array using tabulate function")
  val array5: Array[Int] = Array.tabulate(5)(_ + 1)
  println(s"Array of 5 columns = ${array5.toList}")


  println("\nStep 7: How to create dimensional Arrays using tabulate function")
  val row1 = 1
  val column3 = 3
  val arrayOfOneRowAndThreeColumns = Array.tabulate(row1, column3)( (row, column) => row + column )
  println(s"Array with 1 row and 3 columns = ${arrayOfOneRowAndThreeColumns.deep.toString}")

  val row2 = 2
  val arrayOfTowRowsAndThreeColumns = Array.tabulate(row2, column3)( (row, column) => row + column )
  println(s"Array with 2 rows and 3 columns = ${arrayOfTowRowsAndThreeColumns.deep.toString}")



  println("\nStep 8: How to create Array using Range")
  val rangeArray: Array[Int] = (1 to 10).toArray[Int]
  println(s"Array using Range from 1 to 10 = ${rangeArray.mkString(", ")}")


  println("\nStep 9: How to copy an Array using Array.copy")
  val copyOfRangeArray: Array[Int] = new Array(rangeArray.size)
  Array.copy(rangeArray, 0, copyOfRangeArray, 0, rangeArray.size)
  println(s"copy of range array with elements from rangeArray = ${copyOfRangeArray.mkString(", ")}")


  println("\nStep 10: How to clone an Array")
  val clonedRangeArray = rangeArray.clone
  clonedRangeArray(0) = 10 // update index 0 to value 10
  println(s"clonedRangeArray = ${clonedRangeArray.mkString(", ")}")
  println(s"original range array still unchanged = ${rangeArray.mkString(", ")}")

  println("\nStep 11: How to iterate over an Array using for comprehension")
  for(d <- array1){
    println(s"d = $d")
  }

  println("\nStep 12: How to merge two Arrays using Array.concat")
  val moreDonutsArray: Array[String] = Array("Vanilla Donut","Glazed Donut")
  val mergedDonutArray: Array[String] = Array.concat(array1, moreDonutsArray)
  println(s"Merged Array of donuts = ${mergedDonutArray.mkString(", ")}")


  println("\nStep 13: How to check if two Arrays are equal")
  val arrayToCompare = Array[String]("Plain Donut","Strawberry Donut","Chocolate Donut")

  println(s"using == ${array1 == moreDonutsArray}") // prints false

  println(s"using == ${array1 == arrayToCompare}") // ALSO prints false ??? what ... be careful

  println(s"using sameElement function = ${array1 sameElements arrayToCompare}") // NOW this works and returns true!

  println("\nStep 14: How to check if two Arrays are equal using deep function and == ")
  println(s"using deep function = ${array1.deep == arrayToCompare.deep}")

  //ArrayBuffer
  //As per the Scala Documentation, an ArrayBuffer is a mutable data structure which allows you to access and modify elements at specific index.
  import scala.collection.mutable.ArrayBuffer
  println("Step 1: How to initialize an ArrayBuffer with 3 elements")
  val arrayBuffer1: ArrayBuffer[String] = ArrayBuffer("Plain Donut","Strawberry Donut","Chocolate Donut")
  println(s"Elements of arrayBuffer1 = $arrayBuffer1")

  println("\nStep 2: How to access elements of an ArrayBuffer at specific index")
  println(s"Element at index 0 = ${arrayBuffer1(0)}")
  println(s"Element at index 1 = ${arrayBuffer1(1)}")
  println(s"Element at index 2 = ${arrayBuffer1(2)}")


  println("\nStep 3: How to add elements to an ArrayBuffer using +=")
  arrayBuffer1 += "Vanilla Donut"
  println(s"Elements of arrayBuffer1 = $arrayBuffer1")
  // NOTE: arrayBuffer1 is mutable and hence we were able to add a new element to it

  println("\nStep 4: How to add elements from a List to an ArrayBuffer using ++=")
  arrayBuffer1 ++= List[String]("Glazed Donut", "Krispy creme")
  println(s"Elements of arrayBuffer1 = $arrayBuffer1")

  println("\nStep 5: How to remove elements from an ArrayBuffer")
  arrayBuffer1 -= "Plain Donut"
  println(s"Elements of arrayBuffer1 = $arrayBuffer1")

  println("\nStep 6: How to remove elements of a List from ArrayBuffer using --=")
  arrayBuffer1 --= List[String]("Glazed Donut", "Krispy creme")
  println(s"Elements of arrayBuffer1 = $arrayBuffer1")

  println("\nStep 7: How to initialize an empty ArrayBuffer")
  val emptyArrayBuffer: ArrayBuffer[String] = ArrayBuffer.empty[String]
  println(s"Empty array buffer = $emptyArrayBuffer")

  //ArrayStack
  import scala.collection.mutable.ArrayStack
  println("Step 1: How to initialize ArrayStack with 3 elements")
  val arrayStack1: ArrayStack[String] = ArrayStack("Plain Donut", "Strawberry Donut", "Chocolate Donut")
  println(s"Elements of arrayStack1 = $arrayStack1")

  println("\nStep 2: How to check elements at specific index of an ArrayStack")
  println(s"Element at index 0 = ${arrayStack1(0)}")
  println(s"Element at index 1 = ${arrayStack1(1)}")
  println(s"Element at index 2 = ${arrayStack1(2)}")

  println("\nStep 3: How to add elements to an ArrayStack using +=")
  arrayStack1 += "Vanilla Donut"
  println(s"Elements of arrayStack1 = $arrayStack1")

  println("\nStep 4: How to add elements from a List to an ArrayStack using ++=")
  arrayStack1 ++= List[String]("Glazed Donut", "Krispy creme")
  println(s"Elements of arrayStack1 = $arrayStack1")

  println("\nStep 5: How to take an element from an ArrayStack using pop function")
  println(s"Pop element from stack = ${arrayStack1.pop}")
  println(s"Elements of stack1 = $arrayStack1")

  println("\nStep 6: How to push one element at the top of the ArrayStack using push function")
  arrayStack1.push("Krispy Creme")
  println(s"Elements after push = $arrayStack1")

  println("\nStep 7: How to initialize an empty ArrayStack")
  val emptyArrayStack: ArrayStack[Nothing] = ArrayStack.empty
  println(s"Empty Stack = $emptyArrayStack")

  //ListBuffer
  //As per the Scala Documentation, a ListBuffer is resizable similar to an ArrayBuffer, except that it uses a Linked List as its internal data structure.
  import scala.collection.mutable.ListBuffer
  println("Step 1: How to initialize a ListBuffer with 3 elements")
  val listBuffer1: ListBuffer[String] = ListBuffer("Plain Donut","Strawberry Donut","Chocolate Donut")
  println(s"Elements of listBuffer1 = $listBuffer1")

  println("\nStep 2: How to access elements at specific index in a ListBuffer")
  println(s"Element at index 0 = ${listBuffer1(0)}")
  println(s"Element at index 1 = ${listBuffer1(1)}")
  println(s"Element at index 2 = ${listBuffer1(2)}")

  println("\nStep 3: How to add elements to a ListBuffer using +=")
  listBuffer1 += "Vanilla Donut"
  println(s"Elements of listBuffer1 = $listBuffer1")

  println("\nStep 4: How to add elements from a List to a ListBuffer using ++=")
  listBuffer1 ++= List[String]("Glazed Donut", "Krispy creme")
  println(s"Elements of listBuffer1 = $listBuffer1")

  println("\nStep 5: How to remove elements from a ListBuffer")
  listBuffer1 -= "Plain Donut"
  println(s"Elements of listBuffer1 = $listBuffer1")

  println("\nStep 6: How to remove elements from a List to a ListBuffer using --=")
  listBuffer1 --= List[String]("Glazed Donut", "Krispy creme")
  println(s"Elements of listBuffer1 = $listBuffer1")

  println("\nStep 7: How to initialize an empty ListBuffer")
  val emptyListBuffer: ListBuffer[String] = ListBuffer.empty[String]
  println(s"Empty list buffer = $emptyListBuffer")


  //Mutable Map
  import scala.collection.mutable.Map
  println("\nStep 1: How to initialize a Map with 3 elements")
  val map1: Map[String, String] = Map(("PD","Plain Donut"),("SD","Strawberry Donut"),("CD","Chocolate Donut"))
  println(s"Elements of map1 = $map1")

  println("\nStep 2: How to initialize a Map using key -> value notation")
  val map2: Map[String, String] = Map("VD"-> "Vanilla Donut", "GD" -> "Glazed Donut")
  println(s"Elements of map2 = $map2")

  println("\nStep 3: How to access elements of Map by specific key")
  println(s"Element by key VD = ${map2("VD")}")
  println(s"Element by key GD = ${map2("GD")}")

  println("\nStep 4: How to add elements to Map using +=")
  map1 += ("KD" -> "Krispy Kreme Donut")
  println(s"Element in map1 = $map1")

  println("\nStep 5: How to add elements from a Map to an existing Map using ++=")
  map1 ++= map2
  println(s"Elements in map1 = $map1")

  println("\nStep 6: How to remove key and its value from Map using -=")
  map1 -= "CD"
  println(s"Map without the key CD and its value = $map1")

  println("\nStep 7: How to initialize an empty Map")
  val emptyMap: Map[String,String] = Map.empty[String,String]
  println(s"Empty Map = $emptyMap")

  //HashMap?
  //
  //As per the Scala Documentation, a HashMap is a collection of key and value pairs which are stored internally using a Hash Table data structure.
  import scala.collection.mutable.HashMap
  println("\nStep 1: How to initialize a HashMap with 3 elements")
  val hashMap1: HashMap[String, String] = HashMap(("PD","Plain Donut"),("SD","Strawberry Donut"),("CD","Chocolate Donut"))
  println(s"Elements of hashMap1 = $hashMap1")

  println("\nStep 2: How to initialize HashMap using key -> value notation")
  val hashMap2: HashMap[String, String] = HashMap("VD"-> "Vanilla Donut", "GD" -> "Glazed Donut")
  println(s"Elements of hashMap2 = $hashMap2")

  println("\nStep 3: How to access elements of HashMap by specific key")
  println(s"Element by key VD = ${hashMap2("VD")}")
  println(s"Element by key GD = ${hashMap2("GD")}")

  println("\nStep 4: How to add elements to HashMap using +=")
  hashMap1 += ("KD" -> "Krispy Kreme Donut")
  println(s"Element in hashMap1 = $hashMap1")

  println("\nStep 5: How to add elements from a HashMap to an existing HashMap using ++=")
  hashMap1 ++= hashMap2
  println(s"Elements in hashMap1 = $hashMap1")


  println("\nStep 6: How to remove key and its value from HashMap using -=")
  hashMap1 -= "CD"
  println(s"HashMap without the key CD and its value = $hashMap1")


//  println("\nStep 7: How to initialize an empty HashMap")
//  val emptyMap: HashMap[String,String] = HashMap.empty[String,String]
//  println(s"Empty HashMap = $emptyMap")

  //ListMap?
  //
  //As per the Scala Documentation, a ListMap is a collection of key and value pairs where the keys are backed by a List data structure.
  import scala.collection.mutable.ListMap
  println("\nStep 1: How to initialize a ListMap with 3 elements")
  val listMap1: ListMap[String, String] = ListMap("PD" -> "Plain Donut", "SD" ->"Strawberry Donut", "CD" -> "Chocolate Donut")
  println(s"Elements of listMap1 = $listMap1")


  println("\nStep 2: How to initialize ListMap using key -> value notation")
  val listMap2: ListMap[String, String] = ListMap("VD"-> "Vanilla Donut", "GD" -> "Glazed Donut")
  println(s"Elements of listMap1 = $listMap2")

  println("\nStep 3: How to access elements of ListMap by specific key")
  println(s"Element by key VD = ${listMap2("VD")}")
  println(s"Element by key GD = ${listMap2("GD")}")

  println("\nStep 4: How to add elements to ListMap using +")
  listMap1 += ("KD" -> "Krispy Kreme Donut")
  println(s"Element of listMap1 = ${listMap1}")

  println("\nStep 5: How to add elements from a ListMap to an existing ListMap using ++=")
  listMap1 ++= listMap2
  println(s"Element of listMap1 = ${listMap1}")

  println("\nStep 6: How to remove key and its value from ListMap using -=")
  listMap1 -= ("CD")
  println(s"ListMap without the key CD and its value = $listMap1")

  println("\nStep 7: How to initialize an empty ListMap")
  val emptyListMap: ListMap[String, String] = ListMap.empty[String,String]
  println(s"Empty ListMap of type String = $emptyListMap")

  //LinkedHashMap?
  //
  //As per the Scala Documentation, a LinkedHashMap is a collection of key and value pairs which are stored internally using Hash Table data structure. But iterating through the elements is done in order.
  import scala.collection.mutable.LinkedHashMap
  println("\nStep 1: How to initialize a LinkedHashMap with 3 elements")
  val linkedHashMap1: LinkedHashMap[String, String] = LinkedHashMap("PD" -> "Plain Donut", "SD" ->"Strawberry Donut", "CD" -> "Chocolate Donut")
  println(s"Elements of linkedHashMap1 = $linkedHashMap1")

  println("\nStep 2: How to initialize a LinkedHashMap using key -> value notation")
  val linkedHashMap2: LinkedHashMap[String, String] = LinkedHashMap("VD"-> "Vanilla Donut", "GD" -> "Glazed Donut")
  println(s"LinkedHashMap1 = $linkedHashMap2")

  println("\nStep 3: How to access elements of LinkedHashMap by specific key")
  println(s"Element by key VD = ${linkedHashMap2("VD")}")
  println(s"Element by key GD = ${linkedHashMap2("GD")}")

  println("\nStep 4: How to add elements to LinkedHashMap using +=")
  linkedHashMap1 += ("KD" -> "Krispy Kreme Donut")
  println(s"Elements of linkedHashMap1 = ${linkedHashMap1}")

  println("\nStep 5: How to add elements from a LinkedHashMap to an existing LinkedHashMap using ++=")
  linkedHashMap1 ++= linkedHashMap2
  println(s"Elements of linkedHashMap1 = ${linkedHashMap1}")

  println("\nStep 6: How to remove key and its value from LinkedHashMap using -=")
  linkedHashMap1 -= ("CD")
  println(s"LinkedHashMap without the key CD and its value = $linkedHashMap1")

  println("\nStep 7: How to initialize an empty LinkedHashMap")
  val emptyLinkedHashMap: LinkedHashMap[String, String] = LinkedHashMap.empty[String,String]
  println(s"Empty LinkedHashMap of type String = $emptyLinkedHashMap")



  //Queue
  import scala.collection.mutable.Queue
  println("\nStep 1: How to initialize a Queue with 3 elements")
  val queue1: Queue[String] = Queue("Plain Donut", "Strawberry Donut", "Chocolate Donut")
  println(s"Elements of queue1 = $queue1")

  println("\nStep 2: How to access elements of Queue at specific index")
  println(s"Element at index 0 = ${queue1(0)}")
  println(s"Element at index 0 = ${queue1(1)}")
  println(s"Element at index 0 = ${queue1(2)}")

  println("\nStep 3: How to add elements to Queue using +=")
  queue1 += "Glazed Donut"
  println(s"Elements of queue1 = $queue1")

  println("\nStep 4: How to add elements to Queue using enqueue")
  queue1.enqueue("Vanilla Donut")
  println(s"Enqueue element Vanilla Donut onto queue1 = $queue1")

  println("\nStep 5: How to take the first element or head from the Queue")
  val dequeuedElement: String = queue1.dequeue
  println(s"Dequeued element = $dequeuedElement")
  println(s"Elements of queue1 after dequeue = $queue1")

  println("\nStep 6: How to initialize an empty Queue")
  val emptyQueue: Queue[String] = Queue.empty[String]
  println(s"Empty Queue = $emptyQueue")


  //Set
  // Set?
  //
  //As per Wikipedia, a Set is a data structure which allows you to store elements which are not repeatable. A Set also does not guarantee the ordering of elements.

  import scala.collection.mutable.Set
  println("\nStep 1: How to initialize a Set with 3 elements")
  val set1: Set[String] = Set("Plain Donut","Strawberry Donut","Chocolate Donut")
  println(s"Elements of set1 = $set1")

  println("\nStep 2: How to check specific elements in Set")
  println(s"Element Plain Donut = ${set1("Plain Donut")}")
  println(s"Element Strawberry Donut = ${set1("Strawberry Donut")}")
  println(s"Element Chocolate Donut = ${set1("Chocolate Donut")}")

  println("\nStep 3: How to add elements to Set using +=")
  set1 += "Vanilla Donut"
  println(s"Elements of set1 after adding elements Vanilla Donut = $set1")

  println("\nStep 4: How to add all elements from another Set using ++=")
  set1 ++= Set[String]("Vanilla Donut", "Glazed Donut")
  println(s"Elements of set1 after adding second set = $set1")

  println("\nStep 5: How to remove element from Set using -=")
  set1 -= "Plain Donut"
  println(s"Elements of set1 without Plain Donut element = $set1")

  println("\nStep 6: How to find the intersection between two Sets using &")
  val set2: Set[String] = Set("Vanilla Donut", "Glazed Donut", "Plain Donut")
  println(s"Intersection of set1 and set5 = ${set1 & set2}")

  println("\nStep 7: How to find the difference between two Sets using &~")
  println(s"Difference of set1 and set2 = ${set1 &~ set2}")

  println("\nStep 8: How to initialize an empty Set")
  val emptySet: Set[String] = Set.empty[String]
  println(s"Empty Set = $emptySet")

  //HashSet

  //SortedSet

  //TreeSet

  //LinkedHashSet

  //BitSet






}
