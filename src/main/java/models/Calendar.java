package models;

// POJO
public class Calendar {
    private String fromDate;
    private String toDate;

    public Calendar(String fromDate, String toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public String getFromDate() {
        return fromDate;
    }

    public String getToDate() {
        return toDate;
    }
}
