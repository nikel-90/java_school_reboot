package ru.sber.javaschool.homework.hw2.example;

import java.io.Serializable;

public class Program {

    public static void main(String[] args) {
        Person sam = new Employee("Sam", "Oracle");
        sam.display();
        Person bob = new Client("Bob", "DeutscheBank", 3000);
        bob.display();
    }
}

// абстрактный класс человека
abstract class Person implements Serializable, Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public Person(String name) {
        this.name = name;
    }

    abstract void display();
}

// служащий некоторой компании
class Employee extends Person {

    private String company;

    public Employee(String name, String company) {

        super(name);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void display() {
        System.out.printf("Employee %s works in %s \n", super.getName(), company);
    }
}

// класс клиента банка
class Client extends Person {

    private int sum; // Переменная для хранения суммы на счете
    private String bank;

    public Client(String name, String bank, int sum) {

        super(name);
        this.bank = bank;
        this.sum = sum;
    }

    public void display() {

        System.out.printf("Client %s has account in %s \n", super.getName(), bank);
    }

    public String getBank() {
        return bank;
    }

    public int getSum() {
        return sum;
    }
}