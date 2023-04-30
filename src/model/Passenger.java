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
        int result;

        if(first_class == 1){
            int milesComparison = Integer.compare(this.miles_earned, other.miles_earned);
            if (milesComparison != 0) {
                return milesComparison;
            }

            // Luego comparamos por atención especial
            int attentionComparison = Integer.compare(this.special_attention, other.special_attention);
            if (attentionComparison != 0) {
                return attentionComparison;
            }

            // Luego comparamos por edad avanzada
            int elderlyComparison = Integer.compare(this.elderly, other.elderly);
            if (elderlyComparison != 0) {
                return elderlyComparison;
            }

            // Luego comparamos por cantidad de maletas
            int suitcaseComparison = Integer.compare(this.number_of_suitcases, other.number_of_suitcases);
            if (suitcaseComparison != 0) {
                return suitcaseComparison;
            }

            // Luego comparamos por nivel de membresía
            int membershipComparison = Integer.compare(this.membership_level, other.membership_level);
            if (membershipComparison != 0) {
                return membershipComparison;
            }

            // Luego comparamos por atención médica
            int medicalComparison = Integer.compare(this.medical_care, other.medical_care);
            if (medicalComparison != 0) {
                return medicalComparison;
            }

            // Finalmente comparamos por el ticket
            int ticketComparison = this.ticket.compareTo(other.ticket);
            if (ticketComparison != 0) {
                return ticketComparison;
            }

        }

        //Comparar por tiempo

        LocalTime hour = LocalTime.parse(arrival_time);
        int time = hour.toSecondOfDay();

        LocalTime otherHour = LocalTime.parse(other.arrival_time);
        int otherTime = otherHour.toSecondOfDay();

        result = Integer.compare(time, otherTime);
        if (result != 0) {
            return result;
        }

        // Si las horas de llegada son iguales, comparamos por la letra de la fila del ticket
        String thisRowLetter = this.ticket.substring(0, 1);
        String otherRowLetter = other.ticket.substring(0, 1);
        int rowLetterComparison = thisRowLetter.compareTo(otherRowLetter);
        if (rowLetterComparison != 0) {
            return rowLetterComparison;
        }

        // Si las letras de la fila son iguales, comparamos por el número de fila del ticket
        int thisRowNumber = Integer.parseInt(this.ticket.substring(1));
        int otherRowNumber = Integer.parseInt(other.ticket.substring(1));
        int rowNumberComparison = Integer.compare(thisRowNumber, otherRowNumber);
        if (rowNumberComparison != 0) {
            return rowNumberComparison;
        }

        // Si las filas son iguales, comparamos por la letra de la columna del ticket
        String thisColumn = this.ticket.split("")[0];
        String otherColumn = other.ticket.split("")[0];
        int columnComparison = thisColumn.compareTo(otherColumn);
        if (columnComparison != 0) {
            return columnComparison;
        }

        return 0;

    }

    public int getTotalPriority() {
        return miles_earned + special_attention + elderly + number_of_suitcases + membership_level + medical_care;
    }

    @Override
    public String toString() {
        if(first_class == 1) {
            return
                    "cedula=" + cedula +
                    ", ticket='" + ticket + '\''; /*+
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
                    ", first_class=" + getArrival_time() ;
        }

    }
}
