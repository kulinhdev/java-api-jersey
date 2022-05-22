package servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;

import entity.Product;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// Declare URL service
		String url = "http://localhost:8088/Restful-web-API/products";

		// Create Client
		Client client = Client.create();

		// Get data from view
		String name = request.getParameter("name");
		Date expire = Date.valueOf(request.getParameter("expire"));
		float price = Float.valueOf(request.getParameter("price"));

		Product p = new Product(name, expire, price);
		Gson gson = new Gson();
		String datajson = gson.toJson(p);

		// Call post request sent data
		String result = client.resource(url).header("Content-Type", "application/json;charset=UTF8").post(String.class,
				datajson);

		System.out.println(result);

		// Send redirect
		response.sendRedirect("ProductServlet");
	}

}
