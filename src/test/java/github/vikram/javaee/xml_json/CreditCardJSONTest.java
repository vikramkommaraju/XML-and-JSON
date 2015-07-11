package github.vikram.javaee.xml_json;

import static org.junit.Assert.*;

import java.io.StringWriter;
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import org.junit.Test;

public class CreditCardJSONTest {
	
	public static final String creditCardJSon =
	          "{\"creditCard\":" +
	                  "{\"number\":\"12345678\"," +
	                  "\"expiryDate\":\"10/14\"," +
	                  "\"controlNumber\":566," +
	                  "\"type\":\"Visa\"}" +
	          "}";
	 
	  @Test
	  public void shouldGenerateACreditCard(){
	 
	    CreditCard card = new CreditCard();
	    card.setNumber("12345678");
	    card.setExpiryDate("10/14");
	    card.setControlNumber(566);
	    card.setType("Visa");
	 
	    StringWriter writer = new StringWriter();
	    JsonGenerator generator = Json.createGenerator(writer);
	    generator.writeStartObject()
	             .writeStartObject("creditCard")
	             .write("number", card.getNumber())
	             .write("expiryDate", card.getExpiryDate())
	             .write("controlNumber", card.getControlNumber())
	             .write("type", card.getType())
	             .writeEnd()
	             .writeEnd()
	             .close();
	 
	    assertEquals(creditCardJSon , writer.toString().trim());
	 
	  }

}
