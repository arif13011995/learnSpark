package com.allaboutscala.chapter.one.tutorial_06

object HelloWorldWithArguments extends App {
  println("Hello world with arguments scala application")
  println("Command Line arguments are: ")
  println(args.mkString(", "))
  var donutType = "Glazed Donut"
  println("\nStep 4: Pattern matching with two or more items on the same condition")
  val tasteLevel3 = donutType match {
    case "Glazed Donut" | "Strawberry Donut" => "Very tasty"
    case "Plain Donut" => "Tasty"
    case _ => "Tasty"
  }
  println(s"Taste level of $donutType = $tasteLevel3")
}
