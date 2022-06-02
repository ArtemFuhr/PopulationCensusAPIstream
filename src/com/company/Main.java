package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String > names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        System.out.println("Количество несовершеннолетних: " + persons.stream()
                .filter(x -> x.getAge() < 18)
                .count());

        System.out.println("Список призывников: " + persons.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge() < 27 && x.getSex().equals(Sex.MAN))
                .map(Person::getFamily)
                .collect(Collectors.toList()));

        System.out.println(persons.stream()
                .filter(x -> x.getAge() >= 18 && x.getAge() < 60 && x.getSex().equals(Sex.WOMAN) ||
                x.getAge() >=18 && x.getAge() < 65 && x.getSex().equals(Sex.MAN))
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList())


        );
    }
}
