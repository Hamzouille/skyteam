package xcarpaccio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {
	private Order order;
	
	@Before
	public void setup() {
		this.order = new Order();
	}

	@Test
	public void testFailingOrder() {
		// "country":"DE","departureDate":"2017-02-18","returnDate":"2017-04-01","travellerAges":[54,63,16,72],"options":["Skiing","Medical"],"cover":"Extra"}
		// Unserialized order: Order [country=DE, departureDate=2017-02-18, returnDate=2017-04-01, travellerAges=[54, 63, 16, 72], options=[Skiing, Medical], cover=Extra]
		//	LOOSE: OMG Sky, we expected (466.94) but your answer was ({quote=837.8879999999999})-> You will be charged of 0.0

	}

}
