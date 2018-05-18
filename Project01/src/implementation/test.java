package implementation;

public class test {
	
	public static void main(String [] args){
		
		String a="Hello World from SL";
		
		String [] arr=a.split(" ",3);
		
		for(String ar: arr){
			
			System.out.println(ar);
		}
	}

}
