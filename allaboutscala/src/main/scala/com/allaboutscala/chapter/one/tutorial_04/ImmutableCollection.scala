package com.allaboutscala.chapter.one.tutorial_04

import scala.collection.immutable.ListSet
import scala.collection.immutable.ListMap

object ImmutableCollection extends App {
  //Scala Tutorial - Learn How To Use Scala's Immutable List
  //1. How to initialize an immutable List with 3 elements
  println("Step 1: How to initialize an immutable List with 3 elements")
  val list1: List[String] = List("Plain Donut", "Strawberry Donut", "Chocolate Donut")
  println(s"Element of list1 = $list1")

  //2. How to access elements of immutable List at specific index
  println("\nStep 2: How to access elements of immutable List at specific index")
  println(s"Element at index 0 = ${list1(0)}")
  println(s"Element at index 1 = ${list1(1)}")
  println(s"Element at index 2 = ${list1(2)}")

  //3. How to append elements at the end of immutable List using :+
  println("\nStep 3: How to append elements at the end of immutable List using :+")
  val list2: List[String] = list1 :+ "Vanilla Donut"
  println(s"Append elements at the end using :+ = $list2")

  //4. How to prepend elements at the front of immutable List using +:
  println("\nStep 4: How to prepend elements at the front of immutable List using +:")
  val list3: List[String] = "Vanilla Donut" +: list1
  println(s"Prepend elements at the front using +: = $list3")

  //5. How to add two immutable lists together using ::
  println("\nStep 5: How to add two immutable lists together using ::")
  val list4: List[Any] = list1 :: list2
  println(s"Add two lists together using :: = $list4")
  //Using :: returns a new List(List(...), elements from the second list)

  //6. How to add two immutable Lists together using :::
  println("\nStep 6: How to add two immutable Lists together using :::")
  val list5: List[String] = list1 ::: list2
  println(s"Add two lists together using ::: = $list5")

  //7. How to initialize an empty immutable List

  println("\nStep 7: How to initialize an empty immutable List")
  val emptyList: List[String] = List.empty[String]
  println(s"Empty list = $emptyList")


  //Scala Tutorial - Learn How To Use Scala's Immutable ListSet
  //1. How to initialize an immutable ListSet with 3 elements
  println("Step 1: How to initialize an immutable ListSet with 3 elements")
  val listSet1: ListSet[String] = ListSet("Plain Donut","Strawberry Donut","Chocolate Donut")
  println(s"Elements of listSet1 = $listSet1")

  //2. How to check elements of immutable ListSet
  println("\nStep 2: How to check elements of immutable ListSet")
  println(s"Element Plain Donut = ${listSet1("Plain Donut")}")
  println(s"Element Strawberry Donut = ${listSet1("Strawberry Donut")}")
  println(s"Element Chocolate Donut = ${listSet1("Chocolate Donut")}")
  println(s"Element Chocolate Donut = ${listSet1("1")}")

  //3. How to add elements of immutable ListSet using +
  println("\nStep 3: How to add elements of immutable ListSet using +")
  val listSet2: ListSet[String] = listSet1 + "Vanilla Donut"
  println(s"Adding element Vanilla to ListSet using + = $listSet2")

  //4. How to add two ListSet together using ++
  println("\nStep 4: How to add two ListSet together using ++")
  val listSet3: ListSet[String] = listSet1 ++ ListSet("Glazed Donut")
  println(s"Add two lists together using ++ = $listSet3")

  //5. How to remove element from the ListSet using -
  println("\nStep 5: How to remove element from the ListSet using -")
  val listSet4: ListSet[String] = listSet1 - ("Plain Donut")
  println(s"ListSet without the element Plain Donut = $listSet4")

  //6. How to initialize an empty ListSet
  println("\nStep 6: How to initialize an empty ListSet")
  val emptyListSet: ListSet[String] = ListSet.empty[String]
  println(s"Empty ListSet of type String = $emptyListSet")

  //Scala Tutorial - Learn How To Use Scala's Immutable ListMap
  //1. How to initialize a ListMap with 3 elements using key -> value notation
  println("Step 1: How to initialize a ListMap with 3 elements using key -> value notation")
  val listMap1: ListMap[String, String] = ListMap("PD" -> "Plain Donut", "SD" ->"Strawberry Donut", "CD" -> "Chocolate Donut")
  println(s"Elements of listMap1 = $listMap1")

  //2. How to access elements by specific key in the ListMap
  println("\nStep 2: How to access elements by specific key in the ListMap")
  println(s"Element by key PD = ${listMap1("PD")}")
  println(s"Element by key SD = ${listMap1("SD")}")

  //3. How to add elements to ListMap using +

  println("\nStep 3: How to add elements to ListMap using +")
  val listMap2: ListMap[String, String] = listMap1 + ("KD" -> "Krispy Kreme Donut")
  println(s"Elements of listMap2 = $listMap2")

  //4. How to add two ListMaps together using ++
  println("\nStep 4: How to add two ListMaps together using ++")
  val listMap3: ListMap[String, String] = listMap1 ++ listMap2
  println(s"Elements of listMap3 = $listMap3")

  //5. How to remove key and value from ListMap using -
  println("\nStep 5: How to remove key and value from ListMap using -")
  val listMap4: ListMap[String, String] = listMap1 - ("CD")
  println(s"ListMap without the key CD and its value = $listMap4")

  //6. How to initialize an empty ListMap
  println("\nStep 6: How to initialize an empty ListMap")
  val emptyListMap: ListMap[String, String] = ListMap.empty[String,String]
  println(s"Empty ListMap with key type String and value also of type String= $emptyListMap")



}
