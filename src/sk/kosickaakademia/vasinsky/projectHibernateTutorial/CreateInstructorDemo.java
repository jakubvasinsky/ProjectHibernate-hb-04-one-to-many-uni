package sk.kosickaakademia.vasinsky.projectHibernateTutorial;

import Entities.Course;
import Entities.Instructor;
import Entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//THIS IS INSERT ONE CLASS
public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
/*
Instructor tempInstructor=
        new Instructor("Chad", "Darby", "darby@luv2code.com");
InstructorDetail tempInstructorDetail =
        new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code");
tempInstructor.setInstructorDetail(tempInstructorDetail);
*/



            Instructor tempInstructor=
                    new Instructor("Arnold", "Svarceneger", "arnold@mgail.com");
            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.youtube.com", "Workout");
            tempInstructor.setInstructorDetail(tempInstructorDetail);



             session.beginTransaction();

             System.out.println("\n Saving instructor: "+tempInstructor);

session.save(tempInstructor);


            session.getTransaction().commit();
            System.out.println("\n Done!");

        }finally {
            session.close();
            factory.close();
        }


    }
}
