package xcarpaccio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		double quote = getCover() * getCountryFactor() * sumOfAgeRisks() * numberOfDays() + getOption();
		Answer answer = new Answer(quote);
		return answer;
	}

	private double getOption() {
		double result = 0.0;
		for (String option : this.options) {
			option = option.toLowerCase();
			switch (option) {
			case "skiing":
				result += 24.0;
				break;
			case "medical":
				result += 72.0;
				break;
			case "scuba":
				result += 36.0;
				break;
			case "sports":
				result += 25.0;
				break;
			case "yoga":
				result += -3.0;
				break;
			default:
				System.out.println(">>> Unknown option: " + option);
				throw new IllegalArgumentException("Unknown option: " +  option);
			}
		}
		return result;
	}

	private double sumOfAgeRisks() {
		// TODO Auto-generated method stub
		double sum = 0;
		for (int age : this.travellerAges) {
			if (age < 18) {
				sum += 1.1;
			} else if (age <= 24) {
				sum += 0.9;
			} else if (age <= 65) {
				sum += 1.0;
			} else {
				sum += 1.5;
			}
		}
		return sum;
	}

	private double getCountryFactor() {
		// TODO Auto-generated method stub
		switch (this.country.toLowerCase()) {
		case "pl":
			return 1.4;
		case "pt":
			return 0.5; // portugal
		case "lv":
			return 0.6; // Latvia
		case "gr":
			return 0.6; // Greece
		case "kp":
			return 6.9; // Democratic People's Republic of Korea
		case "He":
			return 0.7; // Heard Island and McDonald Islands
		case "lt":
			return 0.7; // Lithuania
		case "nl":
			return 0.7; // Netherlands
		case "sk":
			return 0.7; // Slovakia
		case "de":
			return 0.8; // Germany
		case "si":
			return 0.8; // Solvenia
		case "be":
			return 0.9; // Belgium
		case "at":
			return 0.9; // Austria
		case "fr":
			return 1.0; // France
		case "bg":
			return 1.1; // Bulgaria
		case "uk":
			return 1.1; // United Kingdom
		case "ie":
			return 1.1; // Ireland
		case "es":
			return 1.1; // Spain
		case "hu":
			return 1.1; // Hungary
		case "im":
			return 1.2; // Isle of Mann
		case "se":
			return 1.2; // Sweden
		case "cz":
			return 1.2; // Czechia
		case "dk":
			return 1.2; // Denmark
		case "ee":
			return 1.3; // Estonia
		case "lu":
			return 1.3; // Luxembourg
		case "do":
			return 1.3; // Dominican Republic
		case "ro":
			return 1.3; // Romania
		case "hr":
			return 1.3; // Croatia
		case "td":
			return 1.3; // chad
		case "wf":
			return 1.5; // Wallis and Futana
		case "it":
			return 1.2;
		case "fi":
			return 0.8;
		default:
			if (country.length() > 2 ) {
				throw new IllegalArgumentException("Unknown Country: " +  this.country);	
			}
			System.out.println(">>> Unknown country: " + this.country);
		}
		return 1.6;
	}

	private double getCover() {
		// TODO Auto-generated method stub
		switch (this.cover) {
		case "Basic":
			return 1.8;
		case "Extra":
			return 2.4;
		case "Premier":
			return 4.2;
		}
		return 1.0;
	}

	private int numberOfTravellers() {
		return this.travellerAges.size();
	}

	private int numberOfDays() {
		DateTime start = new DateTime(DateTime.parse(this.departureDate));
		DateTime end = new DateTime(DateTime.parse(this.returnDate));
		int days = Days.daysBetween(start, end).getDays();
		return days > 7 ? days : 7;
	}
}
