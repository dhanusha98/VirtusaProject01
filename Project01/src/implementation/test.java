package implementation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		 List<String> arr=new ArrayList<String>();
		 arr.add("100");
		 arr.add("200");
		 arr.add("300");
		 arr.add("400");
		 
		 ListIterator<String> itr=arr.listIterator();
		 
		 while(itr.hasNext()){
			 
			 System.out.println("index: " + itr.nextIndex());
			 itr.next();
		 }
	}

}
