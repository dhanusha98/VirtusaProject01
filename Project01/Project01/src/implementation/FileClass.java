package implementation;
import java.util.*;
import java.io.*;
public class FileClass {

	private List<String> arr; //ArrayList to Hold File Contents
	
	public void readFile(){
		
           try {
			 
			 String filename="Student.xml";
			 File a=new File(filename);

			if(!filename.endsWith("xml")){
				 System.out.println("Invalid XML File!!!");
			   }
			
			 Scanner sc=new Scanner(a);
			 sc.useDelimiter("\n");
			 
			 arr=new ArrayList<String>();
			 
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
			 			 
			/* for(int x=0; x<arr.size(); x++){
					 System.out.println(arr.get(x));
			 }		*/ 			 			 
			  
		   }
		 
		   catch(FileNotFoundException ex){
			 System.out.println("File couldn't be found ! Please check the below error information \n");
			 ex.printStackTrace();
			 
		    }
		 
		   catch(Exception ex){
			 ex.printStackTrace();
		   }

	}
	
	public List<String> getFileContents(){
		
		return this.arr;
	}
	
   
	public static void main(String [] args){
		
		FileClass f=new FileClass();
		
		f.readFile();
		
		f.getFileContents();
	}
}
