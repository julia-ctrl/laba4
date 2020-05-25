package com.lab4;

import java.util.ArrayList;

public abstract class Vehicle<T> {

    private int numOfSeats;

    public Vehicle(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public ArrayList<T> passengers = new ArrayList<>();

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public boolean addPerson(T person) {
        if (passengers.size() >= numOfSeats || passengers.contains(person)) {
            System.out.println("There is no seats left or this person is already in the Vehicle");
            return false;
        } else {
            System.out.println(((Person)person).getName() + " is now in the Vehicle");
            passengers.add(person);
            return true;
        }
    }

    public int countPassengers() {
        return this.passengers.size();
    }

    public boolean removePerson(T person) {
        if(passengers.contains(person)) {
            System.out.println("Passenger " + ((Person)person).getName() +" left the Vehicle");
            return true;
        } else {
            System.out.println("There is no such person in this vehicle");
            return false;
        }
    }

    public int countFreePlaces() {
        return numOfSeats - passengers.size();
    }
}


