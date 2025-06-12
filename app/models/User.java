package models;

import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.Type;
import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class User extends Model {

  @Email
  @Required
  public String email;
    
  @Required
  public String password;
    
  public String fullName;
  @Type(type = "org.hibernate.type.NumericBooleanType")
  @Column(columnDefinition = "BIT")
  public boolean isAdmin = false;

  public User(String email, String password, String fullName) {
    this.email = email;
    this.password = password;
    this.fullName = fullName;
  }
  
  public static User connect(String email, String password) {
    return find("byEmailAndPassword", email, password).first();
  }

  public String toString() {
    return email;
  }
}
