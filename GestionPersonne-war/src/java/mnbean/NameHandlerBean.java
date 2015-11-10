/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mnbean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author bibo
 */


@ManagedBean(name="registrationBean")
@RequestScoped
public class NameHandlerBean {

    /**
     * Creates a new instance of PersonsManagedBean
     */
    public NameHandlerBean() {
    }
    
    private String firstname;
    private String lastname;
    private String nickname;
    private String language;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getLanguage() {
        return language;
    }
    
    
    
    public String errorMessage(){
        return "Bonjour "+firstname+" "+lastname+" "+ "("+lastname+""+(int) (Math.random() * 100)+") !";
    }
    
    public String greetingsMessage(){
            return "Bonjour ! "+firstname+ " "+lastname;
    }
    
    public String testNickname(){
        if(nickname.equals("")) 
            return "error";
        else 
            return "welcome";
    }
}