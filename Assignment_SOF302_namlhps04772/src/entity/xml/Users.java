package entity.xml;
// Generated Feb 20, 2017 3:59:03 PM by Hibernate Tools 4.3.1



/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {
     private String username;
     private String password;
     private String fullname;

    public Users() {
    }

    public Users(String username, String password, String fullname) {
       this.username = username;
       this.password = password;
       this.fullname = fullname;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFullname() {
        return this.fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }




}


