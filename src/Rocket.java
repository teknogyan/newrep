public class Rocket implements Spaceship{
    private final int costInMillions;
    private final int weight;
    private final int  maxWeight;
    public int currentWeight;
    public Rocket(int costInMillions, int weight, int maxWeight) {
        this.costInMillions = costInMillions;
        this.weight = weight;
        this.maxWeight = maxWeight;
        this.currentWeight=0;  //current weight will be 0 at the time of initialization.
    }

    public int getCostInMillions() {
        return costInMillions;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {

        return true;
    }

}