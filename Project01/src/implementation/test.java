package implementation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int [] arr={110, 20, 33, 456};
		int first=arr[0];
		int index=0;
		int last=arr[arr.length-1];
		
		for(int x=0; x<arr.length; x++){
			
			if(arr[x]<first){	
				first=arr[x];
				index=x;
			}  
		}
		
		arr[index]=last;
		arr[arr.length-1]=first;
		
		
		for(Integer i: arr){
			
			System.out.println(i);
		}
	}

}
