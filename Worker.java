import com.company.Main;
import java.util.ArrayList;

public class Worker{
    private String name;
    private ArrayList<Workday> workdays;
    private int pay;

    public Worker(String name, int pay) {
        this.name = name;
        this.pay = pay;
        ArrayList<Worker> workdays = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Workday> getWorkdays() {
        return workdays;
    }

    public void setWorkdays(ArrayList<Workday> workdays) {
        this.workdays = workdays;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }


    int workingDays() {
        int workingDays = 0;
        for (int i = 0; i < workdays.size(); i++) {
            if (workdays.get(i).workTime() > 0){
                workingDays ++;
            }
        }
        return workingDays;
    }
    int Salary(){
        int sum = 0;
        for (int i = 0; i < workdays.size(); i++) {
            sum += ((this.getWorkdays().get(i).workTime() * pay) + ((this.getWorkdays().get(i).extraHours() * pay) * 0.25));
        }
        return sum;
    }
    Worker diligent(Worker other) {
        int i;
        Worker bob = new Worker("bob", 45);
        for (i = 0; i < workdays.size(); i++) {

            if (other.workdays.get(i).workTime() > this.workdays.get(i).workTime()) {
                return other;
            }
        }
    return bob;
    }
}