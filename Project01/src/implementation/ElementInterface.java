package implementation;

public interface ElementInterface {

	  public void retrieveFile();
	  public void getElementByID(int id);
	  public void getElementByName(String elementName);
	  public void getElementAttributes(String elementName);
	  public void getChildElements(String parentElement);
	  public void getParentElement(String childElementName);
	  public void getElementTextContent(String ElementName);
	  public void getChildElementByName(String parentElement, String childElement);
		  
}
