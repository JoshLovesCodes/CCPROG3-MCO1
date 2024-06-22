public class Date {
    private int year, month, day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    } 

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public void setYear(int newYear) {
        this.year = newYear;
    }
    
    public void setMonth(int newMonth) {
        this.month = newMonth;
    }
    
    public void setDay(int newDay) {
        this.year = newDay;
    }
}