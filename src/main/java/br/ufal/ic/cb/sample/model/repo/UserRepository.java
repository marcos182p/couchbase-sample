package br.ufal.ic.cb.sample.model.repo;


import br.ufal.ic.cb.sample.model.User;
import java.util.List;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marcosmelo
 */

@Repository
@ViewIndexed(designDoc = "user", viewName = "all")
@N1qlPrimaryIndexed
public interface UserRepository extends CouchbaseRepository<User, String> {
    
    long countByLastname(String lastname);
    
    List<User> findByLastname(String lastname);
    
    List<User> findByFirstname(String firstname);
    
    long deleteByLastname(String lastname);

    List<User> removeByLastname(String lastname);
}
