/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mnbean;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import metier.PersonBean;
import persistence.Person;

/**
 *
 * @author bibo
 */

@ManagedBean(name="registerBean")
@RequestScoped
public class PersonManagerBean {

    public PersonManagerBean() {
    }
    
    private String firstname;
    private String lastname;
    private String nickname;
    
    
    private Person person;
    
    @EJB
    private PersonBean personBean;
    
   /*  @PostConstruct
    public void initialize() {
        person = new Person();
    }*/
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public Person getPerson() {
        return this.person;
    }
    
    
    public String addUser() {
        person = new Person(firstname, lastname, nickname);
        personBean.addPerson(person);
        return "ajouter avec succée !";
    }
    
    public List<Person> getAllPersons() {
        return personBean.getAllPersons();
    }
    
    public void setFirstname(String firstname) {
        this.person.setFirstName(firstname);
    }
    
    public void setLastname(String lastname) {
        this.person.setLastName(lastname);
    }
    
    public void setNickname(String nickname) {
        this.person.setNickName(nickname);
    }

    public String getFirstname() {
        return person.getFirstName();
    }

    public String getLastname() {
        return person.getLastName(); 
    }

    public String getNickname() {
        return person.getNickName();
    }
    
    
    
}
