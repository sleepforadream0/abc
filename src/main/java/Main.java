import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {

    private int size;
    private final Integer[] elementData;

    private int initialSize;

    public Main(int initialSize) {
        this.initialSize = initialSize;
        elementData = new Integer[initialSize];
    }

    EvenIterator evenIterator() {
        return new EvenIterator();
    }

    void add(Integer element) {
        elementData[size] = element;
        size++;
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }

    public class EvenIterator implements Iterator<Integer> {
        private int cursor = 0;


        @Override
        public Integer next() {
            for (int i = cursor; i < size; i++) {
                cursor++;
                if (elementData[i] % 2 == 0) {
                    return elementData[i];
                }
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            return elementData[cursor + 1] != null;
        }

        @Override
        public void remove() {
            elementData[cursor] = null;
        }
    }

    public static class Employee {
        String department;

        public String getDepartment() {
            return department;
        }

        Employee(String department) {
            this.department = department;
        }
    }

    List<Integer> stringToList(List<String> string, Function<String, Integer> function) {
        return string.stream().map(function).collect(Collectors.toList());
    }

    public static class B {

    }

    public static void print1(List<? extends B> list) {
//        list.add(new B());
//        System.out.println(list.get(0).print());
    }

    public static void print2(List<? super B> list) {
        list.add(new B());
//        System.out.println(list.get(0).print());
    }

    class Solution {

    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Department1");
        Employee employee2 = new Employee("Department2");
        Employee employee3 = new Employee("Department3");
        Employee employee4 = new Employee("Department2");
        Employee employee5 = new Employee("Department3");
        Employee employee6 = new Employee("Department3");
        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5, employee6);
        Map<String, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(x -> x.getDepartment()));
        System.out.println(map);
    }
}

