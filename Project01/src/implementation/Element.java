package implementation;
import java.util.*;
import java.util.regex.*;

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
	  
        public void getElementTextContent(String ElementName){
		  
		  Pattern pattern = Pattern.compile("<tag>(.+?)</tag>");
		  Matcher matcher = pattern.matcher("<tag>String I want to extract</tag>");
		  while(matcher.find()){			  
			      System.out.println(matcher.group(1)); 
		  }
	    }
	  
      public void getParentElement(String childElementName){
  		  
    	  int startIndex=0;
		  int endIndex=0;
		  String childElement="<"+childElementName;
		  
		  List<String> subList=new ArrayList<String>();
		  
		  for(int x=0; x<subList.size(); x++){
			  
			  System.out.println(subList.get(x));
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
    	  
    	  //GET ALL ELEMENT ATTRIBUTES BY ELEMENT NAME
    	  
    	  String element="<"+elementName;
    	  Iterator<String> iterator=list.iterator();
    	  String [] splitter;
    	  
    	  while(iterator.hasNext()){
    		  
    		  if(iterator.next().contains(" ") && iterator.next().startsWith(element)){
    			  
    			  splitter=iterator.next().split(" ");	
    			  
    			  for(int x=0; x<splitter.length; x++){
    				  
    				  splitter[x]=splitter[x]+",";
    			  }
				  String[] newSplitterArr = Arrays.copyOfRange(splitter, 1, splitter.length);				  
				  String s="";
				  
				  for(int x=0; x<newSplitterArr.length; x++){
					  
					  s+=newSplitterArr[x];
				  }				  
				  //s=s.replaceAll("\\s","");
				  s=s.replaceAll(">","");
				  
				  //String [] newSplitterArrTwo=s.split(",");
				  String [] newSplitterArrTwo=s.split("(,)|(=)");
				  
				  ArrayList<String> KeyPair=new ArrayList<String>();
				  ArrayList<String> ValuePair=new ArrayList<String>();
				  
                  for(int x=0; x<newSplitterArrTwo.length; x++){
                	  
                	  if(newSplitterArrTwo[x].startsWith("\"")){
                		  
                		  ValuePair.add(newSplitterArrTwo[x]);
                	  }
                	  
                	  else {
                		  KeyPair.add(newSplitterArrTwo[x]);
                	  }
                  }
				  
                  Iterator<String> keyIterator=KeyPair.iterator();
                  Iterator<String> valueIterator=ValuePair.iterator();
                  
                  HashMap<String,String> hMap=new HashMap<String,String>();
                  
                  while(keyIterator.hasNext() && valueIterator.hasNext()){
                	  
                	  hMap.put(keyIterator.next(), valueIterator.next());
                  }
                  
                  for (Map.Entry<String, String> entry : hMap.entrySet()) {
          		       System.out.println(entry.getKey() + ": " + entry.getValue());
          		      }
                  
				  break;
    		  }
    		  
    		  else if(iterator.next().startsWith(element)){
    			  System.out.println("No Attributes Available for Given Element"+iterator.next());
    			  break;
    		  }
    	  }
      }
      
      //OVERLOADING getElementAllAttributes
      
      public void getElementAllAttributes(String elementName, String attributeName){
    	  
    	  
    	  //GET ALL ELEMENT ATTRIBUTES BY ELEMENT NAME
    	  
    	  String element="<"+elementName;
    	  Iterator<String> iterator=list.iterator();
    	  String [] splitter;
    	  
    	  while(iterator.hasNext()){
    		  
    		  if(iterator.next().contains(" ") && iterator.next().startsWith(element)){
    			  
    			  splitter=iterator.next().split(" ");	
    			  
    			  for(int x=0; x<splitter.length; x++){
    				  
    				  splitter[x]=splitter[x]+",";
    			  }
				  String[] newSplitterArr = Arrays.copyOfRange(splitter, 1, splitter.length);				  
				  String s="";
				  
				  for(int x=0; x<newSplitterArr.length; x++){
					  
					  s+=newSplitterArr[x];
				  }				  
				  //s=s.replaceAll("\\s","");
				  s=s.replaceAll(">","");
				  
				  //String [] newSplitterArrTwo=s.split(",");
				  String [] newSplitterArrTwo=s.split("(,)|(=)");
				  
				  ArrayList<String> KeyPair=new ArrayList<String>();
				  ArrayList<String> ValuePair=new ArrayList<String>();
				  
                  for(int x=0; x<newSplitterArrTwo.length; x++){
                	  
                	  if(newSplitterArrTwo[x].startsWith("\"")){
                		  
                		  ValuePair.add(newSplitterArrTwo[x]);
                	  }
                	  
                	  else {
                		  KeyPair.add(newSplitterArrTwo[x]);
                	  }
                  }
				  
                  Iterator<String> keyIterator=KeyPair.iterator();
                  Iterator<String> valueIterator=ValuePair.iterator();
                  
                  HashMap<String,String> hMap=new HashMap<String,String>();
                  
                  while(keyIterator.hasNext() && valueIterator.hasNext()){
                	  
                	  hMap.put(keyIterator.next(), valueIterator.next());
                  }
                  
                  for (Map.Entry<String, String> entry : hMap.entrySet()) {
          		       System.out.println(entry.getKey() + ": " + entry.getValue());
          		      }
                  
				  
    		  }
    
    	  }
      }
	  	  
	  public static void main(String [] args){
		
		  Element a=new Element();
		  a.retrieveFile();
		  
		  //a.getElementByID(2);
		  //a.getChildElements("firstname");
		  //a.getElementAttributes("students");
		  
		  //a.getElementByName("lastname",5);
		  //a.getElementAllAttributes("nickname");
		  //a.getElementAllAttributes("nickname", "ssssss");
		  
		  //a.getChildElementByName("students", "student");
		  
		  a.getParentElement("student");
	  }
}
