/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.util.logging.Level;
import java.util.logging.Logger;
import static mergesort.SorterProcess.doMergeSort;
import static mergesort.SorterProcess.mergeHalves;

/**
 *
 * @author jet
 */
public class Helper extends Thread{
    
    private int start,end,mid;
    private int[] temp,input;
    private int numWait = 0;
    private Helper helper;
    
    private boolean waiting;
    
    public Helper(int[] input,int[] temp,int start,int end){
        this.start = start;
        this.end = end;
        this.temp = temp;
        this.input = input;
        this.helper = null;
        this.waiting = true;
    }
    
    public Helper(int[] input,int[] temp,int start,int end, Helper helper){
        this.start = start;
        this.end = end;
        this.temp = temp;
        this.input = input;
        this.helper = helper;
        this.waiting = true;
    }
    
    
    public synchronized void doneWaiting(){
        this.waiting = false;
        notifyAll();
    }
    
    
    public synchronized void wairForThread(){
        
        try {
            if(this.waiting)
                wait();
        } catch (InterruptedException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
    
    
    public void run(){
        if(start >=end){
            return;
        }
        
        int middle = (start + end)/2;
        //Left side
      
        //right side

        Helper h = null;
        if(Spawner.isSpawnThread()){
            h = new Helper(input,temp,middle+1,end);
            
            h.start();
        }else{
            SorterProcess.doMergeSort(input, middle+1,end,temp);
        }
        

        SorterProcess.doMergeSort(input, start,middle,temp);
        
                
        if(h != null){
            try {
                h.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        
        
 
        SorterProcess.mergeHalves(input,start, end, temp);
        
        
    }
    
    
    
}
