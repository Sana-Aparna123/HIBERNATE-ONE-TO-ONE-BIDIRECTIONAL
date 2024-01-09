import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertStudent {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentDetail.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		System.out.println("session has started");
		StudentDetail tempStudentDetail=new StudentDetail("Electricals","painting");
		Student tempStudent=new Student("Wyna","Teja","wyna@gmail.com");
		tempStudentDetail.setStudent(tempStudent);
		tempStudent.setStudentDetail(tempStudentDetail);
	    
		session.save(tempStudentDetail);
		session.getTransaction().commit();
		System.out.println("session has ended");
	}

}
