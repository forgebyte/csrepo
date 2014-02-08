package unl.cse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="unl.cse")
@XmlType(propOrder={"code", "name", "hourPrice", "consultant"})

public class Consultation {
	Double hourPrice;
	
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
	public void setHourPrice(Double hourPrice) {
		this.hourPrice = hourPrice;
	}
	
	public Persons getConsultant() {
		return consultant;
	}
	@XmlElement(name="consultant")
	public void setConsultant(Persons consultant) {
		this.consultant = consultant;
	}
	
}
