package edu.umich.umms.profile.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.umich.umms.profile.dao.PersonDao;
import edu.umich.umms.profile.domain.People;
import edu.umich.umms.profile.domain.Person;

@Controller
@RequestMapping( "/people" )
@Transactional( )
public class PersonController
{

    private PersonDao personDao;

    @Autowired
    public void setPersonDao( PersonDao personDao )
    {
        this.personDao = personDao;
    }

    @RequestMapping( method = RequestMethod.GET )
//    @ResponseBody
    public People getAll()
    {
        return new People( personDao.getPeople() );
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    // @ResponseBody not used with ContentNegotiatingViewResolver, which will
    // delegate to an xml or json marshalling view
    public Person getPerson( @PathVariable( "id" ) Long personId, HttpServletRequest request,
                             HttpServletResponse response )
    {
        System.out.println( "Header: " + request.getHeader( "Accept" ) );
        System.out.println( "Content-Type: " + request.getHeader( "Content-Type" ) );
        System.out.println( "Response Content-Type: " + response.getContentType() );
        return personDao.getPerson( personId );
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE )
    // @ResponseBody not used with ContentNegotiatingViewResolver, which will
    // delegate to an xml or json marshalling view
    public Person deletePerson( @PathVariable( "id" ) Long personId )
    {
        System.out.printf( "Person %d deleted.%n", personId );
        return personDao.getPerson( personId );
    }

    // @RequestMapping(method = RequestMethod.POST)
    // @Transactional(readOnly = false)
    // public View savePerson(@RequestBody Person person) {
    // personDao.savePerson(person);
    // System.out.printf("Saved %d, redirecting to /people/%d%n",
    // person.getId(), person.getId());
    //
    // return new RedirectView("/people/" + person.getId());
    // }
    @RequestMapping( method = RequestMethod.POST )
    @Transactional( readOnly = false )
    // @ResponseBody not used with ContentNegotiatingViewResolver, which will
    // delegate to an xml or json marshalling view
    public Person savePerson( @RequestBody Person person )
    {
        personDao.savePerson( person );
        System.out.printf( "Saved %d, redirecting to /people/%d%n", person.getId(), person.getId() );

        return person;
    }

    @RequestMapping( value = "/foo", method = RequestMethod.GET )
    // @ResponseBody
    // not used with ContentNegotiatingViewResolver, which will
    // delegate to an xml or json marshalling view
    public ModelMap  foo()
    {
        Map<String, String> hashMap = new HashMap<String, String>();
        Person firstPerson = new Person( "bob", "smith", "b", "x", 1 );
        Person secondPerson = new Person( "carol", "jones", "c", "y", 2 );
        hashMap.put( secondPerson.getFirstName(), firstPerson.getFirstName() );
        hashMap.put( firstPerson.getFirstName(), secondPerson.getFirstName() );

        return new ModelMap(hashMap);
    }

    @RequestMapping( value = "/bar", method = RequestMethod.GET )
    // @ResponseBody
    // not used with ContentNegotiatingViewResolver, which will
    // delegate to an xml or json marshalling view
    public List<String> bar()
    {
        List<String> folks = new ArrayList<String>();

        folks.add( "bob=smith" );
        folks.add( "ted=jones" );
        return folks;
    }
}