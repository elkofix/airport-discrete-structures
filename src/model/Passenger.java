package model;
import java.time.LocalTime;
public class Passenger implements Comparable<Passenger> {


    private long cedula;
    private String ticket;

    private int section;

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

    private double time;

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

        LocalTime hour = LocalTime.parse(arrival_time);
        double time = ((double) 1000 / hour.toSecondOfDay());

    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public Passenger(long cedula, String ticket, int first_class, String arrival_time, int miles_earned, int special_attention, int elderly, int number_of_suitcases, int  membership_level, int medical_care) {
        this.cedula = cedula;
        this.ticket = ticket;
        this.first_class = first_class;
        this.arrival_time = arrival_time;
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
        this.section = (Integer.parseInt(this.ticket.substring(1)));

        int other_section_ticket = Integer.parseInt(other.ticket.substring(1));
        //Comparar por tiempo

        LocalTime hour = LocalTime.parse(arrival_time);
        double time = ((double) 1000 / hour.toSecondOfDay());


        LocalTime otherHour = LocalTime.parse(other.arrival_time);
        double otherTime = ((double) 1000 / otherHour.toSecondOfDay());
        if(Controller.state==0){

            this.total_priority =  (time*1000) + (this.section * 2000) + (this.first_class * 100000) + (this.miles_earned * 10) + (this.special_attention * 1000) + (this.elderly * 1000) + (this.number_of_suitcases * 5) + (this.membership_level * 500) + (this.medical_care * 1000);

            double otherTotalPriority = (otherTime*1000) + (other_section_ticket * 2000) + (other.first_class * 100000) + (other.miles_earned * 10) + (other.special_attention * 1000) + (other.elderly * 1000) + (other.number_of_suitcases * 5) + (other.membership_level * 500) + (other.medical_care * 1000);


            int totalPriorityComparison = Double.compare(this.total_priority, otherTotalPriority);

            if (totalPriorityComparison != 0) {
                return totalPriorityComparison;
            }else {
                return 0;
            }
        }else{
            double section_seat = (double) (Integer.parseInt(this.ticket.substring(2)));

            double other_section_seat= (double) Integer.parseInt(other.ticket.substring(2));
            this.total_priority = (double) (1000/this.section)*100;
            total_priority += 100/Math.abs(Controller.hallway-section_seat);

            double otherTotalPriority = (double)(1000/other_section_ticket)*100;
            otherTotalPriority+=  100/Math.abs(Controller.hallway-other_section_seat);
            int totalPriorityComparison = Double.compare(this.total_priority, otherTotalPriority);

            if (totalPriorityComparison == 0) {
                return totalPriorityComparison+Double.compare(this.time, otherTime);
            }else {
                return totalPriorityComparison;
            }
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
                            ", first_class=" + first_class +
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
                            ", first_class=" + first_class +
                    ", arrival_time=" + getArrival_time() ;
        }

    }
}
