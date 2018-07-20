import java.util.ArrayList;
import java.util.List;

public class DistributionNetwork {

    List<FoodHub> allHubs = new ArrayList<>();

    public void addHub(FoodHub hubToBeAdded) {
        allHubs.add(hubToBeAdded);
    }
}
