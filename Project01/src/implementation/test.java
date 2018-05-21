package implementation;

import java.util.*;
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<String> arraylist=new ArrayList<String>();
		arraylist.add("<student>");
		arraylist.add("<firstname ID>");
		arraylist.add("</firstname>");
		arraylist.add("</student>");
		
		for(int x=0; x<arraylist.size(); x++){
			
			if(arraylist.get(x).contains(" ")) {
				
				System.out.println(arraylist.get(x));
				break;
			}
				
			
		}
	}

}
