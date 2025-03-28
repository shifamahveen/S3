

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String[] record = new String[4];
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trig", "root", "root");			
			String sql = "SELECT * from calculations where id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				record[0] = String.valueOf(rs.getInt("id"));
				record[1] = String.valueOf(rs.getDouble("angle"));
				record[2] = rs.getString("func");
				record[3] = String.valueOf(rs.getDouble("result"));
			}
			
			stmt.close();
			conn.close();
		}  catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("record", record);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}
}
