package com.lab4;

import java.util.ArrayList;
import java.util.List;

public class Road<T> {
    public static List<Vehicle> carsInRoad = new ArrayList<>();

    public static void main(String[] args) {

        // Додаємо пожежних
        Fireman fireman = new Fireman("Andrew");
        Fireman fireman1 = new Fireman("Mark");
        Fireman fireman2 = new Fireman("Bob");
        Fireman fireman3 = new Fireman("Charlie");

        // Додаємо поліцейських
        Policeman policeman = new Policeman("Johny");
        Policeman policeman1 = new Policeman("Tim");
        Policeman policeman2 = new Policeman("Chad");
        Policeman policeman3 = new Policeman("Irakli");

         // Додаємо звичайних пасажирів
        Person person = new Person("Ivan");
        Person person1 = new Person("Susan");
        Person person2 = new Person("Mary");
        Person person3 = new Person("Mike");

        // Створюємо таксі та додаємо туди пасажирів 2 звичайних
        // та одного пожежного(Таксі може перевозити всіх) Макс кількість місць: 3
        Taxi taxi = new Taxi();
        addCarToRoad(taxi);
        System.out.println("Taxi number of seats: " + taxi.getNumOfSeats());
        addPassenger(taxi, person);
        addPassenger(taxi, person);
        addPassenger(taxi, fireman);
        addPassenger(taxi, policeman);
        addPassenger(taxi, person1);




        // Людина покинула таксі
        taxi.removePerson(person);

        // Ніхто не покинув Таксі тому що цієї людини немає в данному таксі
        taxi.removePerson(fireman2);


        //Створюємо пожежну машину та додаємо туди пасажирів(пожежних) якщо спробуємо
        // неможливо додати звичайних пасажирів або ж поліцейських
        FireCar fireCar = new FireCar();
        carsInRoad.add(fireCar);

        // неможливо додоти тому що пасажир не посежник
       // fireCar.addPerson(person3)

        // Цей пассажир знаходиться в таксі тому ми не можемо його додати сюди
        addPassenger(fireCar, fireman);

        addPassenger(fireCar, fireman1);
        addPassenger(fireCar, fireman2);
        addPassenger(fireCar, fireman3);

        System.out.println("Number of free places in the FireCar: " + fireCar.countFreePlaces());

        Bus bus = new Bus();
        carsInRoad.add(bus);
        addPassenger(bus, policeman1);
        addPassenger(bus, policeman2);
        addPassenger(bus, policeman3);
        addPassenger(bus, person2);
        addPassenger(bus, person3);

        System.out.println("Number of passengers on the road:" + getCountOfHumans());
    }

    public static int getCountOfHumans() {
        int a = 0;
        for(Vehicle v : carsInRoad) {
            a += v.countPassengers();
        }
        return a;
    }

    public static void addCarToRoad(Vehicle v) {
        if(carsInRoad.contains(v)) {
            System.out.println("This Vehicle is already on the road.");
        } else {
            carsInRoad.add(v);
        }
    }

    public static boolean addPassenger(Vehicle vehicle, Person person) {
            for(Vehicle v : carsInRoad) {
                if(v.passengers.contains(person)) {
                    System.out.println("This person is already in the vehicle(may be in different then this)");
                    return false;
                }
                }
            vehicle.addPerson(person);
            return true;
            }

}
