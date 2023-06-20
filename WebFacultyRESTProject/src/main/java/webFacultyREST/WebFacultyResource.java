package webFacultyREST;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

@Path("/WebFaculty")
public class WebFacultyResource {
    @GET
    @Path("/displayHTMLFacultyInfo")
    @Produces(MediaType.TEXT_HTML)
    public String displayHTMLFacultyInfo() {
        StringBuilder htmlTable = new StringBuilder("<table border='1' style='text-align: center; margin-top: 40px; margin-left: 20%;'>")
                .append("<tr><th style='padding: 10px;'>f_Id</th>")
                .append("<th style='padding: 10px;'>f_Lname</th>")
                .append("<th style='padding: 10px;'>f_Fname</th>")
                .append("<th style='padding: 10px;'>f_zipcodeBirth</th>")
                .append("<th style='padding: 10px;'>f_Salary</th>")
                .append("<th style='padding: 10px;'>f_BonusRate</th>")
                .append("<th style='padding: 10px;'>f_Bonus</th></tr>");

        Map<Integer, Faculty> facultyHashMap = new HashMap<>();
        facultyHashMap.put(101, new Faculty(101, "Robertson", "Myra", 60000.00, 2.50));
        facultyHashMap.put(212, new Faculty(212, "Smith", "Neal", 40000.00, 3.00));
        facultyHashMap.put(315, new Faculty(315, "Arlec", "Lisa", 55000.00, 1.50));
        facultyHashMap.put(857, new Faculty(857, "Fillipo", "Paul", 30000.00, 5.00));
        facultyHashMap.put(370, new Faculty(370, "Denkan", "Anais", 95000.00, 1.50));


        // Display unsorted components
        for (Faculty faculty : facultyHashMap.values()) {
            htmlTable.append("<tr>")
                    .append("<td style='padding: 10px;'>").append(faculty.getF_id()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getF_Lname()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getF_Fname()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getF_Salary()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.getF_BonusRate()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.doCalc_Bonus()).append("</td>")
                    .append("<td style='padding: 10px;'>").append(faculty.doBonus_tax()).append("</td>")
                    .append("</tr>");
        }
        // Display sorted components by bonus value
        // TODO: Sort the facultyHashMap by bonus value

        htmlTable.append("</table>");

        return htmlTable.toString();
    }
}






