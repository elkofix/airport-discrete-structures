package model;
import java.time.LocalTime;
public class Passenger implements Comparable<Passenger> {


    private long cedula;
    private String ticket;

    //Es primera clase?
    private int first_class;

    private String arrival_time;
    private int miles_earned;
    private int special_attention;
    private int elderly;
    private int number_of_suitcases;
    private int membership_level;
    private int medical_care;
    private double total_priority;

    public Passenger(People people) {
        this.cedula = people.getCedula();
        this.ticket = people.getTicket();
        this.first_class = people.getFirst_class();
        this.arrival_time = people.getArrival_time();
        this.miles_earned = people.getMiles_earned();
        this.special_attention = people.getSpecial_attention();
        this.elderly = people.getElderly();
        this.number_of_suitcases = people.getNumber_of_suitcases();
        this.membership_level = people.getMembership_level();
        this.medical_care = people.getMedical_care();
        this.ticket = people.getTicket();
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

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getMilesEarned() {
        return miles_earned;
    }

    public int getSpecialAttention() {
        return special_attention;
    }

    public int getElderly() {
        return elderly;
    }

    public int getNumberOfSuitcases() {
        return number_of_suitcases;
    }

    public int getMembershipLevel() {
        return membership_level;
    }

    public int getMedicalCare() {
        return medical_care;
    }

    @Override
    public int compareTo(Passenger other) {

        int section_ticket = Integer.parseInt(this.ticket.substring(1));

        int other_section_ticket = Integer.parseInt(other.ticket.substring(1));
        //Comparar por tiempo

        LocalTime hour = LocalTime.parse(arrival_time);
        double time = ((double) 1000 / hour.toSecondOfDay());


        LocalTime otherHour = LocalTime.parse(other.arrival_time);
        double otherTime = ((double) 1000 / otherHour.toSecondOfDay());


        this.total_priority =  (time*1000) + (section_ticket * 2000) + (this.first_class * 1000) + (this.miles_earned * 10) + (this.special_attention * 1000) + (this.elderly * 1000) + (this.number_of_suitcases * 5) + (this.membership_level * 500) + (this.medical_care * 1000);

        double otherTotalPriority = (otherTime*1000) + (other_section_ticket * 2000) + (other.first_class * 1000) + (other.miles_earned * 10) + (other.special_attention * 1000) + (other.elderly * 1000) + (other.number_of_suitcases * 5) + (other.membership_level * 500) + (other.medical_care * 1000);


        int totalPriorityComparison = Double.compare(this.total_priority, otherTotalPriority);

        if (totalPriorityComparison != 0) {
            return totalPriorityComparison;
        }else {
            return 0;
        }

    }

    public double getTotalPriority() {
        return this.total_priority;
    }

    @Override
    public String toString() {
        if(first_class == 1) {
            return
                    "cedula=" + cedula +
                    ", ticket='" + ticket +
                            ", Total prioridad='" + this.total_priority +
                            ", arrival_time='" + getArrival_time() + '\''; /*+
                    ", first_class=" + first_class +
                    ", arrival_time='" + getArrival_time() + '\'' +
                    ", miles_earned=" + miles_earned +
                    ", special_attention=" + special_attention +
                    ", elderly=" + elderly +
                    ", number_of_suitcases=" + number_of_suitcases +
                    ", membership_level=" + membership_level +
                    ", medical_care=" + medical_care +*/

        }else{
            return
                    "cedula=" + cedula +
                    ", ticket='" + ticket + '\'' +
                            ", Total prioridad='" + this.total_priority +
                    ", first_class=" + getArrival_time() ;
        }

    }
}
