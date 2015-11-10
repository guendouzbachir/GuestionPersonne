/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import persistence.Person;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author bibo
 */
@Local
public interface PersonBeanLocal {
    public void addPerson(Person person);
    public List<Person> getAllPersons();
}
