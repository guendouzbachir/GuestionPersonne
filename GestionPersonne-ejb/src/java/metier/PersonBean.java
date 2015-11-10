/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import persistence.Person;

/**
 *
 * @author bibo
 */

@Stateless(name="registeration")
public class PersonBean implements PersonBeanLocal{

    @Resource(lookup ="jdbc/gla")
    private DataSource dataSource;
    private Connection connection;
    private Person person;
    
    @PostConstruct
    public void initialize(){
        try {
            connection = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @PreDestroy
    public void cleanup(){
        try {
            connection.close();   
            connection=null;
        } catch (SQLException ex) {
            Logger.getLogger(PersonBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void addPerson(Person person) {
        try {
            
            Statement smt=connection.createStatement();
            smt.execute("INSERT INTO PERSONS(NICKNAME,FIRSTNAME,LASTNAME) VALUES("
                    + "\'"
                    + person.getNickName()
                    + "\',\'"
                    + person.getFirstName()
                    + "\',\'"
                    + person.getLastName()+ "\')");
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonBean.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    
    
    @Override
    public List<Person> getAllPersons() {
        List<Person> persons=new ArrayList<>();
        try {
            Statement smt=connection.createStatement();
            ResultSet rs = smt.executeQuery("select * from PERSONS");
            Person pers;
            while (rs.next()) {
            pers = new Person();
            pers.setNickName(rs.getString(1));                 
            pers.setFirstName(rs.getString(2));
            pers.setLastName(rs.getString(3));
            persons.add(pers);
         }
        } catch (SQLException ex) {
            Logger.getLogger(PersonBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
           return persons; 
    }

    
    
    
}
