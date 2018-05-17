package newpackage;

import java.io.*;
import java.util.*;
public class FileClass {
	
	public static void main(String [] args){

		String filename="Student.xml";
		File a=new File(filename);
		
		 try {

			if(!filename.endsWith("xml")){
				 System.out.println("Invalid XML File!!!");
			}
			 Scanner sc=new Scanner(a);
			 sc.useDelimiter("\n");
			 ArrayList<String> arr=new ArrayList<String>();
			 
			 while(sc.hasNext()){
				    arr.add(sc.next()); 
			 }
			 
			 String [] strArray=arr.toArray(new String[arr.size()]);
			 arr.clear();
			 
			 for(int x=0; x<strArray.length; x++){
				 strArray[x]=strArray[x].trim();
				 
				 if(strArray[x].length()>0){
					 
					 if(!(strArray[x].startsWith("<") && strArray[x].endsWith(">"))){
						  
						  System.out.println("Invalid Contents. Please Try Again!!");
						  System.exit(0);
					 }
					 
					 arr.add(strArray[x]);
					 
				 }
			 }
			 			 
			 for(int x=0; x<arr.size(); x++){
					 System.out.println(arr.get(x));
			 }
			 
		}
		 
		 catch(Exception ex){
			 ex.printStackTrace();
		 }
		 
	}
}
