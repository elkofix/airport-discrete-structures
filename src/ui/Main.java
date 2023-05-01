package ui;

import java.io.*;

import java.util.*;

import model.*;




public class Main{
    public static void main(String args[]) throws IOException {
        Controller ct = new Controller();

        long cedula;
        String ticket;
        int first_class;
        int miles_earned;
        int special_attention;
        int elderly;
        int number_of_suitcases;
        int membership_level;
        int medical_care;


        //Casos de prueba
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\dataPeople.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Controller.hallway = (double)Integer.parseInt(reader.readLine().trim())+0.5;
        int n = Integer.parseInt(reader.readLine().trim());

        for(int i = 0; i < n; i++) {

            cedula = Integer.parseInt(reader.readLine().trim());
            ticket = reader.readLine().trim();

            first_class = Integer.parseInt(reader.readLine().trim());


            //Crear persona
            ct.createPeople(cedula, ticket, first_class, cedula);

            //Si es de primera clase se almacenan los demas datos
            if (first_class == 1) {

                miles_earned = Integer.parseInt(reader.readLine().trim());

                special_attention = Integer.parseInt(reader.readLine().trim());

                elderly = Integer.parseInt(reader.readLine().trim());

                number_of_suitcases = Integer.parseInt(reader.readLine().trim());

                membership_level = Integer.parseInt(reader.readLine().trim());

                medical_care = Integer.parseInt(reader.readLine().trim());

                ct.setDataFirstClassPeople(cedula, miles_earned, special_attention, elderly, number_of_suitcases, membership_level, medical_care);

            }

        }

        //Asignar hora de llegada
        for(int i = 0; i < n; i++){
            cedula = Integer.parseInt(reader.readLine().trim());
            String arrival_time = reader.readLine().trim();

            ct.setArrivalTimeTableHash(cedula, arrival_time);
        }

        //Crear arrgelo para ordenar por primera clase
        ct.orderFirstClass();

        //Crear arreglo par ordenar los usuarios standard
        ct.orderStandard();

        while (true){
            System.out.println("[1] Ver orden de entrada: ");
            System.out.println("[2] Ver orden de salida: ");
            System.out.println("[0] Salir: \n");
            int option = Integer.parseInt(reader.readLine().trim());

            if(option == 1){
                ct.printOrderInput();
                System.out.println("\n");
            }else if(option == 2){
                System.out.println("Orden de salida:\n");
                ct.getSortingOutput();
            }else{
                System.out.println("Saliendo... \n");
                break;
            }

        }

    }
}