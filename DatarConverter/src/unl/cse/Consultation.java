package unl.cse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="unl.cse")
@XmlType(propOrder={"code", "name", "hourPrice", "consultant"})

public class Consultation {
	
	private String code;
	private String name;
	private Double hourPrice;
	private String personId;
	private String firstName;
	private String lastName;
	
	/*
	 *
	 * NOTE! Need to construct with persons id
	 * to reference the personal data.
	 *
	 */
	
	public Consultation(String id) {
		this.personId = id;
	}
	
	public String getCode() {
		return code;
	}
	
	@XmlElement(name="code")
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	@XmlElement(name="name")
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getHourPrice() {
		return hourPrice;
	}
	
	@XmlElement(name="hourPrice")
	public void setHourPrice(String hourPrice) {
		Double temp;
		try {
			temp = Double.parseDouble(hourPrice);
		} catch (Exception e) {
			e.printStackTrace();
			temp = 0.0;
		}
		this.hourPrice = temp;
	}
	
	public Persons getConsultant() {
		return consultant;
	}
	@XmlElement(name="consultant")
	public void setConsultant(Persons consultant) {
		this.consultant = consultant;
	}	
}