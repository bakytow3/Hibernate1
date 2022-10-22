package peaksoft.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

    @Column(name = "student_name")
    private  String name;
    @Column(name = "student_age")
    private  int age;
    @Column(name = "student_email")
    private String email;

    public Student() {

    }

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;

    }
}
