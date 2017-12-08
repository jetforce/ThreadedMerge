/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jet
 */
public class Spawner {
    
    public static int numThread = 0;
    public static int maxThread = 0;
    
    public synchronized static boolean isSpawnThread(){
        if(numThread < maxThread){
            numThread++;
            return true;
        }else return false;
    } 
    

    public static void doSort(int[] a){
        int[] temp = new int[a.length];
        Helper h = new Helper(a ,temp, 0, a.length-1);
        h.start();
    
         try {
            h.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
    
}
