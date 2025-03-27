

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecordsServlet
 */
@WebServlet("/RecordsServlet")
public class RecordsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String[]> records = new ArrayList<>();
		
//		{
//			"{1, 90, sin, 90.0}", 
//			"{2, 30, cos, 0.86}",
//		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trig", "root", "root");

			String sql = "Select * from calculations";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				String[] record = {
						String.valueOf(rs.getDouble("angle")),
						rs.getString("func"),
						String.valueOf(rs.getDouble("result"))
				};
				records.add(record);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
		
		request.setAttribute("records", records);
		request.getRequestDispatcher("records.jsp").forward(request, response);
	}
}