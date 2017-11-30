package br.ufal.ic.cb.sample.config;



import br.ufal.ic.cb.sample.model.Discipline;
import br.ufal.ic.cb.sample.model.Student;
import br.ufal.ic.cb.sample.model.User;
import br.ufal.ic.cb.sample.model.repo.StudentRepository;
import br.ufal.ic.cb.sample.model.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.repository.auditing.EnableCouchbaseAuditing;

/**
 *
 * @author marcosmelo
 */
@SpringBootApplication
@Configuration
@EnableCouchbaseAuditing
public class MainTest implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudentRepository studentRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(MainTest.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Executando...");
        User user1 = new User("Marcos", "Silva", "marcos@gmail.com", "123456");
        User user2 = new User("Paulo", "Melo", "paulo@gmail.com", "123456");
        User user3 = new User("José", "Silva", "jose@gmail.com", "123456");
        
        user1 = userRepository.save(user1);
        user2 = userRepository.save(user2);
        user3 = userRepository.save(user3);
        
        System.out.println("Salvo user1 = " + user1);
        System.out.println("Salvo user2 = " + user2);
        System.out.println("Salvo user3 = " + user3);
        
        System.out.println("");
        
        String course1 = "c1"; // Matemática
        String course2 = "c2"; // Computação
        String course3 = "c3"; // Física
        
        Student student1 = new Student(course1, user1.getId(), 4);
        student1.addPaidDiscipline(new Discipline("Cálculo 1", 30));
        student1.addPaidDiscipline(new Discipline("Cálculo 2", 30));
        
        Student student2 = new Student(course2, user2.getId(), 7);
        student2.addPaidDiscipline(new Discipline("Programação 1", 30));
        student2.addPaidDiscipline(new Discipline("Programação 2", 30));
        
        Student student3 = new Student(course3, user2.getId(), 1);
        student3.addPaidDiscipline(new Discipline("Física 1", 30));
        student3.addPaidDiscipline(new Discipline("Física 2", 30));
        
        student1 = studentRepository.save(student1);
        student2 = studentRepository.save(student2);
        student3 = studentRepository.save(student3);
        
        System.out.println("Salvo student1 = " + student1);
        System.out.println("Salvo student2 = " + student2);
        System.out.println("Salvo student3 = " + student3);
        
        
        System.out.println("Estudantes do course1 = " + studentRepository.findByCourseId(course1));
        System.out.println("Estudantes do course2 = " + studentRepository.findByCourseId(course2));
        System.out.println("Estudantes do course3 = " + studentRepository.findByCourseId(course3));
        
        System.out.println("Finalizando...");
        
    }
    
}
