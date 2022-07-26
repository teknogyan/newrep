public class U1 extends Rocket{
    public U1() {
        super(100,10000,18000);
    }
    @Override
    public boolean launch() {

        int launchExplosionProbability= (int) ((float)currentWeight/(float) getMaxWeight()*5);
        int rand= (int) (Math.random()*100);
        return rand > launchExplosionProbability;
    }
    @Override
    public boolean land() {
        int landExplosionProbability= (int) ((float)currentWeight/(float) getMaxWeight()*1+50); //could have been any number other than 50;
        int rand= (int) (Math.random()*100);
        return rand != landExplosionProbability;
    }

}