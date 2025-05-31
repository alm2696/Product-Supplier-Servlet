package mod05_OYO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SupplierServlet is a servlet that retrieves supplier data from a database 
 * and displays it in an HTML table format.
 * 
 * It connects to a MySQL database, executes an SQL query to fetch supplier details, 
 * and generates an HTML page to present the data.
 * 
 * This servlet handles GET requests sent to the "/SupplierServlet" URL.
 * 
 * @author angel
 */
@WebServlet("/SupplierServlet")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * Handles HTTP GET requests and retrieves supplier data from the database.
     * It then generates an HTML table displaying the supplier information.
     * 
     * @param request  the HttpServletRequest object that contains the request
     * @param response the HttpServletResponse object that contains the response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Set response content type to HTML
        response.setContentType("text/html");
        PrintWriter netOut = response.getWriter(); // Output stream for sending HTML response to the client

        // Database connection details
        String DBDriver = "com.mysql.cj.jdbc.Driver"; // MySQL JDBC Driver
        String DBURL = "jdbc:mysql://localhost:3306/CMSC230"; // Database URL
        String DBUser = "root"; // Database username
        String DBPassword = "Password!!"; // Database password

        try {
            // Load the JDBC driver class for MySQL
            Class.forName(DBDriver);

            // Establish the connection to the database
            Connection DBCon = DriverManager.getConnection(DBURL, DBUser, DBPassword);

            // SQL query to select supplier data from the suppliers table
            PreparedStatement query = DBCon.prepareStatement(
                "SELECT supplier_id, supplier_name, contact_name, contact_email, phone_number FROM suppliers");

            // Execute the query and retrieve results into a ResultSet
            ResultSet results = query.executeQuery();

            // Start generating the HTML output
            netOut.println("<html><body><h1>Suppliers</h1><table border='1'>");
            netOut.println("<tr><th>Supplier ID</th><th>Supplier Name</th><th>Contact Name</th><th>Contact Email</th><th>Phone Number</th></tr>");

            // Loop through the ResultSet and display each supplier's details in a table row
            while (results.next()) {
                // Retrieve each supplier's information from the current row in the result set
                int id = results.getInt("supplier_id"); // Supplier ID
                String name = results.getString("supplier_name"); // Supplier name
                String contactName = results.getString("contact_name"); // Contact person name
                String contactEmail = results.getString("contact_email"); // Contact person email
                String phoneNumber = results.getString("phone_number"); // Supplier phone number

                // Output the supplier details as a row in the HTML table
                netOut.println("<tr>");
                netOut.println("<td>" + id + "</td>");
                netOut.println("<td>" + name + "</td>");
                netOut.println("<td>" + contactName + "</td>");
                netOut.println("<td>" + contactEmail + "</td>");
                netOut.println("<td>" + phoneNumber + "</td>");
                netOut.println("</tr>");
            }

            // Close the HTML table and the HTML page
            netOut.println("</table></body></html>");

            // Close the ResultSet, PreparedStatement, and Connection to release resources
            results.close();
            query.close();
            DBCon.close();

        } catch (Exception e) {
            // If an exception occurs, print its stack trace to the HTML response for debugging
            e.printStackTrace(netOut);
        }
    }
}
