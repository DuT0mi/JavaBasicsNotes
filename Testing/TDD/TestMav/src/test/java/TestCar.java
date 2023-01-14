import org.example.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
public class TestCar {
    Car car = null;
    @Before
    public void init(){
        car = new Car();
    }
    @Test
    public void testMethodSum(){
        Assert.assertEquals(3,car.sum(1,1,1));
    }
}
