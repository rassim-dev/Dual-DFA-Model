/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFAproject;

import java.io.*;
import java.util.*;


/**
 *
 * 46341 Amir Aghbar
 * 49171 Rassim Melaab
 * 46298 Samira Miah
 */
public class dfaClass {
    private String head;
    private int nQ; //n rows = n states
    private int nS;//n cols = n alphabets
    private String[] t;//state types : (-)regular (*)final (>)start (@)final/start
    private String[] Q; // set of states
    private String[] S; //Alphabet
    private String q0; //initial state
    private String[] F; // set of final / accepted states
    private String[][] d; //transition function as a 2D matrix

    private int dx = 10; // cell width in matrix
 
 public dfaClass(String fname) throws FileNotFoundException {
        Scanner fin = new Scanner(new File(fname));
        head = fin.nextLine();
        String[] x = fin.nextLine().split("x");
        nQ = Integer.parseInt(x[0]);
        nS = Integer.parseInt(x[1]);
        S = fin.nextLine().split("\\s+");
        S = Arrays.copyOfRange(S, 1, S.length);

        t = new String[nQ];
        Q = new String[nQ];
        F = new String[nQ];
        d = new String[nQ][nS];

        int i = 0;
        int fi = 0;
        while(fin.hasNext()){
            x = fin.nextLine().split("\\s+");
            t[i] = x[0];
            Q[i] = x[1];
            if(t[i].equals(">")||t[i].equals("@")){
             q0=Q[i];
            }
            if(t[i].equals("*")||t[i].equals("@")){
              F[fi++]=Q[i];
            }

            for(int j = 2; j < x.length; ++j){
                d[i][j-2]=x[j];
            }

            ++i;
        }
        F = Arrays.copyOfRange(F, 0, fi);
    }

    public void print(){
        System.out.println(head);
        System.out.println();
        for(int z = 0; z<=(dx*(2+nS));z++){
            System.out.print("-");
        }
        for(int v = 0; v<=(dx*2);v++){
            System.out.print(" ");
        }
        System.out.println("");
        System.out.print("\t\t");
        for (int g = 0; g < S.length; g++) {
            System.out.printf("%"+dx+"s", S[g]);
        }
       for(int i =0; i<nQ; ++i){
           System.out.println();
           System.out.printf("%" + dx + "s" + "%" + dx + "s", t[i], Q[i]);
           System.out.print(" ");
           for (int g = 0; g < d[i].length; g++) {
           System.out.printf("%"+dx+"s", d[i][g]);
        }

       }
       System.out.println();
    }

    public boolean accept(String in){
        return accept(in.split(""));
    }

    public boolean accept(String[] in){
        String Qc = q0;
        for (String a: in){
            Qc = getTrans(Qc, a);
            if(Qc.equals("N/A")){
                return false;
            }
        }
        return belongs(Qc, F);
    }

    public String[] process(String in){
        return process(in.split(""));
    }

    public String[] process(String[] in){
        String[] qOut = new String[in.length];
        String Qc = q0;
        qOut[0] = q0;

        for(int i=0; i<in.length; ++i){
          Qc = getTrans(Qc, in[i]);
          qOut[i] = Qc;
        }
        return qOut;
    }

    public boolean belongs(String e, String[] s){
        for(int i =0; i<s.length;++i){
            if(e.equals(s[i])){
                return true;
            }
        }
        return false;
    }

    public String getTrans(String q, String a){
        int qi = getQIdx(q);
        int ai = getAIdx(a);
        if(qi >= 0 && ai >=0){
            return d[qi][ai];
        }
        return "N/A";
    }

    public int getQIdx(String q){
        for(int i = 0; i<Q.length; ++i){
            if(q.equals(Q[i])){
                return i;
            }
        }
        return -1;
    }

     public int getAIdx(String a){
        for(int i = 0; i<S.length; ++i){
            if(a.equals(S[i])){
                return i;
            }
        }
        return -1;
    }

}

