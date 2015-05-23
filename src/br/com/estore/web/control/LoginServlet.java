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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			treatingRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			treatingRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void treatingRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String login, password;
		CustomerDAO dao = null;
		CustomerBean user = null;
		try {

			if (request.getParameter("txtLogin") != null
					&& request.getParameter("txtPassword") != null) {

				login = request.getParameter("txtLogin");
				password = request.getParameter("txtPassword");

				dao = new CustomerDAO();
				user = new CustomerBean(login, password);

				user = dao.get(user);

				String url = "home";

				if (user == null) {
					request.setAttribute("error", "Credenciais Invalidas");
				} else {
					HttpSession session = request.getSession(true);
					session.setAttribute("user", user);
				}

				RequestDispatcher dispatcher = request
						.getRequestDispatcher(url);
				dispatcher.forward(request, response);

			}
			else
			{
				request.setAttribute("error", "Favor preencher todos os campos.");
			}
				

		} catch (Exception e) {
			throw e;
		}
	}

}
