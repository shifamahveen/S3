import java.io.IOException;
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double angle = Double.parseDouble(request.getParameter("angle"));
		String func = request.getParameter("func");
		double result = 0;
		angle = Math.toRadians(angle);
		
		switch(func) {
		case "sin" :
			result = Math.sin(angle);
			break;
		case "cos":
			result = Math.cos(angle);
			break;
		case "tan":
			result = Math.tan(angle);
			break;
		case "cot":
			result = Math.cos(angle)/Math.sin(angle);
			break;
		case "sec":
			result = 1/Math.cos(angle);
			break;
		case "cosec":
			result = 1/Math.sin(angle);
			break;
		}
		
		request.setAttribute("result", result);
		request.setAttribute("angle", angle);
		request.setAttribute("func", func);
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
