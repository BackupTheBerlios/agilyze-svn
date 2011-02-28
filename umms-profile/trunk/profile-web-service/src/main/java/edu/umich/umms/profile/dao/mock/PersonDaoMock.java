package edu.umich.umms.profile.dao.mock;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SystemUtils;
import org.apache.log4j.ConsoleAppender;

import edu.umich.umms.profile.dao.PersonDao;
import edu.umich.umms.profile.domain.Person;
import edu.umich.umms.profile.exception.AuthenticationException;

public class PersonDaoMock implements PersonDao {


	@Override
	public Person getPerson(Long personId) {
		// TODO Auto-generated method stub


		Person person = new Person("bob", String.format("Unit%d", personId), "carol", "alice", "42");
		person.setId(personId);
		return person;
	}

	@Override
	public void savePerson(Person person) {

	}

	@Override
	public List<Person> getPeople() {
		// TODO Auto-generated method stub
		List<Person> personList = new ArrayList<Person>();
		personList.add(getPerson(234L));
		personList.add(getPerson(123L));
		personList.add(getPerson(345L));
		personList.add(getPerson(42L));
		return personList ;
	}

	@Override
	public Person getPersonByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person authenticatePerson(String user, String password)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

}
