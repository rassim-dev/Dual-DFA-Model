/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFAproject;


import java.io.*;
import java.util.*;

public class dfaTest {
   public static void main(String[] args) throws FileNotFoundException {
         
        dfaClass dfa1 = new dfaClass("src/DFAproject/DFA1.txt");
        dfa1.print();
     //addig the input strings we want to test the dfa that is in the txt file using dfaClass reading it line by line
        ArrayList<String> dfaArray1 = new ArrayList<>();
        dfaArray1.add("kkingkk");
        dfaArray1.add("helping");
        dfaArray1.add("shipping");
        dfaArray1.add("ing");
        dfaArray1.add("winging");
        dfaArray1.add("opingppingppp");
        dfaArray1.add("inting");
        
        System.out.println(); System.out.println();
        
         //take the letters from the txt file and make them lower case so it isn't conflicting
        for(String answer: dfaArray1){
            System.out.println("input: "+ answer);
            System.out.println(Arrays.toString(dfa1.process(answer.toLowerCase())));
            System.out.printf("( Acceptance = %8b)\n\n", dfa1.accept(answer.toLowerCase()));
        }
        
        dfaClass dfa2 = new dfaClass("src/DFAproject/DFA2.txt");
        dfa2.print();
        //addig the input strings we want to test the dfa that is in the txt file using dfaClass reading it line by line
        ArrayList<String> dfaArray2 = new ArrayList<>();
        dfaArray2.add("1");
        dfaArray2.add("10101");
        dfaArray2.add("111110");
        dfaArray2.add("11111000111");
        dfaArray2.add("000001111111");
        dfaArray2.add("100001");
        
        System.out.println();System.out.println();
        
        
        for(String answer: dfaArray2){
            System.out.println("input: "+ answer);
            System.out.println(Arrays.toString(dfa2.process(answer)));
            System.out.printf("( Acceptance = %8b) \n\n", dfa2.accept(answer));
        }
        
      
        
        dfaClass dfa3 = new dfaClass("src/DFAproject/DFA3.txt");
        dfa3.print();
        //addig the input strings we want to test the dfa that is in the txt file using dfaClass reading it line by line
        ArrayList<String> dfaArray3 = new ArrayList<>();
        dfaArray3.add("a");
        dfaArray3.add("aa");
        dfaArray3.add("b");
        dfaArray3.add("bb");
        dfaArray3.add("ab");
        dfaArray3.add("ba");
        dfaArray3.add("aaabbbbbbb");
        dfaArray3.add("aaaab");
        
        System.out.println();System.out.println();
        
         //take the letters from the txt file and make them lower case so it isn't conflicting
        for(String answer: dfaArray3){
              System.out.println("input: "+ answer);
            System.out.println(Arrays.toString(dfa3.process(answer.toLowerCase())));
            System.out.printf("( Acceptance = %8b)\n\n", dfa3.accept(answer.toLowerCase()));
        }
    } 
}
