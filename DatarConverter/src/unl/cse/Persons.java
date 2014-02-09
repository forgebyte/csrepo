package unl.cse;

/*
 * Main Person Object, host 3 child parent elements
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "person")
@XmlType(propOrder = {"id", "firstName", "lastName", "addressList", "emailsList"} )
public class Persons {

	private String id;
	private String firstName;
	private String lastName;
	
	@XmlElementWrapper(name = "emails")
	@XmlElement(name = "email")
	private ArrayList<String> emailsList = new ArrayList<String>();
	
	@XmlElement(name = "address")
	private ArrayList<PersonsAddress> addressList = new ArrayList<PersonsAddress>();
	
	public Persons() { }
	
	@XmlElement(name = "id")
	public void setId(String id) {
		this.id = id.trim();
	}

	@XmlElement(name = "firstName")
	public void setFirstName(String name) {
		this.firstName = name.trim();
	}
	
	@XmlElement(name = "lastName")
	public void setLastName(String name) {
		this.lastName = name.trim();
	}

	public void setAddress(PersonsAddress address) {
		this.addressList.add(address);
	}

	public void setEmails(String[] emails) {
		for (String s : emails) {
			if (s != null) {
				this.emailsList.add(s);
			} else {
				this.emailsList.add("N/A");
			}
		}
	}
	
	public List<PersonsAddress> getAddress() {
    	return Collections.unmodifiableList(this.addressList);
	}
	
	public List<String> getEmails() {
		return Collections.unmodifiableList(this.emailsList);
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getId() {
		return id;
	}
}