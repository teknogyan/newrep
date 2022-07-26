import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    private int failedLandings=0;
    public ArrayList<Item> loadItems (File file) throws FileNotFoundException {
        Scanner scanner=new Scanner(file);
        /* itemName string is of length two to store the name and weight
        to be added to the Item object*/
        String[] itemName= new String[2];
        ArrayList<Item> arrListItems= new ArrayList<>(); // this ArrayList stores all the Items
        // Adding each Item to the Item Arraylist
        while (scanner.hasNextLine()){
            String currentItem= scanner.nextLine();
            itemName=currentItem.split("=");
            Item newItem= new Item(itemName[0],Integer.parseInt(itemName[1]));
            arrListItems.add(newItem);
        }
        return arrListItems;
    }
    public ArrayList<U1> loadU1(ArrayList<Item> itemArrayList){
        ArrayList<U1> u1ArrayList=new ArrayList<>();
        U1 u1=new U1();
        int currentWeight=0;
        u1ArrayList.add(u1);
        for (Item item:itemArrayList) {
            if (currentWeight< u1.getMaxWeight()&&(currentWeight+ item.getWeight()<=u1.getMaxWeight())){
                currentWeight+= item.getWeight();
                u1.currentWeight+=item.getWeight();
            }
            else {
                u1=new U1();
                u1ArrayList.add(u1);
                currentWeight= item.getWeight();
                u1.currentWeight= item.getWeight();

            }
//            System.out.println("current weight and u1 weight are"+currentWeight+" "+u1.currentWeight);
        }
        return u1ArrayList;

    }
    public ArrayList<U2> loadU2(ArrayList<Item> itemArrayList) {
        ArrayList<U2> u2ArrayList = new ArrayList<>();
        U2 u2 = new U2();
        int currentWeight = 0;
        u2ArrayList.add(u2);
        for (Item item : itemArrayList) {
            if (currentWeight < u2.getMaxWeight() && (currentWeight + item.getWeight() <= u2.getMaxWeight())) {
                currentWeight += item.getWeight();
                u2.currentWeight += item.getWeight();
            } else {
                u2 = new U2();
                u2ArrayList.add(u2);
                currentWeight = item.getWeight();
                u2.currentWeight = item.getWeight();

            }
//            System.out.println("current weight and u1 weight are"+currentWeight+" "+u1.currentWeight);
        }
        return u2ArrayList;
    }
    public int runSimulation(ArrayList<U1> u1Rockets, ArrayList<U2> u2Rockets){
        int totalLandCost=0, totalLaunchCost=0;
        for (U1 rocket:u1Rockets) {
            while (!rocket.launch()){
                // Launch cost will be added each times the rocket fails
                totalLaunchCost+=rocket.getCostInMillions();
                System.out.println("This U1 rocket has failed to launch. Rocket id:"+ u1Rockets.indexOf(rocket));
            }
            // Launch cost will also be added 'once' when a rocket launches successfully
            totalLaunchCost+=rocket.getCostInMillions();
            while (!rocket.land()){
                failedLandings++;
                System.out.println("This U1 rocket has failed to land. Rocket id:"+ u1Rockets.indexOf(rocket));
            }
        }
        // Landing cost will be added only for rockets that fail to land
        totalLandCost=failedLandings*(u1Rockets.get(0).getCostInMillions());
        // reset failedLanding and failedLaunches for U2 Rockets
        failedLandings=0;
        for (U2 rocket:u2Rockets) {
            while (!rocket.launch()){
                totalLaunchCost+=rocket.getCostInMillions();
                System.out.println("This U2 rocket has failed to launch. Rocket id:"+ u2Rockets.indexOf(rocket));
            }
            totalLaunchCost+=rocket.getCostInMillions();
            while (!rocket.land()){
                failedLandings++;
                System.out.println("This U2 rocket has failed to land. Rocket id:"+ u2Rockets.indexOf(rocket));
            }

        }
        totalLandCost+=failedLandings*(u2Rockets.get(0).getCostInMillions());
        // return the final cost
        return totalLandCost+totalLaunchCost;

    }

}