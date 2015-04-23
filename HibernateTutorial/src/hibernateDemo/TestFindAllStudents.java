package hibernateDemo;


import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
 
public class TestFindAllStudents{

    public static void main(String[] args) {
    	Configuration configuration = new Configuration();
        configuration.configure();
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
        	.applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        createStudents(session);
        getStudents(session);
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
	private static void createStudents(Session session){
		 String[] names = {"Alan Turing", "Grace Hopper", "Edsger Dijkstra", "Dennis Ritchie", "Ken Thompson", "Brin Kernighan", "Anita Borg"};
         
		for(int i = 0; i < 7; i++){
			Student student = new Student();
			student.setName(names[i]);
			Random random = new Random();
			int randNum = random.nextInt(3 - 0 + 1) + 0;
			switch(randNum){
			case 0: student.setAddress("Ames");
			student.setYear(Classification.Freshman);
			break;
			case 1: student.setAddress("Iowa City");
			student.setYear(Classification.Sophomore);
			break;
			case 2: student.setAddress("Minnesota");
			student.setYear(Classification.Junior);
			break;
			case 3: student.setAddress("Des Moines");
			student.setYear(Classification.Senior);
			break;
			}
			session.save(student);
		}
	}

}