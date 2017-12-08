/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author jet
 */
public class SorterProcess {
    
    public static int[] doSort(int[] a){       
        int temp[] =  new int[a.length];
        doMergeSort(a,0, a.length -1,temp);
        return temp;
    }
    
    public static void doMergeSort(int[] a, int start,int end,int[] temp){
        
        if(start >=end){
            return;
        }
        
        int middle = (start + end)/2;
        //Left side
        doMergeSort(a, start,middle,temp);
        //right side
        doMergeSort(a, middle+1,end,temp);
        mergeHalves(a,start, end, temp);
        
    }
    
    public static void mergeHalves(int[] a, int start,int end,int[] temp){
        int size = end - start +1;

        
        int middle = (start + end)/2;
        int left = start;
        int right = middle+1;
        
        for(int i=start; i <= end; i++){
            
            if(left <= middle && right <= end){
                
                if(a[left] <= a[right] ){
                    temp[i] = a[left];
                    left++;
                }else{
                    temp[i] = a[right];
                    right++;
                }
                   
            }else if(left > middle){
                temp[i] = a[right];
                right++;
            }else{
                temp[i] = a[left];
                left++;
            }
                
        }
        
        System.arraycopy(temp, start, a, start,size);

        
        
        

     
        
        
    }
    
    
    
}
