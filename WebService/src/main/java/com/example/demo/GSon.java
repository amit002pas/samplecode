package com.example.demo;

import com.google.gson.Gson;

class Car {
    private String manufacturer;
    private String model;
    private Double capacity;
    private boolean accident;

    private Car() {
    }

    public Car(String manufacturer, String model, Double capacity, boolean accident) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.capacity = capacity;
        this.accident = accident;
    }

    @Override
    public String toString() {
        return("Manufacturer: " + manufacturer + ", " + "Model: " + model + ", " + "Capacity: " + capacity + ", " + "Accident: " + accident);
    }
}

 class Person {
    private String name;
    private String surname;
    private Car cars;
    private int phone;
    private transient int age;

    private Person() {
    }

    public Person(String name, String surname, int phone, int age, Car cars) {
        this.name = name;
        this.surname = surname;
        this.cars = cars;
        this.phone = phone;
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Name: " + name + " " + surname + "\n");
        sb.append("Phone: " + phone + "\n");
        sb.append("Age: " + age + "\n");

        int i = 0;
        
            sb.append("Car " + i + ": " + cars + "\n");
        

        return sb.toString();
    }
}



public class GSon {
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Gson gson = new Gson();
		Car audi = new Car("Audi", "A4", 1.8, false);
		//Car skoda = new Car("Škoda", "Octavia", 2.0, true);
		Car cars = audi;
		Person johnDoe = new Person("John", "Doe", 245987453, 35, cars);
		System.out.println(gson.toJson(johnDoe));

	}

}
