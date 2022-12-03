package com.example;

public class Injector {
    public static void main(String[] args) throws Exception {
        String[] sex = {"Самец","Самка"};
        Predator feline = new Feline();
        //Передача в класс Lion экземпляра с готовым объектом класса Feline
        Lion lion = new Lion(feline, sex[1]);
    }
}