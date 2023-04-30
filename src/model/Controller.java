package model;

import java.util.*;

public class Controller{

    // Crear una tabla hash con un tamaño de 10
    private HashTable<Long, People> table = new HashTable<>(10);
    private PriorityQueueMethod<Passenger> queueFirstClass = new PriorityQueueMethod<Passenger>();

    private PriorityQueueMethod<Passenger> queueForArrivalTime = new PriorityQueueMethod<Passenger>();


    public void createPeople(long cedula, String ticket, int first_class, long key){
            table.put(key, new People(cedula, ticket, first_class));
    }

    public void setDataFirstClassPeople(long cedula, int miles_earned, int special_attention, int elderly, int number_of_suitcases, int membership_level, int medical_care){
        table.get(cedula).setFirstClassData(miles_earned, special_attention, elderly, number_of_suitcases, membership_level, medical_care);
    }

    public void setArrivalTimeTableHash(long cedula, int arrival_time){
        table.get(cedula).setArrival_time(arrival_time);
    }


    public void printTable(){
        for (Map<Long, People> bucket : table.getTable()) {
            for (Map.Entry<Long, People> entry : bucket.entrySet()) {
                Long key = entry.getKey();
                People value = entry.getValue();

                System.out.println(key + " -> " + value);
            }
        }



    }

    public void orderForArrivalTime(){
        for (Map<Long, People> bucket : table.getTable()) {
            for (Map.Entry<Long, People> entry : bucket.entrySet()) {
                Long key = entry.getKey();
                People value = entry.getValue();

                if(value.getFirst_class() == 0) {
                    queueForArrivalTime.insert(new Passenger(value));
                }
            }
        }

        while (!queueForArrivalTime.isEmpty()) {
            System.out.println(queueForArrivalTime.remove());
        }

    }

    public void orderFirstClass(){
        for (Map<Long, People> bucket : table.getTable()) {
            for (Map.Entry<Long, People> entry : bucket.entrySet()) {
                Long key = entry.getKey();
                People value = entry.getValue();

                if(value.getFirst_class() == 1) {
                    queueFirstClass.insert(new Passenger(value));
                }
            }
        }

        while (!queueFirstClass.isEmpty()) {
            System.out.println(queueFirstClass.remove());
        }
    }
}