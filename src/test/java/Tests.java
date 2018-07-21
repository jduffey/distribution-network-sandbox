import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void distributionNetworkShouldInstantiate() {
        DistributionNetwork dnet = new DistributionNetwork();
        Assert.assertNotNull(dnet);
    }

    @Test
    public void foodHubShouldInstantiate() {
        FoodHub hub = new FoodHub();
        Assert.assertNotNull(hub);
    }

    @Test
    public void dNetShouldHaveAWayToHoldHubs() {
        DistributionNetwork dnet = new DistributionNetwork();
        FoodHub hub1 = new FoodHub();
        FoodHub hub2 = new FoodHub();
        FoodHub hub3 = new FoodHub();
        dnet.addHub(hub1);
        dnet.addHub(hub2);
        dnet.addHub(hub3);
        Assert.assertTrue(dnet.allHubs.contains(hub1));
        Assert.assertTrue(dnet.allHubs.contains(hub2));
        Assert.assertTrue(dnet.allHubs.contains(hub3));
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

    @Test
    public void canRemoveSameItemMultipleTimesFromSameInventory(){
        FoodHub hub = new FoodHub();
        hub.addToInventory(FoodType.BANANA, 4);
        hub.removeFromInventory(FoodType.BANANA, 2);
        hub.removeFromInventory(FoodType.BANANA, 1);
        Assert.assertEquals(1, hub.getQty(FoodType.BANANA));
    }

    @Test
    public void canAddSameItemMultipleTimesToSameInventory(){
        FoodHub hub = new FoodHub();
        hub.addToInventory(FoodType.BANANA, 4);
        hub.addToInventory(FoodType.BANANA, 3);
        Assert.assertEquals(7, hub.getQty(FoodType.BANANA));
    }

    @Test(expected = ArithmeticException.class)
    public void shouldThrowExceptionIfTryToRemoveMoreItemsThanExistInInventory() {
        FoodHub hub = new FoodHub();
        hub.addToInventory(FoodType.BANANA, 4);
        hub.removeFromInventory(FoodType.BANANA, 5);
    }

    @Test
    public void foodHubShouldHaveAHierarchyLevel() {
        FoodHub hub = new FoodHub();
        hub.setHierarchyLevel(HierarchyLevel.SOURCE);
        Assert.assertEquals(HierarchyLevel.SOURCE, hub.getHierarchyLevel());
    }

    @Test
    public void shouldHaveSeveralTypesOfHierarchyLevels() {
        Assert.assertNotNull(HierarchyLevel.SOURCE);
        Assert.assertNotNull(HierarchyLevel.BANK);
        Assert.assertNotNull(HierarchyLevel.PANTRY);
    }

    @Test
    public void canTransferItemsFromOneHubToAnother() {
        DistributionNetwork dnet = new DistributionNetwork();
        FoodHub hub1 = new FoodHub();
        FoodHub hub2 = new FoodHub();
        dnet.addHub(hub1);
        dnet.addHub(hub2);
        hub1.addToInventory(FoodType.BANANA, 10);
        dnet.transferInventory(hub1, hub2, FoodType.BANANA, 6);
        Assert.assertEquals(4, hub1.getQty(FoodType.BANANA));
        Assert.assertEquals(6, hub2.getQty(FoodType.BANANA));
        dnet.transferInventory(hub2, hub1, FoodType.BANANA, 4);
        Assert.assertEquals(8, hub1.getQty(FoodType.BANANA));
        Assert.assertEquals(2, hub2.getQty(FoodType.BANANA));
    }

}
