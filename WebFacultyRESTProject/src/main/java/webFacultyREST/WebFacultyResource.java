package webFacultyREST;


import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.glassfish.jersey.client.ClientConfig;


@Path("WebFaculty")
public class WebFacultyResource {
	
	public static double totalFacultyBonuse  =  0.00;
	
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String displayHTMLFacultyInfo() 
    {
        StringBuilder htmlTable = 
        		new StringBuilder("<table border='1' style='text-align: center; margin-top: 40px; margin-left: 2%;'>")
                .append("<tr><th style='padding: 10px;'>Faculty_Id</th>")
                .append("<th style='padding: 10px;'>Faculty_Lname</th>")
                .append("<th style='padding: 10px;'>Faculty_Fname</th>")
                .append("<th style='padding: 10px;'>Faculty_zipcodeBirth</th>")
                .append("<th style='padding: 10px;'>Faculty_Salary</th>")
                .append("<th style='padding: 10px;'>Faculty_BonusRate</th>")
                .append("<th style='padding: 10px;'>Faculty_Bonus</th></tr>");

        Map<Integer, Faculty> facultyHashMap = new HashMap<>();
        
        Faculty faculty1 = new Faculty(101, "Robertson", "Myra", "98121", 60000.00, 2.50);
        Faculty faculty2 = new Faculty(212, "Smith", "Neal", "85001", 40000.00, 3.00);
        Faculty faculty3 = new Faculty(315, "Arlec", "Lisa", "71601", 55000.00, 1.50);
        Faculty faculty4 = new Faculty(857, "Fillipo", "Paul", "90001", 30000.00, 5.00);
        Faculty faculty5 = new Faculty(370, "Denkan", "Anais", "15001", 95000.00, 1.50);

        facultyHashMap.put(faculty1.getF_id(), faculty1);
        facultyHashMap.put(faculty2.getF_id(), faculty2);
        facultyHashMap.put(faculty3.getF_id(), faculty3);
        facultyHashMap.put(faculty4.getF_id(), faculty4);
        facultyHashMap.put(faculty5.getF_id(), faculty5);

        facultyHashMap.entrySet().stream().forEach(faculty ->
        {
            htmlTable.append("<tr>")
                    .append("<td style='padding: 10px;'>").append(faculty.getKey()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getValue().getF_Lname()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getValue().getF_Fname()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(getJSONOutputForZipCode(faculty.getValue().getF_zipcodeBirth())).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getValue().getF_Salary()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getValue().getF_BonusRate()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getValue().doCalc_Bonus()).append("</td>")
                    .append("</tr>");
            
            totalFacultyBonuse += faculty.getValue().doCalc_Bonus();
        });

        htmlTable.append("</table>")
        .append("<h2 style='padding: 10px; margin-left: 35%;'>").append("The Total Faculty Bonus is: "+totalFacultyBonuse).append(" $ </h2>");

        return htmlTable.toString();
    }

    @GET
    @Path("/sortedByBonus")
    @Produces(MediaType.TEXT_HTML)
    public String displayHTMLFacultyInfoSortedByBonus() 
    {
        StringBuilder htmlTable = 
        		new StringBuilder("<h2 style='padding: 10px; margin-left: 30%;'>").append("Faculty HashMap Info sorted(Sort By Bonus): ").append(" </h2>")
        		.append("<table border='1' style='text-align: center; margin-top: 40px; margin-left: 10%;'>")
                .append("<tr><th style='padding: 10px;'>Faculty_Id</th>")
                .append("<th style='padding: 10px;'>Faculty_Lname</th>")
                .append("<th style='padding: 10px;'>Faculty_Fname</th>")
                .append("<th style='padding: 10px;'>Faculty_zipcodeBirth</th>")
                .append("<th style='padding: 10px;'>Faculty_Salary</th>")
                .append("<th style='padding: 10px;'>Faculty_BonusRate</th>")
                .append("<th style='padding: 10px;'>Faculty_Bonus</th></tr>");

        Map<Integer, Faculty> facultyHashMap = new HashMap<>();
        
        Faculty faculty1 = new Faculty(101, "Robertson", "Myra", "98121", 60000.00, 2.50);
        Faculty faculty2 = new Faculty(212, "Smith", "Neal", "85001", 40000.00, 3.00);
        Faculty faculty3 = new Faculty(315, "Arlec", "Lisa", "71601", 55000.00, 1.50);
        Faculty faculty4 = new Faculty(857, "Fillipo", "Paul", "90001", 30000.00, 5.00);
        Faculty faculty5 = new Faculty(370, "Denkan", "Anais", "15001", 95000.00, 1.50);

        facultyHashMap.put(faculty1.getF_id(), faculty1);
        facultyHashMap.put(faculty2.getF_id(), faculty2);
        facultyHashMap.put(faculty3.getF_id(), faculty3);
        facultyHashMap.put(faculty4.getF_id(), faculty4);
        facultyHashMap.put(faculty5.getF_id(), faculty5);

        facultyHashMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Faculty::doCalc_Bonus))).forEach(faculty ->
        {
            htmlTable.append("<tr>")
                    .append("<td style='padding: 10px;'>").append(faculty.getKey()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getValue().getF_Lname()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getValue().getF_Fname()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getValue().getF_zipcodeBirth()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getValue().getF_Salary()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getValue().getF_BonusRate()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getValue().doCalc_Bonus()).append("</td>")
                    .append("</tr>");
            
        });

        htmlTable.append("</table>");
       
        return htmlTable.toString();
    }  
    
    @GET
    @Path("zipCode/{zipcode}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJSONOutputForZipCode(@PathParam("zipcode") String zipcode) {
        String apiUrl = "http://api.zippopotam.us/us/" + zipcode;
        ClientConfig config = new ClientConfig();
        Client client = ClientBuilder.newClient(config);
        WebTarget target = client.target(apiUrl);
        
        String response = target.request()
        		.accept(MediaType.APPLICATION_JSON)
        		.get(String.class);
        
        return response;
    }

}




