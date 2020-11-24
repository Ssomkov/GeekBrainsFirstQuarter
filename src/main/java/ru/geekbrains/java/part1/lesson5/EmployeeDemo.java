package ru.geekbrains.java.part1.lesson5;

import java.util.ArrayList;

public class EmployeeDemo {

    public static void main(String[] args) {

        //create employee with simple constructor
        Employee simpleEmployee = new Employee("Peter", "Gresko", "Vitalievich");

        //set up employee data with setters (example of using setter for age field)
        simpleEmployee.setPosition("Account manager");
        simpleEmployee.setEmail("pgresko@company.com");
        simpleEmployee.setPhone("+16798762354");
        simpleEmployee.setSalary(53630.10);
        simpleEmployee.setAge(46);

        //get employees list
        ArrayList<Employee> employees = getEmployeeList();

        //add created simpleEmployee to employees list
        employees.add(simpleEmployee);

        //print all employees
        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                System.out.println(employee);
            }
        }
    }

    //create list of 4 employees with advanced constructor
    private static ArrayList<Employee> getEmployeeList() {
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        employeeArrayList.add(new Employee("Konstantin", "Budanov", "Filippovich",
                "Senior Java developer", "kbudanov@company.com", "+73456764321", 73000.25, 51));
        employeeArrayList.add(new Employee("Ivan", "Petrov", "Alekseevich",
                "HR manager", "ipetrov@company.com", "+34658762354", 34000.75, 32));
        employeeArrayList.add(new Employee("Denis", "Sidorov", "Ivanovich",
                "Sales manager", "dsidorov@company.com", "+77652378723", 67800.00, 41));
        employeeArrayList.add(new Employee("Valentin", "Krasnov", "Olegovich",
                "QA engineer", "dsidorov@company.com", "+74958971020", 13500.03, 24));
        return employeeArrayList;
    }
}
