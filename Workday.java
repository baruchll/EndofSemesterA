public class Workday {
    private Date date;
    private Time start;
    private Time end;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public Workday(Date date){
        this.date = date;
        this.start = new Time(9,0);
        this.end = new Time(17, 0);

    }
    public double workTime(){
        return  (this.end.hour - this.start.hour) + (this.end.minute - this.start.minute) / 60;
    }
    boolean isExtra(){
        if (workTime() >= 8) {
            return true;
        }
        else {
            return false;
        }
    }
    public double extraHours(){
        double sum = 0;
        if (isExtra() == true){
            sum += 8 - workTime();
        }
        return sum;
    }
}
