package model;


public class People {
    private long cedula;
    private String ticket;

    //Es primera clase?
    private int first_class;

    //Hora de llegada
    private String arrival_time;

    //Millas acumuladas
    private int miles_earned;

    //Requiere atencion especial?
    private int special_attention;

    //Es de la tercera edad?
    private int elderly;


    //Datos añadidos:

    //Numero de maletas
    private int number_of_suitcases;

    //Nivel de membresia o fidelidad (1 - 5)
    private int membership_level;

    //Necesita atencion medica?
    private int medical_care;

    public People(long cedula, String ticket, int first_class) {
        this.cedula = cedula;
        this.ticket = ticket;
        this.first_class = first_class;
    }

    public void setFirstClassData(int miles_earned, int special_attention, int elderly, int number_of_suitcases, int membership_level, int medical_care) {
        this.miles_earned = miles_earned;
        this.special_attention = special_attention;
        this.elderly = elderly;
        this.number_of_suitcases = number_of_suitcases;
        this.membership_level = membership_level;
        this.medical_care = medical_care;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getFirst_class() {
        return first_class;
    }

    public void setFirst_class(int first_class) {
        this.first_class = first_class;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getMiles_earned() {
        return miles_earned;
    }

    public void setMiles_earned(int miles_earned) {
        this.miles_earned = miles_earned;
    }

    public int isSpecial_attention() {
        return special_attention;
    }

    public void setSpecial_attention(int special_attention) {
        this.special_attention = special_attention;
    }

    public int isElderly() {
        return elderly;
    }

    public void setElderly(int elderly) {
        this.elderly = elderly;
    }

    public int getNumber_of_suitcases() {
        return number_of_suitcases;
    }

    public void setNumber_of_suitcases(int number_of_suitcases) {
        this.number_of_suitcases = number_of_suitcases;
    }

    public int getMembership_level() {
        return membership_level;
    }

    public void setMembership_level(int membership_level) {
        this.membership_level = membership_level;
    }

    public int isMedical_care() {
        return medical_care;
    }

    public void setMedical_care(int medical_care) {
        this.medical_care = medical_care;
    }

    public int getSpecial_attention() {
        return special_attention;
    }

    public int getElderly() {
        return elderly;
    }

    public int getMedical_care() {
        return medical_care;
    }

    @Override
    public String toString() {
        if(first_class == 1) {
            return "People{" +
                    "cedula=" + cedula +
                    ", ticket='" + ticket + '\'' + '}'; /*+
                    ", first_class=" + first_class +
                    ", arrival_time='" + arrival_time + '\'' +
                    ", miles_earned=" + miles_earned +
                    ", special_attention=" + special_attention +
                    ", elderly=" + elderly +
                    ", number_of_suitcases=" + number_of_suitcases +
                    ", membership_level=" + membership_level +
                    ", medical_care=" + medical_care +*/

        }else{
            return "People{" +
                    "cedula=" + cedula +
                    ", ticket='" + ticket + '\'' +
                    ", first_class=" + first_class + "}";
        }
    }
}
