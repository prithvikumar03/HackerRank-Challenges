import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/*
 * Create the Student and Priorities classes here.
 */

class Priorities{

    public List<Student> getStudents(List<String> events) {

        List<Student> studentList = new ArrayList<>();

        for(String event: events){
            if(event.contains("ENTER")) {
                String[] split = event.split(" ");
                studentList.add(new Student( Integer.parseInt(split[3]), split[1], Double.parseDouble(split[2])));
            }
            else{
                this.serveStudent(studentList);
            }
        }
        return studentList.size()>0?studentList.stream().sorted( (s4,s5) -> Double.compare(s5.getCgpa(),s4.getCgpa())).collect(Collectors.toList()):studentList;
    }

    private void serveStudent(List<Student> studentList) {
        if(studentList.size()>0) {

            double max_cgpa = studentList.stream().max(Comparator.comparing(Student::getCgpa)).get().getCgpa();
            List<Student> collect = studentList.stream().filter(s1 -> s1.getCgpa() == max_cgpa).collect(Collectors.toList());
            if (collect.size() > 1) {
                List<Student> collect1 = collect.stream().sorted((s2, s3) -> s2.getName().compareTo(s3.getName())).collect(Collectors.toList());
                studentList.remove(collect1.get(0));
            } else {
                studentList.remove(collect.get(0));
            }
        }
    }
}

class Student{
    protected int id;
    protected String name;
    protected double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class StudentPriority {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}

