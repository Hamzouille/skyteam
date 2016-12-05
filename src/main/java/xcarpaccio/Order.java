package xcarpaccio;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class Order {
	public String country;
	public String departureDate;
	public String returnDate;
	public List<Integer> travellerAges;
	public List<String> options;
	public String cover;
	
	@Override
	public String toString() {
		return "Order [country=" + country + ", departureDate=" + departureDate + ", returnDate=" + returnDate
				+ ", travellerAges=" + travellerAges + ", options=" + options + ", cover=" + cover + "]";
	}



	public Answer createQuote() {
		double quote = 1.8 * numberOfDays() * numberOfTravellers(); 
		Answer answer = new Answer(quote);
		return answer;
	}
	
	private int numberOfTravellers() {
		return this.travellerAges.size();
	}



	private int numberOfDays() {
		DateTime start = new DateTime(DateTime.parse(this.departureDate));
		DateTime end = new DateTime(DateTime.parse(this.returnDate));
		return Days.daysBetween(start, end).getDays();
	}
}
