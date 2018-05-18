/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author tanisha
 */
public class JavaApplication10 {

    /**
     * @param args the command line arguments
     */
   
     public static int atMostSum(int arr[], int n,
                                        int health,int limit)
    {
        int sum = 0,injuries=1;
        int count = 0, maxcount = 0;
     
        for (int i = 0; i < n; i++) {
             
            // If adding current element doesn't
            // cross limit add it to current window
            if ((sum + arr[i]) < health  && (injuries*arr[i])<limit) {
                sum += arr[i]; 
                injuries=injuries*arr[i];
                count++;
            } 
     
            // Else, remove first element of current
            // window.
            else if(sum!=0)
           {
            sum = sum - arr[i - count] + arr[i];
            injuries=(injuries*arr[i])/arr[i-count];
           }
     
            // keep track of max length.
            maxcount = Math.max(count, maxcount); 
        }
        return maxcount;
    }
     
    /* Driver program to test above function */
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
       
        //int n = arr.length;
        int health = 2000;
        int limit=1000000;
     
        Scanner r=new Scanner(System.in);
        FileReader fin=new FileReader("F://input.txt");
        BufferedReader br=new BufferedReader(fin);
         //int =fin.read();
        int n=Integer.parseInt(br.readLine());
        int i;
        int arr[]=new int[n];
        for(i=0;i<n;i++)
            arr[i]=Integer.parseInt(br.readLine());
        //System.out.println("")
        System.out.print(atMostSum(arr, n, health,limit));
             
    }
    
}
