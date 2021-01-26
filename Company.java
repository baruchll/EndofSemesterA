import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Company{
    String name;
    ArrayList<Worker> allWorkers;
    ArrayList<Integer> sales;

    public Company(String name){
        this.name = name;
        List <Worker>allWorkers = new ArrayList<>();
       List <Integer>sales = new ArrayList<>();
      ArrayList<Worker> hardestWorkers = (ArrayList<Worker>) ((ArrayList<Worker>) allWorkers).clone();

    }

    int totalPayments(){
        int sum = 0;
        for (int i = 0; i < allWorkers.size();i++){
            sum += allWorkers.get(i).Salary();
        }
        return sum;
    }


    int totalEarnings(){
        int sum = 0;
        for (int i = 0; i < sales.size(); i++) {
            sum += sales.get(i);
        }
        return sum;
    }


    Worker workedMost() {
        Worker best= allWorkers.get(0);
        for (int i = 0; i < allWorkers.size(); i++) {
            if (best.getWorkdays().get(0).workTime() < this.allWorkers.get(i).getWorkdays().get(i).workTime()){
                best = allWorkers.get(i);
            }
        }
        return best;
        }


    void addWorker(Worker w){
        allWorkers.add(new Worker("john", 57));
    }


    void swap(Object x, Object y){
        Object temp = x;
        x = y;
        y = temp;
    }


    void crisis(){
        ArrayList<Worker> hardestWorkers = new ArrayList<>();
        hardestWorkers.addAll(allWorkers);
        ArrayList<Worker> mostPayed = new ArrayList<>();
        mostPayed.addAll(allWorkers);

        //hardest workers
        for (int i = 1; i <hardestWorkers.size() - 1;  i++) {
            for (int j = 0; j < hardestWorkers.size(); j++) {
                Worker first = hardestWorkers.get(j - 1);
                Worker second = hardestWorkers.get(j);
            
            if (first.getWorkdays().get(j).extraHours() > second.getWorkdays().get(j).extraHours()){
                swap(j - 1, j);
                }
            } 
        }
        //most Payed
        for (int i = 1; i < mostPayed.size() - 1; i++) {
            for (int j = 0; j < mostPayed.size(); j++) {
                Worker first = hardestWorkers.get(j - 1);
                Worker second = hardestWorkers.get(j);

                if (first.getPay() > second.getPay()){
                    swap(j - 1, j);
                }
            }
        }




        for (int i = 0; i < (mostPayed.size() / 4) * 3; i++) {
            mostPayed.remove(i);
        }
        for (int i = 0; i < (hardestWorkers.size() / 4) * 3; i++) {
            hardestWorkers.remove(i);
        }
        ArrayList<Worker> finalList = new ArrayList<>();
        Set<Worker> set = new HashSet<>();
        set.addAll(hardestWorkers);
        set.addAll(mostPayed);
        finalList.addAll(set);

        for (int i = 0; i < finalList.size(); i++) {
            if (allWorkers.contains(finalList.get(i))){
                allWorkers.remove(finalList.get(i));
            }
        }
    }
}




