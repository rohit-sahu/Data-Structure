package io.logical;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Lowes {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(new Employee(1, 10000), new Employee(2, 100),
                new Employee(3, 3000000), new Employee(4, 50000));
        List<Employee> employees = employeeList.stream().filter(employee -> employee.getSalary() > 1000).collect(Collectors.toList());
        employees.forEach(System.out::println);
        List<String> alfanumeric = Arrays.asList("abc100", "def10","gh10ij");
        AtomicInteger sum = new AtomicInteger(0);
        alfanumeric.forEach(s -> {
            String num = s.replaceAll("[A-Za-z]", "");
            sum.set(sum.get() + Integer.parseInt(num));
        });
        System.out.println(sum.get());
    }

    static class Employee {
        private Integer id;
        private Integer salary;

        public Employee(Integer id, Integer salary) {
            this.id = id;
            this.salary = salary;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", salary=" + salary +
                    '}';
        }
    }
}
