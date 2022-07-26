public class U2 extends Rocket{
    public U2() {
        super(120,18000,29000);
    }
    @Override
    public boolean launch() {
        int launchExplosionProbability= (int) ((float)currentWeight/(float) getMaxWeight()*4);
        int rand= (int) (Math.random()*100);
        return rand > launchExplosionProbability;
    }
    @Override
    public boolean land() {
        int landExplosionProbability= (int) ((float)currentWeight/(float) getMaxWeight()*8);
        int rand= (int) (Math.random()*100);
        return rand > landExplosionProbability;
    }

}