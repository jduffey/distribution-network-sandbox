import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void distributionNetworkShouldInstantiate(){
        DistributionNetwork nmap = new DistributionNetwork();
        Assert.assertNotNull(nmap);
    }

    @Test
    public void foodHubShouldInstantiate(){
        FoodHub hub = new FoodHub();
        Assert.assertNotNull(hub);
    }

    @Test
    public void dNetShouldHaveArrayToHoldHubs(){
        DistributionNetwork dmap = new DistributionNetwork();
        FoodHub hub1 = new FoodHub();
        FoodHub hub2 = new FoodHub();
        FoodHub hub3 = new FoodHub();
        dmap.addHub(hub1);
        dmap.addHub(hub2);
        dmap.addHub(hub3);
        Assert.assertTrue(dmap.allHubs.contains(hub1));
        Assert.assertTrue(dmap.allHubs.contains(hub2));
        Assert.assertTrue(dmap.allHubs.contains(hub3));
    }

}
