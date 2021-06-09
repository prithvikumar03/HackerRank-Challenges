package collections;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsExamples {

    public static class Student {
        public int studentId;
        public String name;
        public String city;

        public Student(int studentId, String name, String city) {
            this.studentId = studentId;
            this.name = name;
            this.city = city;
        }

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"abc","Pune"));
        studentList.add(new Student(2,"bcd","Nagpur"));
        studentList.add(new Student(3,"fbc","Aurangabad"));
        studentList.add(new Student(4,"zbc","Pataliputra"));
        studentList.add(new Student(5,"adbc","Pune"));

        String collect = studentList.stream().map(Student::getName).collect(Collectors.joining());
        System.out.println(collect);
    }
}
