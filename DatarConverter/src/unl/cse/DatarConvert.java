package unl.cse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class DatarConvert {
	final String PERSONS_DATA_FILE = "datar/Persons.dat";
	final String INVOICES_DATA_FILE = "datar/Invoices.dat";
	final String PRODUCTS_DATA_FILE = "datar/Products.dat";
	final String PERSONS_XML_FILE = "datar/Persons.xml";
	final String INVOICES_XML_FILE = "datar/Invoices.xml";
	final String PRODUCTS_XML_FILE = "datar/Products.xml";
	private PersonsHub p = new PersonsHub();
	
	public DatarConvert() {
		parsePersonsXml();
	}
	
	public void parsePersonsXml() {
		Scanner s = null;
    	try {
			s = new Scanner(new File(PERSONS_DATA_FILE));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	s.nextLine();
    	while(s.hasNextLine()) {
    		String line = s.nextLine();
			String tokens[] = line.split(";");
			String code = tokens[0];
			String[] names = tokens[1].split(",");
			String[] address = tokens[2].split(",");
			String[] derp = {"N/A"};
			String[] emails = (tokens.length == 4) ? tokens[3].split(",") : derp;
			Persons dudes = new Persons();
			dudes.setId(code);
			dudes.setFirstName(names[0]);
			dudes.setLastName(names[1]);
			dudes.setEmails(emails);
			
			ArrayList<PersonsAddress> addressCollection = new ArrayList<PersonsAddress>();
			PersonsAddress adr = new PersonsAddress();
			adr.setStreet(address[0]);
			adr.setCity(address[1]);
			adr.setState(address[2]);
			adr.setZip(address[3]);
			adr.setCountry(address[4]);
			addressCollection.add(adr);
			dudes.setAddress(adr);
			p.addPersons(dudes);
    	}
    	try {
			JAXBContext cont = JAXBContext.newInstance(PersonsHub.class);
			Marshaller marsh = cont.createMarshaller();
			marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			File f = new File(PERSONS_XML_FILE);
			marsh.marshal(p, f);
			marsh.marshal(p, System.out);
		} catch (JAXBException e) {
			System.out.println("Error creating persons xml: "+e);
			e.printStackTrace();
		}
	}
	
	public void parseCustomerXml() {
		
	}
	
	public void parseProductXml() {
		
	}
	
	//LEXI! Y U NO MAKE?!
	public void parsePersonsJson() {
		
	}
	
	//LEXI! Y U NO MAKE?!
	public void parseCustomerJson() {
		
	}
	
	//LEXI! Y U NO MAKE?!
	public void parseProductJson() {
		
	}
	
	public static void main(String[] args) {
		new DatarConvert();
	}
}