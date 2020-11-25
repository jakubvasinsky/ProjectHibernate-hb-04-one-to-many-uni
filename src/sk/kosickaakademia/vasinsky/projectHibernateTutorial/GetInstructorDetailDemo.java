package sk.kosickaakademia.vasinsky.projectHibernateTutorial;

import Entities.Instructor;
import Entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//THIS IS INSERT ONE CLASS
public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

int theId = 2;
InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
            System.out.println("\n tempInstructorDetail: "+tempInstructorDetail);

            System.out.println("\n The associated Instructor: "+tempInstructorDetail.getInstructor());



 session.getTransaction().commit();
            System.out.println("\n Done!");

        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }


    }
}
