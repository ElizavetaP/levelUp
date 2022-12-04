package ru.levelup.lesson2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    public void testSortEmpty() {
        ArrayList<Employee> employees = new ArrayList<>();
        Employee.deleteOddEmployees(employees);
        assertEquals(Collections.emptyList(), employees);
    }

    @Test
    public void testSort1() {
        ArrayList<Employee> employees = new ArrayList<>(List.of(new Employee("Шершуков Виктор", 24),
                new Employee("Битова Анастасия", 26), new Employee("Кириллов Валентин", 24),
                new Employee("Игнатьев Игорь", 25), new Employee("Самохвалова Наталия", 30)));
        Employee.deleteOddEmployees(employees);
        ArrayList<Employee> resultEmployees = new ArrayList<>(List.of(new Employee("Битова Анастасия", 26),
                new Employee("Игнатьев Игорь", 25)));
        assertEquals(resultEmployees, employees);
    }

    @Test
    public void testSort2() {
        ArrayList<Employee> employees = new ArrayList<>(List.of(new Employee("Шершуков Виктор", 24),
                new Employee("Битова Анастасия", 26), new Employee("Кириллов Валентин", 24),
                new Employee("Игнатьев Игорь", 25), new Employee("Самохвалова Наталия", 30),
                new Employee("Павлова Лариса", 30)));
        Employee.deleteOddEmployees(employees);
        ArrayList<Employee> resultEmployees = new ArrayList<>(List.of(new Employee("Шершуков Виктор", 24),
                new Employee("Кириллов Валентин", 24), new Employee("Самохвалова Наталия", 30)));
        assertEquals(resultEmployees, employees);
    }

    @Test
    public void testGetEmployeeSet() {
        ArrayList<Employee> employees = new ArrayList<>(List.of(new Employee("Шершуков Виктор", 24),
                new Employee("Битова Анастасия", 26), new Employee("Кириллов Валентин", 24),
                new Employee("Игнатьев Игорь", 25), new Employee("Самохвалова Наталия", 30),
                new Employee("Павлова Лариса", 30), new Employee("Павлова Лариса", 30)));

        Set<Employee> resultEmployees = new LinkedHashSet<>(List.of(new Employee("Павлова Лариса", 30),
                new Employee("Самохвалова Наталия", 30), new Employee("Битова Анастасия", 26),
                new Employee("Игнатьев Игорь", 25), new Employee("Кириллов Валентин", 24),
                new Employee("Шершуков Виктор", 24)));
        System.out.println(resultEmployees);
        System.out.println(Employee.getEmployeeSet(employees));
        assertEquals(List.copyOf(resultEmployees), List.copyOf(Employee.getEmployeeSet(employees)));
    }
}