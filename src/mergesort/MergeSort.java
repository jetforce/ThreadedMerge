/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jet
 */
public class MergeSort {

    
    public static int getRandom(){
        int maximum = 10000000;
        int minimum = 1;
        int randomNum;
        
        Random rn = new Random();
        int n = maximum - minimum + 1;
        int i = rn.nextInt() % n;
        randomNum =  minimum + i;
        
        return randomNum;
    }
    
    
    public static void main(String[] args) {
        
        int maxSizeArray = 20000000;
        int[] b = new int[maxSizeArray];
        
       
        for(int i=0; i <maxSizeArray; i++){
            //b[i] = getRandom();  
            b[i]= maxSizeArray - i ;
        } 
        
        long startTime = System.nanoTime();
        
        Spawner.doSort(b);
        
        
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
        
        
        for(int i: b){
            //System.out.println(i);
        }
        
        System.out.println("Comploted with "+ Spawner.numThread);
        
    }
    
    
    
}
