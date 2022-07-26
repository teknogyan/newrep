import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
// the Main Class
public class SpaceChallenge {

    public static void main(String[] args) throws FileNotFoundException {
        File file1= new File("phase-1.txt"); // loading the text file for Phase 1
        File file2= new File("phase-2.txt"); // loading the text file for Phase 1
        Simulation simulation=new Simulation();
        ArrayList<Item> itemArrayList1= simulation.loadItems(file1);
        ArrayList<Item> itemArrayList2= simulation.loadItems(file2);
//        for (Item item:itemArrayList1) {
//            System.out.println(item.getName()+" WEIGHS "+ Integer.toString(item.getWeight()));
//        }
//        System.out.println("\n Second Arraylist:");
//        for (Item item:itemArrayList2) {
//            System.out.println(item.getName()+" WEIGHS "+ Integer.toString(item.getWeight()));
//        }
        ArrayList<U1> u1ArrayList=simulation.loadU1(itemArrayList1);
        System.out.println(u1ArrayList.size()+" U1 Rockets");

        ArrayList<U2> u2ArrayList=simulation.loadU2(itemArrayList2);
        System.out.println(u2ArrayList.size()+" U2 Rockets");

        int finalCost=simulation.runSimulation(u1ArrayList,u2ArrayList);
        System.out.println("Final budget is: $"+ finalCost+" Million");
    }
}