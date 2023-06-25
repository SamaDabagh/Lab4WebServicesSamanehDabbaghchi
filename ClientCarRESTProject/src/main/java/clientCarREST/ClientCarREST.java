package clientCarREST;

import java.util.Scanner;

import org.glassfish.jersey.client.ClientConfig;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class ClientCarREST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/WebCarRESTProject/rest/WebCar";
		ClientConfig config = new ClientConfig();
		Client client  = ClientBuilder.newClient(config);
		WebTarget target =  client.target(url);
		
		
		String response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		System.out.println("Car Text Output:\n"+response +"\n");

		
		response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		System.out.println("Car JSON Output:\n\n"+response +"\n");
		
		System.out.println("Please enter Valid  Car vin: ");
		Scanner params = new Scanner(System.in);
		String CarVin = params.next();
//		params.close();  
		

		try {
            target = client.target(url).path("/searchCar/" + CarVin);

            response = target.request()
                    .accept(MediaType.APPLICATION_JSON)
                    .get(String.class);
            System.out.println("\nCar JSON Search Output:\n\n" + response + "\n");

            System.out.println("Display Margin Benefits as Revenue (Total Car Price Discount - Total Operating Car Cost):");
            target = client.target(url).path("/TotalCarPriceDiscount");

            response = target.request()
                    .accept(MediaType.TEXT_PLAIN)
                    .get(String.class);

            System.out.println("\nCourse Total Fees:\n" + response);

            System.out.println("\nPlease Enter Operating Cost for Car: ");
            params.nextLine();

//            Scanner operatingCarCost = new Scanner(System.in);
            double totalOperatingCarCost = params.nextDouble();
            params.nextLine();

            double benefitCost = Double.parseDouble(response) - totalOperatingCarCost;
            System.out.println("\nCourse Benefit is " + benefitCost + "$");
            params.close();
        } 
		catch (NotFoundException e) 
		{
            System.out.println("The Car VIN is not correct. Please try again.\n");
        }
		catch (Exception e) 
		{
            System.out.println("An error occurred while searching for Car information.\n");
        }
			
		
	}

}
