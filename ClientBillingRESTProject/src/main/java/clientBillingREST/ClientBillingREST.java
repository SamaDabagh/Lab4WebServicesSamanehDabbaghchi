package clientBillingREST;

import java.util.Scanner;


import org.glassfish.jersey.client.ClientConfig;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class ClientBillingREST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/WebBillingRESTProject/rest/WebBilling";
		ClientConfig config = new ClientConfig();
		Client client  = ClientBuilder.newClient(config);
		WebTarget target =  client.target(url);
		
		String response = target.request()
				.accept(MediaType.TEXT_HTML)
				.get(String.class);
		
		System.out.println("Billing HTML Output:\n"+response +"\n");

		response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		System.out.println("Billing Text Output:\n"+response +"\n");
		
		System.out.println("Please enter Numerical client ID: ");
		Scanner params = new Scanner(System.in);
		String clientID = params.next();
		params.close();  
		

			try {
			    target = client.target(url).path("/searchBilling/" +clientID);

			    response = target.request()
			            .accept(MediaType.APPLICATION_JSON)
			            .get(String.class);
			    System.out.println("\nBilling Json Search Output:\n\n"+response + "\n");
			} catch (NotFoundException e) {
			    System.out.println("The Client ID is not correct. Please try again.\n");
			} catch (Exception e) {
			    System.out.println("An error occurred while searching for billing information.\n");
			}

	}

}
