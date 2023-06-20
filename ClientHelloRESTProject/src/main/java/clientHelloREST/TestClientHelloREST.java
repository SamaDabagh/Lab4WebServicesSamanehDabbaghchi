package clientHelloREST;

import java.util.*;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.client.*;


public class TestClientHelloREST {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/WebHelloWorldRESTProject/rest/HiHi";
		ClientConfig config = new ClientConfig();
		Client client  = ClientBuilder.newClient(config);
		WebTarget target =  client.target(url);
		
		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		System.out.println(response +"\n");
		
		//GET HTML media type  in HTTP response
		
		response = target.request()
				.accept(MediaType.TEXT_HTML)
				.get(String.class);
		System.out.println(response +"\n");
		
		//GET HTML output with the firing  the method with parameters
		url = "http://localhost:8080/WebHelloRESTProject/rest/HiHi";
		System.out.println("Please enter the name: ");
		Scanner params = new Scanner(System.in);
		String name = params.next();
		params.close();  
		target =  client.target(url).path("/specify/"+ name);
		
		response = target.request()
				.accept(MediaType.TEXT_HTML)
				.get(String.class);
		System.out.println(response + "\n");
		
		//Consume Public REST Service
		url  = "http://api.zippopotam.us/us/98121";
		
		target  = client.target(url);
		
		response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.get(String.class);
		
		System.out.println(response + "\n");

	}

}
