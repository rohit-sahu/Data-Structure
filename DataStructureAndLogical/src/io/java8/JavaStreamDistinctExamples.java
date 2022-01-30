package io.java8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreamDistinctExamples {

    public static void main(String[] args) throws UnsupportedEncodingException {

        Person lokesh = new Person(1, "Lokesh", "Gupta");
        Person brian = new Person(2, "Brian", "Clooney");
        Person alex = new Person(3, "Alex", "Kolen");
        Person alex2 = new Person(4, "Alex4", "Kolen");
        Person alex3 = new Person(5, "Alex5", "Kolen");

        //Add some random persons
        Collection<Person> list = Arrays.asList(alex2, lokesh, brian, alex, lokesh, brian, lokesh, alex3);

        // Get distinct objects by key
        List<Person> distinctElements = list.stream()
                .filter(person -> person.getId() != 4)
                .filter(distinctByKey(Person::getId))
                .collect(Collectors.toList());

        List<Person> elements = list.stream()
                .filter(person -> person.getLname().equalsIgnoreCase("Kolen"))
                .collect(Collectors.toList());
        if (elements.size() < 4) {
            elements.addAll(list.stream()
                    .filter(person -> person.getLname().equalsIgnoreCase("Kolen"))
                    .collect(Collectors.toList()));
        }
        while (elements.size() < 19) {
            System.out.println("Size is ============== " + elements.size() + " ========================");
            elements.addAll(list.stream()
                    .filter(person -> person.getLname().equalsIgnoreCase("Kolen")).limit(10)
                    .collect(Collectors.toList()));
        }

        // Let's verify distinct elements
        distinctElements.forEach(System.out::println);
        System.out.println("====================================================");
        elements.forEach(System.out::println);

        Stream<Integer> evenNumInfiniteStream = Stream.iterate(2, n -> n + 2);
        List<Integer> newList = evenNumInfiniteStream.filter(i -> i != 6).limit(10)
                .collect(Collectors.toList());
        System.out.println(newList);
        System.out.println("====================================================");
        for (int i = 0; newList.size() < 10; i++) {
            newList.add(i);
        }
        System.out.println(newList);
        newList.add(22);
        newList.add(12);
        System.out.println("New List" + newList);
        List<Integer> newList1 = new ArrayList<>(newList);
        newList1.add(126);
        newList.removeIf(distinctByKey(i -> i).negate());
        System.out.println(newList);
        System.out.println("New List Before - 1 -----" + newList1);
        newList1.removeIf(solrDocument -> newList.stream().anyMatch(sortedVisUniqueProperty -> sortedVisUniqueProperty.toString().equals(solrDocument.toString())));
        System.out.println("New List After - 1 -----" + newList1);
        //System.out.println();(newList.parallelStream().filter(distinctByKey(i -> i)).collect(Collectors.toList()));

        //System.out.println();(Pattern.compile("\\*alert\\*\\^['+()0-9]\\*alert\\*", Pattern.CASE_INSENSITIVE).matcher("submit'+alert(11279)+'").matches());
        //System.out.println();(Pattern.compile("-+()").matcher("submit'+alert(11279)+'$").matches());
        //System.out.println();(Pattern.compile("\\d", Pattern.CASE_INSENSITIVE).matcher("geeks1for2geeks3").matches());
        String text = "http://)jen'kov.6com+(";
        text = "sub\"mit'+ale;rt(11279)+'<script></<script>";
        Pattern pattern = Pattern.compile("[\\+\\(\\)\\'\";<>0-9]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            System.out.println("Found match at: "  + matcher.start() + " to " + matcher.end());
        }

        text = "+91-9822345654";
        Pattern mobilePattern = Pattern.compile("^((\\+)?(\\d{2}[-]))?(\\d{10}){1}?$");
        Matcher mobileMatcher = mobilePattern.matcher(text);
        System.out.println("Mobile No is " + mobileMatcher.matches());

        // make sure user didn't enter HTML along with our markup
        String escapedContent = StringEscapeUtils.escapeHtml4("bread\" & \"butter");
        System.out.println(escapedContent);
        String url = "https://securitytest.magicbricks.com/bricks/ajax/includeProjectContactWindow.json?pageName=projectContactFormIncludeNewJsp&pageType=html&id=5095587&contactType=project|contactNow|Adarsh%20Homes&dynamicCss=openInPop&propertyFromProject=&bedroomCode=&propertyType=%27%2Balert%283508%29%2B%27&psmName=Adarsh%20Homes&listingIds=&_=1591604094743";
        url = "%27%2Balert%283508%29%2B%27";
        String result = java.net.URLDecoder.decode(url, StandardCharsets.UTF_8.name());
        System.out.println(result);

        Matcher matcher1 = Pattern.compile("[\\+\\(\\)\\'\";<>0-9]", Pattern.CASE_INSENSITIVE).matcher("u+ndefined';alert(12604);'");
        while(matcher1.find()){
            System.out.println("-----------------------------Found match at: "  + matcher1.start() + " to " + matcher1.end());
        }

        String Str = new String("Welcome-to-Tutorialspoint.com");
        for (String retval: Str.split("-", 4)) {
            System.out.println(retval);
        }

        Random random = new Random();
        int randomWithNextInt = random.nextInt(3 - 1) + 1;
        System.out.println("Random number - " + randomWithNextInt);


        int randomWithThreadLocalRandomInARange = ThreadLocalRandom.current().nextInt(1, 3);
        System.out.println("Random number - " + randomWithThreadLocalRandomInARange);

        SplittableRandom splittableRandom = new SplittableRandom();
        int randomWithSplittableRandom = splittableRandom.nextInt(1, 3);
        System.out.println("Random number - " + randomWithSplittableRandom);
        for (int i = 0; i < 10; i++) {
            SplittableRandom splittableRandom1 = new SplittableRandom();
            System.out.println("Random Boolean" + i + " - " + splittableRandom1.nextBoolean());
        }

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        System.out.println("Map value is adding " + map.putIfAbsent("Rohit", 1));
        System.out.println("Map value is adding " + map.putIfAbsent("Rohit", 2));

        Person person = new Person(1, "Rohit", "Raj");
        Person person1 = new Person(2, "Rohit1", "Raj1");
        ArrayList personList = new ArrayList();
        personList.add(person);
        personList.add(person1);
        ObjectMapper oMapper = new ObjectMapper();
        TypeReference<List<LinkedHashMap<String, String>>> typeRef = new TypeReference<List<LinkedHashMap<String, String>>>() {};
        List<LinkedHashMap<String, String>> resultMap = oMapper.convertValue(personList, typeRef);
        System.out.println("====================" + resultMap);

        Assert.isInstanceOf(Integer.class, "11age", "Given data should be integer");
    }

    //Utility function
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> ObjectUtils.isEmpty(keyExtractor.apply(t)) || map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
        //return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}

//Model class
class Person {
    private final Integer id;
    private final String fname;
    private final String lname;
    public Person(Integer id, String fname, String lname) {
        super();
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }

    public Integer getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", fname=" + fname + ", lname=" + lname + "]";
    }
}

