package br.com.estore.web.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estore.web.dao.CustomerDAO;
import br.com.estore.web.model.CustomerBean;

@WebServlet("/customer")
public class CustomerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CustomerRegistrationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		treatRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		treatRequest(request, response);
	}

	private void treatRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		CustomerBean customer = null;
		CustomerDAO dao = null;
		String url = "customerregistration.jsp";

		if (request.getParameter("txtLogin") != null
				&& request.getParameter("txtPassword") != null
				&& request.getParameter("txtNome") != null
				&& request.getParameter("txtEmail") != null
				&& request.getParameter("rdSexo") != null
				&& request.getParameter("txtTelefone") != null
				&& request.getParameter("txtEndereco") != null) {
			
			customer = new CustomerBean();
			
			customer.setLogin(request.getParameter("txtLogin"));
			customer.setPassword(request.getParameter("txtPassword"));
			customer.setName(request.getParameter("txtNome"));
			customer.setEmail(request.getParameter("txtEmail"));
			customer.setGender(request.getParameter("rdSexo"));
			customer.setPhone(request.getParameter("txtTelefone"));
			customer.setAddress(request.getParameter("txtEndereco"));
			
			try {
				dao = new CustomerDAO();
				
				dao.save(customer);
				
				HttpSession session = request.getSession(true);
				session.setAttribute("cadastroRealizado", 1);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("erro", 2);

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}

	}

}
