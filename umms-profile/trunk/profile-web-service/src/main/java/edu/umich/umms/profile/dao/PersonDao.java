package edu.umich.umms.profile.dao;

import java.util.List;

import edu.umich.umms.profile.domain.Person;
import edu.umich.umms.profile.exception.AuthenticationException;

public interface PersonDao {

  public Person getPerson(Long personId);

  public void savePerson(Person person);

  public List<Person> getPeople();

  public Person getPersonByUsername(String username);

  public Person authenticatePerson(String user, String password)
      throws AuthenticationException;
}