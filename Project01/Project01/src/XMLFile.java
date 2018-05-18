import java.util.*;
import java.util.Arrays;
import java.io.*;
public class XMLFile {

	/*public XMLFile(String filename){
	
          if(!filename.endsWith(".xml")){
        	  System.out.println("Invalid XML Extension");
          }
          
          else {  	  
        
          }
	}*/
	    
	public static void main(String [] args){
		
		/*try {
			Scanner in = new Scanner(new FileReader("Student.xml"));
            StringBuilder sb=new StringBuilder();
            String[] arr;
            while(in.hasNext()){
            	
            	sb.append(in.next());
            	
            }
            
            String everything=sb.toString();
            String separator=">";
            
            String [] spliteverything=everything.split(separator);
            
            for(int x=0; x<spliteverything.length; x++){
            	
            	spliteverything[x]=spliteverything[x]+separator;
            }
            
            System.out.println(spliteverything[4]);
  	   }
  	  
  	    catch(Exception ex){
  		    ex.printStackTrace();
  	   }*/
		
	   try {
		   
           Scanner sc=new Scanner(new FileReader("Student.xml"));
           StringBuilder sb=new StringBuilder();
           
           while(sc.hasNext()){
        	   
        	   sb.append(sc.next());
        	   
           }
           
           String everything=sb.toString();
           String separator=">";
           
           String [] arr=everything.split(">");
           for(int x=0; x<arr.length; x++){
        	   
        	   arr[x]=arr[x]+separator;
           }
           
            List<String> arrayList=new ArrayList<String>(Arrays.asList(arr));
            arrayList.remove(0);
            
            for(int k=0; k<arrayList.size(); k++){
            	
            	System.out.println(arrayList.get(k));
            }
           
           /*ArrayList<String> updatableList = new ArrayList<String>();

           updatableList.addAll(arrayList);
           
           System.out.println(updatableList.get(0));
*/	   }
	   
	   catch(Exception ex){
		   
		   ex.printStackTrace();
	   }
	}
}
