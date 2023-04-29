package ui;

import java.io.*;

import java.util.*;

import model.Controller;

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
        FileInputStream inputStream = new FileInputStream("C:\\Users\\sacal\\OneDrive - Universidad Icesi (@icesi.edu.co)\\Discretas I\\airport-discrete-structures\\src\\test\\dataPeople.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
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

        reader.close();
        ct.printTable();
    }
}