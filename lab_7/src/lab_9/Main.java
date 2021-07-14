package lab_9;

import java.util.Arrays;

public class Main {
	public static void main(String[] args){
        System.out.println("TESTING WORDS");
        Words wordList = new Words("this,: is !a test words");
        Words wordList2 = new Words("this is :.:a :test words");
        System.out.println(wordList);
        System.out.println("min length words: " + Arrays.toString(wordList.minLenWords()));
        System.out.println("max length words: " + Arrays.toString(wordList.maxLenWords()));
        System.out.println(wordList + "   ==   " + wordList2 + "? " + wordList.equals(wordList2));
        System.out.println();
        System.out.println(wordList + "   +   " + wordList2 + ": ");
        wordList.append(wordList2);
        System.out.println("\t" + wordList);
        System.out.println();
        System.out.println(wordList + "   +   woooord: ");
        wordList.append("woooord");
        System.out.println("\t" + wordList);
        System.out.println();

        System.out.println("TESTING UNIQUE WORDS");
        UniqueWords unique1 = new UniqueWords("these ,are , some :: . random random some words these");
        System.out.println("new UniqueWords(\"these ,are , some :: . random random some words these\"):" );
        System.out.println("\t" + unique1);
        System.out.println();
        System.out.println(unique1 + "   +   \"blah :::::.....blah something\"");
        unique1.append("blah :::::.....blah something");
        System.out.println("\t" + unique1);
        System.out.println();
        System.out.println(unique1 + "   +   " + wordList + ": ");
        unique1.append(wordList);
        System.out.println("\t" + unique1);
        System.out.println();
        System.out.println("Common words of " + unique1 + " and " + wordList + ": ");
        UniqueWords unique2 = unique1.common(wordList.arg);
        System.out.println("\t" + unique2);
        System.out.println();


        Words word3 = new Words("word1 word2 word3");
        Words word4 = new Words("word1 word2 word3");
        UniqueWords uniqueWord3 = new UniqueWords("word1 word2 word3");
        UniqueWords uniqueWord4 = new UniqueWords("word1 word2 word3");

        System.out.println(word3 + "   ==   " + word4 + "? " + word3.equals(word4));
        System.out.println(word3 + "   ==   " + uniqueWord3 + "? (different classes) " + word3.equals(uniqueWord3));
        System.out.println(uniqueWord3 + "   ==   " + word3 + "? (different classes) " + uniqueWord3.equals(word3));
        System.out.println(uniqueWord3 + "   ==   " + uniqueWord4 + "? " + uniqueWord3.equals(uniqueWord4));
        System.out.println();

    }

}


