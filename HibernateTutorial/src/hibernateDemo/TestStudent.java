package hibernateDemo;
 

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
 
public class TestStudent{

    public static void main(String[] args) {
    	Configuration configuration = new Configuration();
        configuration.configure();
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
        	.applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        createStudent(session);
        findStudent(session);
        updateStudent(session);
        session.getTransaction().commit();
    }
 
	private static void getStudents(Session session) {
        Query query = session.createQuery("from Student");                 
        List <Student>list = query.list();
        java.util.Iterator<Student> iter = list.iterator();
        while (iter.hasNext()) {
            Student student = iter.next();
            System.out.println("Student: \"" + 
            		student.getName() +"\", Classification: " + 
            		student.getYear() + " Address: " +
            		student.getAddress());
        }
    }
 
    public static void createStudent(Session session) {
    	Student student = new Student();
    	student.setAddress("Ames");
    	student.setEmail("paul@iastate.edu");
    	student.setName("Paul Leichty");
    	Course course1 = new Course();
    	course1.setCourseID("430");
    	course1.setName("Software Tools");
    	student.addCourse(course1);
    	student.setYear(Classification.Senior);
    	session.save(student);
    }
    
    public static void findStudent(Session session){
    	Student student = (Student) session.get(Student.class, 1L);
    	System.out.println(student.getName() + ", Year: " + student.getYear() + ", email: " + student.getEmail());
    }
    public static void updateStudent(Session session){
    	Student student = (Student) session.get(Student.class, 1L);
    	student.setYear(Classification.Freshman);
    	session.persist(student);
    }
}