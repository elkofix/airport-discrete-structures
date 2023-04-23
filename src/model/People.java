package model;


public class People {
    private String name;
    private String ticket;

    //Es primera clase?
    private Boolean first_class;

    //Hora de llegada
    private String arrival_time;

    //Millas acumuladas
    private int miles_earned;

    //Requiere atencion especial?
    private boolean special_attention;

    //Es de la tercera edad?
    private boolean elderly;


    //Datos añadidos:

    //Numero de maletas
    private int number_of_suitcases;

    //Nivel de membresia o fidelidad (1 - 5)
    private int membership_level;

    //Necesita atencion medica?
    private boolean medical_care;

    public People(String name, String ticket, Boolean first_class) {
        this.name = name;
        this.ticket = ticket;
        this.first_class = first_class;
    }

    public void setFirstClassData(int miles_earned, boolean special_attention, boolean elderly, int number_of_suitcases, int membership_level, boolean medical_care) {
        this.miles_earned = miles_earned;
        this.special_attention = special_attention;
        this.elderly = elderly;
        this.number_of_suitcases = number_of_suitcases;
        this.membership_level = membership_level;
        this.medical_care = medical_care;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Boolean getFirst_class() {
        return first_class;
    }

    public void setFirst_class(Boolean first_class) {
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

    public boolean isSpecial_attention() {
        return special_attention;
    }

    public void setSpecial_attention(boolean special_attention) {
        this.special_attention = special_attention;
    }

    public boolean isElderly() {
        return elderly;
    }

    public void setElderly(boolean elderly) {
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

    public boolean isMedical_care() {
        return medical_care;
    }

    public void setMedical_care(boolean medical_care) {
        this.medical_care = medical_care;
    }
}
