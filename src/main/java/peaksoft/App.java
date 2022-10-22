package peaksoft;


import org.hibernate.Session;
import org.hibernate.query.Query;
import peaksoft.congigurations.HibernateConfig;
import peaksoft.entity.Student;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
///createStudent(new Student("Bekzat", 19, "bekzat@gmail.com"));
//        createStudent(new Student("Bekzat", 19, "bekzat@gmail.com"));
//        createStudent(new Student("Bekzat", 19, "bekzat@gmail.com"));
//        createStudent(new Student("Bekzat", 19, "bekzat@gmail.com"));
//        System.out.println(getStudentById(10L));
//        System.out.println(getAllStudents());
//        deleteStudentById(2L);

        deleteAllStudents();

        HibernateConfig.shutDown();
    }

    public static void createStudent(Student student) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Student with name: " + student.getName() + " successfylly created!");
        }
    }

    public static Student getStudentById(Long studentId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, studentId); // new Student(4, Nurislam, 23, bekzat@gmail.com);
            session.getTransaction().commit();
            if (student != null) {
                System.out.println("Student with id: " + studentId + " successfully found!");
            } else {
                System.out.println("We couldn't find student with id: " + studentId + "!");
            }
            return student;
        }
    }

    public static List<Student> getAllStudents() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Student> student = session.createQuery("from Student").getResultList();
            session.getTransaction().commit();

            System.out.println(student.size() + " student(s) have(has) been found!");

            return student;
        }
    }

    public static void deleteStudentById(Long studentId) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            System.out.println(student);
            session.delete(student);
            session.getTransaction().commit();

            System.out.println("Student with id: " + studentId + " successfully deleted!");
        }
    }

    public static void deleteAllStudents() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from Student");
            query.executeUpdate();
            session.getTransaction().commit();

            System.out.println("All students successfully deleted!");
        }
    }
}
