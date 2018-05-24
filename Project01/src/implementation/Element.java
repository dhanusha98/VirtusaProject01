package implementation;
import java.util.*;
import java.util.regex.*;

public class Element implements ElementInterface{

	private List<String> list; //LIST TO BE INCLUDED FILE ELEMENTS
	  public void retrieveFile(){
		  
		  //RETRIEVE FILE CONTENTS FROM 'FileClass'
		  
		  FileClass o=new FileClass();
		  o.readFile("Student.xml");
		  list=o.getFileContents(); //ASSIGN FILE ELEMENTS TO DECLARED LIST
		  
		  //DISPLAY FILE CONTENTS
		  
		 /*for(int x=0; x<list.size(); x++){
			  
			  System.out.println(list.get(x));
		  }*/
		  
	  }
	  
	  public void getElementByID(int id){
		  
		  //METHOD TO ACCESS FILE ELEMENTS BY ID BASED ON ARRAYLIST INDEX ITS STORED
		  
		  Iterator<String> iterator=list.iterator(); //ITERATOR TO TRAVERSE DECLARED LIST
		  
		  while(iterator.hasNext()){
			  
			  if(iterator.next().equals(list.get(id))) {
				  
				  System.out.println(iterator.next());
				  break;
			  }
		  }
	  }
	
	  public void getElementTextContent(String ElementName){
		  
		  //METHOD TO EXTRACT GIVEN ELEMENT'S TEXT CONTENT
		  
		  String element="<"+ElementName; //FORMATION OF ELEMENT NAME FOR COMPARISON AGAINST LIST ELEMENTS
		  //String endElement="</"+ElementName+">";
		  //int startIndex=0;
		  //int endIndex=0;
		  
		//TRAVERSING AND LOGIC TO EXTRACT ELEMENT ASSOCIATED TEXT CONTENT
		  
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
    	  
    	  //METHOD TO ACCESS PARENT ELEMENT OF ELEMENT 
        	
    	  ListIterator<String> iterator=list.listIterator();
    	  String element="<"+childElementName;   //FORMATION OF ELEMENT NAME FOR COMPARISON AGAINST LIST ELEMENTS
    	  
    	  //TRAVERSING AND LOGIC TO EXTRACT PARENT ELEMENT
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
  		   
  		  //METHOD TO GET SELECTED ELEMENT OF AN ELEMENT BASED ON PARENT AND CHILD ELEMENT NAMES
  		  
  		  String element="<"+parentElement; //FORMATION OF PARENT ELEMENT FOR COMPARISON AGAINST LIST
		  String endElement="</"+parentElement+">"; //FORMATION OF END PARENT ELEMENT FOR EXTRACTION
		  int startIndex=0;   //START INDEX TO CREATE SUB LIST OF CHILD ELEMENTS
		  int endIndex=0;  //END INDEX TO CREATE SUB LIST OF CHILD ELEMENTS
		  
		  //LOGIC TO EXTRACT CHILD ELEMENTS
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
  		   
  		   //METHOD TO GET ALL CHILD ELEMENTS OF PARENT ELEMENT
		  
		  String element="<"+parentElement;  //FORMATION OF PARENT ELEMENT FOR COMPARISON AGAINST LIST
		  String endElement="</"+parentElement+">"; //FORMATION OF END PARENT ELEMENT FOR EXTRACTION
		  int startIndex=0; //START INDEX TO CREATE SUB LIST OF CHILD ELEMENTS
		  int endIndex=0; //END INDEX TO CREATE SUB LIST OF CHILD ELEMENTS
		  
		//LOGIC TO EXTRACT CHILD ELEMENTS
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
		  
		  //METHOD TO GET ELEMENT BY NAME (RETRIEVE ALL MATCHING ELEMENTS)
		  
		  String element="<"+elementName; //FORMATION OF ELEMENT FOR COMPARISON AGAINST LIST ELEMENTS
		  List<String> matchList=new ArrayList<String>();
		  
		 //LOGIC TO EXTRACT CHILD ELEMENTS
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
		  
		  String element="<"+elementName;  //FORMATION OF ELEMENT FOR COMPARISON AGAINST LIST ELEMENTS
		  List<String> matchList=new ArrayList<String>();
		  
		  //LOGIC TO EXTRACT CHILD ELEMENTS
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
    	  
    	  //METHOD TO GET ALL ATTRIBUTES WITH VALUES OF GIVEN ELEMENT
    	  
    	  String element="<"+elementName;  //FORMATION OF ELEMENT FOR COMPARISON AGAINST LIST ELEMENTS
    	  
    	  //LOGIC TO EXTRACT CHILD ELEMENTS
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
    	  
    	//METHOD TO GET ONLY SELECTED ATTRIBUTES WITH VALUES OF GIVEN ELEMENT
    	  
          String element="<"+elementName;  //FORMATION OF ELEMENT FOR COMPARISON AGAINST LIST ELEMENTS
    	  
         //LOGIC TO EXTRACT CHILD ELEMENTS
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
