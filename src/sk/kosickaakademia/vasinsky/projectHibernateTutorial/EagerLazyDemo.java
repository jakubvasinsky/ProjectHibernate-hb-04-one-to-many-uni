package sk.kosickaakademia.vasinsky.projectHibernateTutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.Course;
import Entities.Instructor;
import Entities.InstructorDetail;
public class EagerLazyDemo {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();

        try {


            session.beginTransaction();


            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("itsovy: Instructor: " + tempInstructor);

            System.out.println("itsovy: Courses: " + tempInstructor.getCourses());


            session.getTransaction().commit();


            session.close();
            System.out.println("\nitsovy: The session is now closed\n");


            System.out.println("itsovy: Courses: " + tempInstructor.getCourses());

            System.out.println("\n Done!");
        }finally {

            factory.close();
        }

    }

}