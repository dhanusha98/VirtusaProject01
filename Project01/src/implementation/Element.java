package implementation;
import java.util.*;
import java.util.regex.*;

public class Element implements ElementInterface{

	private List<String> list;
	  public void retrieveFile(){
		  
		  FileClass o=new FileClass();
		  o.readFile("Student.xml");
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
	
	  public void getElementTextContent(String ElementName){
		  
		  String element="<"+ElementName;
		  //String endElement="</"+ElementName+">";
		  //int startIndex=0;
		  //int endIndex=0;
		  String value="";
		  for(int x=0; x<list.size(); x++){			  
			  if(list.get(x).startsWith(element)){
				  value=list.get(x);
				  
				  String [] splitter=value.split("[><]");
				  
				  System.out.println("TEXT CONTENT: "+splitter[2]);
			  }
		  }
	  }
        
      public void getParentElement(String childElementName) {
        	
    	  ListIterator<String> iterator=list.listIterator();
    	  String element="<"+childElementName;
    	  
          for(int x=0; x<list.size(); x++){
        	  
        	  if(list.get(x).startsWith(element)){
        		  
        		  for(int y=x-1; y>=0; y--){
        			  
        			  if(list.get(y).contains("</")==false){
        				  
        				  System.out.println("Parent Element: "+list.get(y));
        				  break;
        			  }
        		  }
        	  }
          }
      }
        
  	  public void getChildElementByName(String parentElement, String childElement){
  		   
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
		  String childElemenName="<"+childElement;
		  
		  for(int x=0; x<childList.size(); x++){
			  if(childList.get(x).startsWith(childElemenName)){
                     System.out.println(childList.get(x));
                     break;
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
	  
	  public void getElementByName(String elementName){
		  
		  //RETRIEVE ALL MATCHING ELEMENTS
		  
		  String element="<"+elementName;
		  List<String> matchList=new ArrayList<String>();
		  
		  for(int x=0; x<list.size(); x++){
			  
			  if(list.get(x).startsWith(element) && list.get(x).contains(" ")==true){
				  String [] splitter=list.get(x).split(" ");
					
				 if(splitter[0].equals(element)){
					 matchList.add(list.get(x));
				 }
			  }
			  else if(list.get(x).startsWith(element)){
				  matchList.add(list.get(x));
			  }
		  }
	      
		  if(matchList.size()>0) {
			  Iterator<String> itr=matchList.iterator();
			  
			  while(itr.hasNext()){
				  System.out.println(itr.next());
			  }
			  
		  }
		  
		  else{
			  
			  System.out.println("Element Not Found in the File !");
		  }
		  
	  }
	  
      public void getElementByName(String elementName, int index){
		  
		  //RETRIEVE ONLY SINGLE MATCHING ELEMENT BASED ON GIVEN INDEX
		  
		  String element="<"+elementName;
		  List<String> matchList=new ArrayList<String>();
		  
		  for(int x=0; x<list.size(); x++){
			  
			  if(list.get(x).startsWith(element) && list.get(x).contains(" ")==true){
				  String [] splitter=list.get(x).split(" ");
					
				 if(splitter[0].equals(element)){
					 //System.out.println(list.get(x));
					 matchList.add(list.get(x));
				 }
			  }
		      
			  else if(list.get(x).startsWith(element)){  
				  //System.out.println(list.get(x));
				  matchList.add(list.get(x));
			  }
		  }
              if(matchList.size()>0) {
			    for(int x=0; x<matchList.size(); x++){
			    	if(index < 0 || index > matchList.size()) {
			    		System.out.println("Invalid Index!");
			    		break;
			    	}
			    	else{
			    		if(x==index){			 
			    			System.out.println(matchList.get(x));
			    		}
			    	}
			    }
		      }
		  
		     else {
			      System.out.println("Element Not Found in the File !");
		     }
	  }
      
      public void getElementAllAttributes(String elementName){
    	  
    	  String element="<"+elementName;
    	  
    	  for(int x=0; x<list.size(); x++){
    		  
    		  if(list.get(x).startsWith(element) && list.get(x).contains(" ")==true){
    			  
    			  String value=list.get(x);
    			  value=value.replace(">", "");
    			  
    			  String [] splitter=value.split(" ");
    			  
    			  for(int y=1; y<splitter.length; y++){
    				  
    				  System.out.println("Attribute Name with Value (Separeted from \'=\'):  "+splitter[y]);
    			  }
    			  
    		  }
    		  
    		 
    	  }
      }
      
      //OVERLOADING getElementAllAttributes
      
      public void getElementAllAttributes(String elementName, String attributeName){
    	  
  String element="<"+elementName;
    	  
    	  for(int x=0; x<list.size(); x++){
    		  
    		  if(list.get(x).startsWith(element) && list.get(x).contains(" ")==true){
    			  
    			  String value=list.get(x);
    			  value=value.replace(">", "");
    			  
    			  String [] splitter=value.split(" ");
    			  
    			  for(int y=1; y<splitter.length; y++){
    				  
    				  if(splitter[y].startsWith(attributeName)){
    					  System.out.println("Attribute Name with Value (Separeted from \'=\'):  "+splitter[y]);
    				  }
    				  
    			  }
    			  
    		  }
    		  
    		 
    	  }
      }
	  	  
	  public static void main(String [] args){
		
		  Element a=new Element();
		  a.retrieveFile(); //FILE RETRIEVAL
		  
		  
		  //a.getElementByID(1);          //ACCESS ELEMENT BY ELEMENT ID
		  //a.getElementByName("student"); //ACCESS ELEMENT BY ELEMENT NAME (ALL ELEMENTS)
		  //a.getElementByName("student",0); //ACCESS ELEMENT BY ELEMENT NAME (SPECIFC INDEX)
		  //a.getElementAllAttributes("student"); //ACCESS ALL ELEMENT ATTRIBUTES BY NAME
		  //a.getElementAllAttributes("student","ID"); //ACCESS ELEMENT ATTRIBUTES BASED ON ELEMENT ATTRIBUTE NAME
		  //a.getParentElement("nickname"); //ACCESS PARENT ELEMENT OF ELEMENT
		  //a.getChildElements("student");  //ACCESS ALL CHILD ELEMENTS OF ELEMENT
		  //a.getChildElementByName("student", "firstname"); //ACCESS SPECIFIC CHILD ELEMENT OF ELEMENT
		  //a.getElementTextContent("lastname"); //ACCESS TEXT CONTENT OF ELEMENT
	  }
}
