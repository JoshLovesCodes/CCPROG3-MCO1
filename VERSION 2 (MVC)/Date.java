public class Date {
    private int year, month, day, hour, minute;

    public Date(int year, int month, int day, int hour, int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    } 

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = 0;
        this.minute = 0;
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

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setYear(int newYear) {
        this.year = newYear;
    }
    
    public void setMonth(int newMonth) {
        this.month = newMonth;
    }
    
    public void setDay(int newDay) {
        this.day = newDay;
    }

    public void setHour(int newHour) {
        this.hour = newHour;
    }

    public void setMinute(int newMinute) {
        this.minute = newMinute;
    }

    public String identifyMonth(int month) {
        switch(month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }

        return null;
    }

    public static boolean isAfter(Date toBeChecked, Date toCompareTo) {
        if(toBeChecked.getYear() > toCompareTo.getYear()) {
            return true;
        }
        else if(toBeChecked.getYear() == toCompareTo.getYear()) {
            if(toBeChecked.getMonth() > toCompareTo.getMonth()) {
                return true;
            }
            else if(toBeChecked.getMonth() == toCompareTo.getMonth()) {
                if(toBeChecked.getDay() > toCompareTo.getDay())
                    return true;
            }
        }

        return false;
    }
}