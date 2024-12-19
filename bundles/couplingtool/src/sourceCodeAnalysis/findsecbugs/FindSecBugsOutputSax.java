package sourceCodeAnalysis.findsecbugs;

import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class FindSecBugsOutputSax extends DefaultHandler{

	  private StringBuilder currentValue = new StringBuilder();

	  @Override
	  public void startDocument() {
	      System.out.println("Start Document");
	  }

	  @Override
	  public void endDocument() {
	      System.out.println("End Document");
	  }

	  public void startElement(
	          String uri,
	          String localName,
	          String qName,
	          Attributes attributes) {

	      // reset the tag value
	      currentValue.setLength(0);

	      System.out.printf("Start Element : %s%n", qName);

	      if (qName.equalsIgnoreCase("staff")) {
	          // get tag's attribute by name
	          String id = attributes.getValue("id");
	          System.out.printf("Staff id : %s%n", id);
	      }

	      if (qName.equalsIgnoreCase("salary")) {
	          // get tag's attribute by index, 0 = first attribute
	          String currency = attributes.getValue(0);
	          System.out.printf("Currency :%s%n", currency);
	      }

	  }
	  // http://www.saxproject.org/apidoc/org/xml/sax/ContentHandler.html#characters%28char%5B%5D,%20int,%20int%29
	  // SAX parsers may return all contiguous character data in a single chunk,
	  // or they may split it into several chunks
	  @Override
	  public void characters(char ch[], int start, int length) {

	      // The characters() method can be called multiple times for a single text node.
	      // Some values may missing if assign to a new string

	      // avoid doing this
	      // value = new String(ch, start, length);

	      // better append it, works for single or multiple calls
	      currentValue.append(ch, start, length);

	  }
}
