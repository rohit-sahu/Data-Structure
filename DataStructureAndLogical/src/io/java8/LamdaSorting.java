package io.java8;

import java.util.*;

public class LamdaSorting {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(3);
        list.add(12);
        list.add(4);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("=========================================================");
        List<String> stringList = new ArrayList<String>();
        stringList.add("Rohit");
        stringList.add("Mohit");
        stringList.add("Bittu");
        stringList.add("Prem kishan");
        stringList.stream().sorted((a, b) -> a.compareTo(b)).forEach(System.out::println);
        System.out.println("=========================================================");
        List<String> strings = Arrays.asList();
        System.out.println(strings.stream().findAny().orElseGet(() -> "Hello"));
        System.out.println("=========================================================");
        List<Employee> employees = EmployeeBuilder.getEmployees();
        Collections.sort(employees, ( o1,  o2) ->(int) (o1.getSalary() - o2.getSalary()));
        //employees.stream().sorted(( o1,  o2) ->(int) (o2.getSalary() - o1.getSalary())).forEach(System.out::println);
        //employees.stream().sorted(Comparator.comparing(emp->emp.getSalary())).forEach(System.out::println);
        employees.stream().sorted(Comparator.comparing(Employee::getDept)).forEach(System.out::println);
        System.out.println("=========================================================");
        Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()));
        employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
        employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
        employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
        employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
        employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200000), 120);
        employeeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getDept).reversed()))
                .forEach(System.out::println);
        System.out.println("=========================================================");
        Map<String, Integer> map = new HashMap<>();
        map.put("eight", 8);
        map.put("four", 4);
        map.put("ten", 10);
        map.put("two", 2);
        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
    }
}
