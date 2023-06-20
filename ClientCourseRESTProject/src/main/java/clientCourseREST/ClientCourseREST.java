package clientCourseREST;

import java.util.Scanner;

import org.glassfish.jersey.client.ClientConfig;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

public class ClientCourseREST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "http://localhost:8080/WebCourseRESTProject/rest/WebCourse";
		ClientConfig config = new ClientConfig();
		Client client  = ClientBuilder.newClient(config);
		WebTarget target =  client.target(url);
		
		
		String response = target.request()
				.accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		
		System.out.println("Course Text Output:\n"+response +"\n");
		
		response = target.request()
				.accept(MediaType.TEXT_HTML)
				.get(String.class);
		
		System.out.println("Course HTML Output:\n"+response +"\n");
		
		System.out.println("Please enter Valid Course No: ");
		Scanner params = new Scanner(System.in);
		String course_no = params.next();
 
		try {
		    target = client.target(url).path("/searchCourse/" + course_no);

		    response = target.request()
		            .accept(MediaType.APPLICATION_JSON)
		            .get(String.class);
		    System.out.println("\nCourse Json Search Output:\n\n" + response + "\n");

		    System.out.println("\nDisplay Margin Benefits as Revenue Total Course Fees - Operating Cost:");

		    target = client.target(url).path("/totalCourseFees/" + course_no);

		    String responseTotalCourseFees = target.request()
		            .accept(MediaType.TEXT_PLAIN)
		            .get(String.class);
		    System.out.println("\nCourse Total Fees:\n " + responseTotalCourseFees);

		    System.out.println("\nPlease Enter Operating Cost for Course " + course_no + ": ");

		    Scanner operatingCost = new Scanner(System.in);
		    int operatingCostCourse = operatingCost.nextInt();
		    operatingCost.nextLine();
		    
		    System.out.println( "\nCourse Json Search Output:\n " +response );
		    
		    double benefitCost = Double.parseDouble(responseTotalCourseFees) - operatingCostCourse;
		    System.out.println("\nCourse Benefit is " + benefitCost + "$");
		    operatingCost.close();

		} catch (NotFoundException e) {
		    System.out.println("The Client ID is not correct. Please try again.\n");
		} catch (Exception e) {
		    System.out.println("An error occurred while searching for Course information.\n");
		}		
	}
}
