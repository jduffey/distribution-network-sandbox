import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void distributionNetworkShouldInstantiate(){
        DistributionNetwork nmap = new DistributionNetwork();
        Assert.assertNotNull(nmap);
    }

}