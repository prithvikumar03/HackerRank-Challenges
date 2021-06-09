package others;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SortedList extends ArrayList<SortedList.Employee> {

    @Override
    public boolean add(Employee obj){
        //Find where the new element will fit in based on a criteria (either emp id or name or age)
        Optional<Employee> optionalFirst = this.stream().filter(x -> x.id > obj.id).findFirst();
        //If the element is not present means that the new element goes to the end
        //Do NOT call add as it will go into a infinite loop.
        if(!optionalFirst.isPresent()){
            this.add(this.size(),obj);
        }
        else{
            //Add to the place where the first element which was higher in order
            int i = this.indexOf(optionalFirst.get());
            this.add(i,obj);
        }
        return true;
    }

    public static void main(String[] args) {
        List<Employee> employeeList = new SortedList();
        employeeList.add(new Employee(10, "Apple", 13));
        employeeList.add(new Employee(15, "Bat", 5));
        employeeList.add(new Employee(12, "Cat", 8));
        System.out.println(employeeList);
    }

    public static class Employee{
        int age;
        String name;
        int id;
        public Employee(int age, String name, int id) {
            this.age = age;
            this.name = name;
            this.id = id;
        }
    }
}

/*List<Employee> sortedEmployee = employeeList.stream().sorted(Employee::compareTo).collect(Collectors.toList());
Employee cat = new Employee(12, "Cat", 8);
Optional<Employee> first = sortedEmployee.stream().filter(x -> x.id > cat.id).findFirst();
int i = sortedEmployee.indexOf(first.get());*/
