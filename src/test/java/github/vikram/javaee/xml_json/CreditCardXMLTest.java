package github.vikram.javaee.xml_json;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

public class CreditCardXMLTest {
	
	public static final String creditCardXML =
	          "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
	          "<creditCard number=\"12345678\">\n" +
	          "    <expiry_date>10/14</expiry_date>\n" +
	          "    <control_number>566</control_number>\n" +
	          "    <type>Visa</type>\n" +
	          "</creditCard>";
	
	@Test
	public void shouldMarshallACreditCardPOJOToAnXML() throws JAXBException {
		
		CreditCard card = new CreditCard();
		
		card.setNumber("12345678");
		card.setExpiryDate("10/14");
		card.setControlNumber(566);
		card.setType("Visa");
		
		StringWriter writer = new StringWriter();
	    JAXBContext context = JAXBContext.newInstance(CreditCard.class);
	    Marshaller m = context.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    m.marshal(card, writer);
		
	    System.out.println(writer);
	    assertEquals(creditCardXML, writer.toString().trim());
		
	}
	
	
	@Test
	public void shouldUnmarshallAnXMLToCreditCardPOJO() throws JAXBException {

		StringReader reader = new StringReader(creditCardXML);
	    JAXBContext context = JAXBContext.newInstance(CreditCard.class);
	    Unmarshaller u = context.createUnmarshaller();
	    CreditCard card = (CreditCard) u.unmarshal(reader);
	 
	    assertEquals("12345678", card.getNumber());
	    assertEquals("10/14", card.getExpiryDate());
	    assertEquals((Object) 566, card.getControlNumber());
	    assertEquals("Visa", card.getType());
	}
	
	
	

}
