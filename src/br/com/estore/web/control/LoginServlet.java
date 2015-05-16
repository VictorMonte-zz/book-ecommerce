package br.com.estore.web.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estore.web.dao.UserDAO;
import br.com.estore.web.model.UserBean;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			tratarRequisicao(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			tratarRequisicao(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void tratarRequisicao(HttpServletRequest request,
			HttpServletResponse response) throws Exception {		
		try {
			
			String login = request.getParameter("txtLogin");
			String password = request.getParameter("txtPassword");
			
			UserDAO DataAccess = new UserDAO();
			
			UserBean User = new UserBean(login,password);			
			
			User = DataAccess.getUser(User);
			
			String url = "index.jsp";
			
			if(User == null){				
				request.setAttribute("error", "Credenciais Invalidas");
			}
			else{
				HttpSession session = request.getSession(true);
				session.setAttribute("user", User);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			throw e;
		}
	}

}
