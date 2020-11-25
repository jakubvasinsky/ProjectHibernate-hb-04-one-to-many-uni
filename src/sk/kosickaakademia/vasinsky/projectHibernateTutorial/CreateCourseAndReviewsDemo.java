package sk.kosickaakademia.vasinsky.projectHibernateTutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entities.Course;
import Entities.Instructor;
import Entities.InstructorDetail;
import Entities.Review;

public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();


        try {

            session.beginTransaction();


            Course tempCourse = new Course("Bikeracing - How to ride a bike");


            tempCourse.addReview(new Review("I love it!"));
            tempCourse.addReview(new Review("Cool!"));
            tempCourse.addReview(new Review("Boo Sucks!"));


            System.out.println("Saving the course...");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);


            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {


            session.close();
            factory.close();
        }
    }

}