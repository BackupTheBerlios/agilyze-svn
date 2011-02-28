package edu.umich.umms.profile.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class People implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Person> bunchOfFolks;

	public People() {
		// empty constructor required for JAXB
	}

	public People(List<Person> person) {
		this.bunchOfFolks = person;
	}

	@XmlElementWrapper(name = "folks")
	public List<Person> getPerson() {
		return bunchOfFolks;
	}

	public void setPerson(List<Person> person) {
		this.bunchOfFolks = person;
	}

	@XmlElementWrapper (name="ids")
	public List<Long> getIds() {
		List<Long> ids = new ArrayList<Long>();

		for (Person p : bunchOfFolks) {
			ids.add(p.getId());
		}

		return ids;
	}
}