import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrigServlet
 */
@WebServlet("/TrigServlet")
public class TrigServlet extends HttpServlet {
	String DB_NAME = "jdbc:mysql//localhost:3306/trig";
	String DB_USER = "root";
	String DB_PASS = "root";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double angle = Double.parseDouble(request.getParameter("angle"));
		String func = request.getParameter("func");
		double result = 0;
		
		switch(func) {
			case "sin" :
				result = Math.sin(Math.toRadians(angle));
				break;
			case "cos":
				result = Math.cos(Math.toRadians(angle));
				break;
			case "tan":
				result = Math.tan(Math.toRadians(angle));
				break;
			case "cot":
				result = 1/Math.tan(Math.toRadians(angle));
				break;
			case "sec":
				result = 1/Math.cos(Math.toRadians(angle));
				break;
			case "cosec":
				result = 1/Math.sin(Math.toRadians(angle));
				break;
		}
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/trig", "root", "root");			
			String sql = "INSERT into calculations (angle, func, result) values (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setDouble(1, angle);
			stmt.setString(2, func);
			stmt.setDouble(3, result);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		}  catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		request.setAttribute("result", result);
		request.setAttribute("angle", angle);
		request.setAttribute("func", func);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}