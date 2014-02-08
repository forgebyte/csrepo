package unl.cse;

import java.util.ArrayList;  
import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="root", namespace="unl.cse")
public class ProductsHub {
	@XmlElementWrapper(name="products")
	@XmlElement(name="equipment")
	private final List<Equipment> equipList;
	@XmlElement(name="consultation")
	private final List<Consultation> consultList;
	@XmlElement(name="license")
	private final List<License> liceList;
	
	public ProductsHub(){
		this.equipList = new ArrayList<Equipment>();
		this.consultList = new ArrayList<Consultation>();
		this.liceList = new ArrayList<License>();
	}
	
	public List<Equipment> getEquipList() {
		return Collections.unmodifiableList(this.equipList);
	}
	
	public void addEquipment(Equipment newEquipment) {
		this.equipList.add(newEquipment);
	}
	
	public List<Consultation> getConsultList() {
		return Collections.unmodifiableList(this.consultList);
	}
	
	public void addConsutation(Consultation newConsultation) {
		this.consultList.add(newConsultation);
	}
	
	public List<License> getLiceList() {
		return Collections.unmodifiableList(this.liceList);
	}
	
	public void addLicense(Consultation newLicense) {
		this.consultList.add(newLicense);
	}

}