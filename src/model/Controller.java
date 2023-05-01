package model;

import java.util.*;

public class Controller{

    // Crear una tabla hash con un tamaño de 10
    public static Double hallway = 0.0;
    public static int state = 0;
    private HashTable<Long, People> table = new HashTable<>(10);
    private PriorityQueueMethod<Passenger> queueFirstClass = new PriorityQueueMethod<Passenger>();

    private PriorityQueueMethod<Passenger> queueForArrivalTime = new PriorityQueueMethod<Passenger>();

    private PriorityQueueMethod<Passenger> queueGlobal = new PriorityQueueMethod<Passenger>();

    private PriorityQueueMethod<Passenger> queueOutput = new PriorityQueueMethod<Passenger>();


    public void createPeople(long cedula, String ticket, int first_class, long key){
            table.put(key, new People(cedula, ticket, first_class));
    }

    public void setDataFirstClassPeople(long cedula, int miles_earned, int special_attention, int elderly, int number_of_suitcases, int membership_level, int medical_care){
        table.get(cedula).setFirstClassData(miles_earned, special_attention, elderly, number_of_suitcases, membership_level, medical_care);
    }

    public void setArrivalTimeTableHash(long cedula, String arrival_time){
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

    public void orderStandard(){
        for (Map<Long, People> bucket : table.getTable()) {
            for (Map.Entry<Long, People> entry : bucket.entrySet()) {
                Long key = entry.getKey();
                People value = entry.getValue();

                if(value.getFirst_class() == 0) {
                    queueForArrivalTime.insert(new Passenger(value));
                    queueGlobal.insert(new Passenger(value));
                }
            }
        }

    }

    public void orderFirstClass(){
        for (Map<Long, People> bucket : table.getTable()) {
            for (Map.Entry<Long, People> entry : bucket.entrySet()) {
                Long key = entry.getKey();
                People value = entry.getValue();

                if(value.getFirst_class() == 1) {
                    queueFirstClass.insert(new Passenger(value));
                    queueGlobal.insert(new Passenger(value));
                }
            }
        }


    }

    public void getSortingOutput(){
        PriorityQueueMethod<Passenger> sectionTemp = new PriorityQueueMethod<Passenger>();
        state=2;
        //Obtener la maxima seccion
        int maxSection = 0; // Inicializar la variable con un valor que sea menor que cualquier sección posible en la lista

        for (int i = 0; i < queueGlobal.size(); i++) {
            int section = queueGlobal.get(i).getSection();
            if (section > maxSection) {
                maxSection = section;
            }
        }


        //itera por el numero maximo de seccioes
        for(int j = 0; j < ((int) maxSection/10); j++) {



            //se deben insertar al revez
            for (int i = queueGlobal.size() - 1; i >= 0; i--) {

                if ((int) queueGlobal.get(i).getSection() / 10 == j) {
                    sectionTemp.insert(queueGlobal.remove());
                }

            }


            //asignar a seccion 1
            Stack<Passenger> section_1 = new Stack<>();
            for (int i = 0; i < sectionTemp.size() / 2; i++) {
                section_1.push(sectionTemp.get(i));
            }

            Queue<Passenger> section_2 = new LinkedList<>();
            for (int i = (int) Math.ceil(sectionTemp.size() / 2); i < sectionTemp.size(); i++) {
                section_2.add(sectionTemp.get(i));
            }

            //almacenar en la lista de salida
            while (!section_1.isEmpty() || !section_2.isEmpty()) {
                if (section_1.isEmpty()) {
                    queueOutput.insert(section_2.remove());
                } else if (section_2.isEmpty()) {
                    queueOutput.insert(section_1.pop());
                } else if (section_2.peek().getTime() > section_1.peek().getTime()) {
                    queueOutput.insert(section_2.remove());
                } else {
                    queueOutput.insert(section_1.pop());

                }
            }

            //Limpiar la seccion temporal
            while (!sectionTemp.isEmpty()) {
                sectionTemp.remove();
            }

        }

        queueOutput.printQueue();
        state = 0;
    }

    public void printOrderInput(){
        System.out.println("Orden de entrada................ ");
        queueGlobal.printQueue();

        /*System.out.println("Pasajeros de Primera Clase: ");



        System.out.println(" ");
        System.out.println("Pasajeros Standard: ");

        queueForArrivalTime.printQueue();*/

    }
}