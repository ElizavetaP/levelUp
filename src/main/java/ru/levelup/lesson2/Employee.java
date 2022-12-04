package ru.levelup.lesson2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
public class Employee {
    private String name;
    @NonNull
    private Integer workAge;

    static void printEmployee(Collection<Employee> employees, int workAge) {
        employees.stream().filter(employee -> employee.getWorkAge() == workAge)
                .forEach(employee -> System.out.println(employee));

//        for (Employee employee : employees) {
//            if (employee.getWorkAge() == workAge) {
//                System.out.println(employee);
//            }
//        }
    }

    static ArrayList<Employee> fullEmployeeList(Integer minWorkAge, Integer maxWorkAge) {
        List<String> names = List.of("Шершуков Виктор", "Битова Анастасия", "Кириллов Валентин",
                "Игнатьев Игорь", "Самохвалова Наталия", "Павлова Лариса", "Баршев Андрей", "Оверченков Захар",
                "Бодалян Оксана", "Герасимов Александр", "Леденева Софья", "Ватолкина Светлана", "Волик Борис",
                "Архипов Яков", "Гусева Екатерина");
        ArrayList<Employee> employees = new ArrayList<>();
        for (String s : names) {
            employees.add(new Employee(s, ThreadLocalRandom.current().nextInt(minWorkAge, maxWorkAge)));
        }
        return employees;
    }

    static void deleteOddEmployees(ArrayList<Employee> employees) {
        int initialSize = employees.size();
        for (int i = 1; i <= initialSize; i++) {
            if (i % 2 > 0) {
                employees.remove((initialSize - 1) - (i - 1));
            }
        }
    }

    static TreeSet<Employee> getEmployeeSet(List<Employee> employees) {
        TreeSet<Employee> employeeSet = new TreeSet<>((o1, o2) -> {
            if (o1.equals(o2)) {
                return 0;
            } else if (o1.workAge > o2.workAge || o1.workAge.equals(o2.workAge)) {
                return -1;
            } else {
                return 1;
            }
        });
        employeeSet.addAll(employees);
        return employeeSet;
    }

    public static Set<Employee> unionSet(Set<Employee> employees1, Set<Employee> employees2) {
        Set<Employee> resultEmployees = new HashSet<>(employees1);
        resultEmployees.addAll(employees2);
        return resultEmployees;
    }

    public static Set<Employee> intersectSet(Set<Employee> employees1, Set<Employee> employees2) {
        Set<Employee> resultEmployees = new HashSet<>();
        for (Employee employee : employees2) {
            if (employees1.contains(employee)){
                resultEmployees.add(employee);
            }
        }
        return resultEmployees;
    }
}
