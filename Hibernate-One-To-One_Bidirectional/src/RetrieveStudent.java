import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveStudent {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.addAnnotatedClass(StudentDetail.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		StudentDetail tempStudentDetail=(StudentDetail) session.get(StudentDetail.class,3);
		System.out.println(tempStudentDetail);
		session.getTransaction().commit();
	}
}
