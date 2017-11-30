package br.ufal.ic.cb.sample.model.repo;


import br.ufal.ic.cb.sample.model.Student;
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
@ViewIndexed(designDoc = "student", viewName = "all")
@N1qlPrimaryIndexed
public interface StudentRepository extends CouchbaseRepository<Student, String> {
    
    long countByCourseId(String courseId);
    
    List<Student> findByCourseId(String courseId);
    
    List<User> findByUserId(String userId);
    
    long deleteByUserId(String userId);

    List<User> removeByUserId(String userId);
}
