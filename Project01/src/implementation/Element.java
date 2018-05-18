package implementation;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Element implements ElementInterface{

	private List<String> list;
	  public void retrieveFile(){
		  
		  FileClass o=new FileClass();
		  o.readFile();
		  list=o.getFileContents();
		  
		  /*for(int x=0; x<list.size(); x++){
			  
			  System.out.println(list.get(x));
		  }*/
		  
	  }
	  
	  public void getElementByID(int id){
		  
		  Iterator<String> iterator=list.iterator();
		  
		  while(iterator.hasNext()){
			  
			  if(iterator.next().equals(list.get(id))) {
				  
				  System.out.println(iterator.next());
				  break;
			  }
		  }
	  }
	  public void getElementByName(String elementName){
		 
		  
	  }
	  public void getElementAttributes(String elementName){
		  
		  
	  }
	  public void getChildElements(String parentElement){
		  
		 
	  }
	  public void getParentElement(String childElementName){
		  
		  
	  }
	  
	  public static void main(String [] args){
		
		  Element a=new Element();
		  a.retrieveFile();
		  
		  //a.getElementByID(5);
	  }
}
