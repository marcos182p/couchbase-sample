package br.ufal.ic.cb.sample.model;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

/**
 *
 * @author marcosmelo
 */
@Document
public class User {

    @Id 
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE, delimiter = ".")
    private String id;
    @Field
    private final String firstname;
    @Field
    private final String lastname;
    @Field
    private final String email;
    @Field
    private final String password;

    public User(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstname=" + firstname + ", lastname=" 
                + lastname + ", email=" + email + ", password=" + password + '}';
    }
    
}
