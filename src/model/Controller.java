package model;

public class Controller{

    // Crear una tabla hash con un tamaño de 10
    private HashTable<Long, People> table = new HashTable<>(10);




    public void createPeople(long cedula, String ticket, int first_class, long key){
            table.put(key, new People(cedula, ticket, first_class));
    }

    public void setDataFirstClassPeople(long cedula, int miles_earned, int special_attention, int elderly, int number_of_suitcases, int membership_level, int medical_care){
        table.get(cedula).setFirstClassData(miles_earned, special_attention, elderly, number_of_suitcases, membership_level, medical_care);
    }
    public void printTable(){
        table.printTable();
    }
}