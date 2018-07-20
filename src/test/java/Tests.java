import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void distributionNetworkShouldInstantiate() {
        DistributionNetwork nmap = new DistributionNetwork();
        Assert.assertNotNull(nmap);
    }

    @Test
    public void foodHubShouldInstantiate() {
        FoodHub hub = new FoodHub();
        Assert.assertNotNull(hub);
    }

    @Test
    public void dNetShouldHaveAWayToHoldHubs() {
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

    @Test
    public void foodTypesShouldExist() {
        Assert.assertNotNull(FoodType.BANANA);
        Assert.assertNotNull(FoodType.SOUP_CAN);
        Assert.assertNotNull(FoodType.CEREAL_BOX);
    }

    @Test
    public void foodHubShouldHaveAnInventoryOfGoods() {
        FoodHub hub = new FoodHub();
        hub.addToInventory(FoodType.BANANA, 4);
        hub.addToInventory(FoodType.SOUP_CAN, 3);
        hub.addToInventory(FoodType.CEREAL_BOX, 2);
        Assert.assertEquals(4, hub.getQty(FoodType.BANANA));
        Assert.assertEquals(3, hub.getQty(FoodType.SOUP_CAN));
        Assert.assertEquals(2, hub.getQty(FoodType.CEREAL_BOX));
    }

    @Test
    public void canRemoveItemFromInventory() {
        FoodHub hub = new FoodHub();
        hub.addToInventory(FoodType.BANANA, 4);
        hub.removeFromInventory(FoodType.BANANA, 1);
        Assert.assertEquals(3, hub.getQty(FoodType.BANANA));
    }

}
