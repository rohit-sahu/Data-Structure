package io.logical;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RRRTest {

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("erty", 400),
                new Employee("erty", 200), new Employee("erty", 600), new Employee("erty", 10),
                new Employee("erty", 1000));
        Employee employee = employees.stream().sorted((o1, o2) -> o2.getSalary().compareTo(o1.getSalary())).collect(Collectors.toList()).get(2);
    }

    static class Employee {

        private String name;
        private Integer salary;

        public Employee(String name, Integer salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }
    }
}
