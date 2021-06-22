package com.example.fizzbuzz

import java.util.Scanner;

fun main(){

    // Request customised rule settings from user
    val multiplicityRules : ArrayList<Int> = getUserRules();
    var multiplicityToOutputTerm : HashMap<Int, String> = HashMap<Int, String>();

    val userInput = Scanner(System.`in`);
    // Request maximum value from user
    print("Please define a maximum value \n>: ");
    var maximumValue:Int = userInput.nextInt();

    // Define the multiplicities that will trigger a word to be printed
    multiplicityToOutputTerm.put(3, "Fizz");
    multiplicityToOutputTerm.put(5, "Buzz");
    multiplicityToOutputTerm.put(7, "Bang");

    // Start the loop to test the numbers
    for (x in 1..maximumValue){
        var words : ArrayList<String> = ArrayList<String>();
        // Test each term in the ArrayList and add a word to the output if needed
        for (term in multiplicityToOutputTerm.keys){
            if (term in multiplicityRules) {
                if (x % term == 0) {
                    multiplicityToOutputTerm[term]?.let { words.add(it) };
                }
            }
        }

        // Replace all previous words with "Bong" if needed
        if (x % 11 == 0 && 11 in multiplicityRules){
            words = ArrayList<String>();
            words.add("Bong");
        }

        // Add "Fezz" if needed
        if (x % 13 == 0 && 13 in multiplicityRules) {
            val indexOfFirstBWord = words.indexOfFirst { word -> word.startsWith("B") }
            if (indexOfFirstBWord == -1) {
                words.add("Fezz")
            }
            else{
                words.add(indexOfFirstBWord, "Fezz")
            }
        }

        // Reverse Words if needed
        if (x % 17 == 0 && 17 in multiplicityRules){
            words.reverse();
        }

        // Only print from the words array if anything is there
        if (words.size > 0){
            println(words.joinToString(separator=""));
        }
        // Otherwise simply print the initial number
        else {
            print(x.toString()+"\n")
        }
    }
}

fun getUserRules() : ArrayList<Int>{
    val userInput = Scanner(System.`in`);
    println("Please type the rules you would like to take effect");
    println("Provide multiplicity rules seperated by a space (e.g. 5 3 17) ");
    print("> ");
    var userAddedRules : List<String> = userInput.nextLine().split(" ");
    var userAddedRulesToInt : ArrayList<Int> = ArrayList<Int>();
    for (rule in userAddedRules){
        userAddedRulesToInt.add(rule.toInt())
    }
    return userAddedRulesToInt;
}