package implementation;
import java.util.*;


public class Element implements ElementInterface{

	private List<String> list;
	  public void retrieveFile(){
		  
		  FileClass o=new FileClass();
		  o.readFile();
		  list=o.getFileContents();
		  
		/* for(int x=0; x<list.size(); x++){
			  
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
		 
		  String element;
		 
		  for(int x=0; x<list.size(); x++){
				  
			 if(list.get(x).contains(" ")){
				 
				  element="<"+elementName;
				  if(list.get(x).startsWith(element)){
					  
					  System.out.println(list.get(x));
					  break;
				  }
			 }
			 
			 element="<"+elementName+" ";
			 
			 if(list.get(x).startsWith(element)){
				  
				  System.out.println(list.get(x));
				  
			  }
		  }
	  }
	  public void getElementAttributes(String elementName){
		  
		  String element="<"+elementName;
		  
		  Iterator<String> iterator=list.iterator();
		  
		  while(iterator.hasNext()){
			  
			  if(iterator.next().startsWith(element)){
				  
				  String value=iterator.next();
				  
				  int firstSpace=value.indexOf(" ");
				  int closeTagIndex=value.indexOf(">");
				  
				  int newStartIndex=firstSpace + 1;
				  
				  String attributes=value.substring(newStartIndex,closeTagIndex);
				  String [] attributeArray=attributes.split(" ");
				  
				  for(int x=0; x<attributeArray.length; x++){
					  
					  System.out.println("ATTRIBUTE WITH VALUE: "+attributeArray[x]);
				  }
				  break;
				  
				  /*int firstSpace=value.indexOf(" ");
				  int closeTagIndex=value.indexOf(">");
				  
				  int newStartIndex=firstSpace + 1;
				  int newEndIndex=closeTagIndex - 1;
				  
				  String attributes=value.substring(newStartIndex,newEndIndex);
				  System.out.println(attributes);*/
				  
				    
			  }
		  }
	  } 
	  
        public void getChildElements(String parentElement){
		  
		  String element="<"+parentElement;
		  String endElement="</"+parentElement+">";
		  int startIndex=0;
		  int endIndex=0;
		  
		  for(int x=0; x<list.size(); x++){
			  
			  if(list.get(x).contains(" ")==true){
				  
				  String [] splitElement=list.get(x).split(" ");
				  
				  if(splitElement[0]==element){
					  
					  startIndex=x+1;
				  }
				  
			  }
			  
			  if(list.get(x).startsWith(element)){
				  
				  startIndex=x+1;
			  }
			  
			  if(list.get(x).equals(endElement)){
				  
				  endIndex=x;
			  }
			 
		  }
		  
		  //CREATE CHILD ELEMENT LIST AND DISPLAY 
		  
		  List<String> childList=list.subList(startIndex, endIndex);		  
		  Iterator<String> childIterator=childList.iterator();
		  
		  while(childIterator.hasNext()){
			  
			  System.out.println(childIterator.next());
		  }
	  }
	  	  
	  public void getParentElement(String childElementName){
		  
		  
	  }
	  
	  public static void main(String [] args){
		
		  Element a=new Element();
		  a.retrieveFile();
		  
		  //a.getElementByID(5);
		  //a.getElementByName("firstname");
		  //a.getElementAttributes("student");
		  a.getChildElements("firstname");
	  }
}
