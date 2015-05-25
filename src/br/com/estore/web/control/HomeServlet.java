package br.com.estore.web.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estore.web.dao.BookDAO;
import br.com.estore.web.dao.CategoryDAO;
import br.com.estore.web.model.BookBean;
import br.com.estore.web.model.CategoryBean;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			treatRequest(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			treatRequest(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void treatRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		String url = "index.jsp";
		
		//carregar livros
		BookDAO dao = new BookDAO();
		
		List<BookBean> books = null;
		
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		if (op != null && id != null) {
			books = dao.getAll(Integer.parseInt(id));
		}
		else {
			books = dao.getAll();
		}
		
		
		if (books != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("books", books);
			
			//limpa os erros
			session.setAttribute("error", 0);
			session.setAttribute("isLogged", 0);
		}
		
		//Categoria
		CategoryDAO daoCategory = new CategoryDAO();
		List<CategoryBean> categories = daoCategory.getAll();					
		
		if (categories.size() > 0) {

			HttpSession session = request.getSession(true);
			session.setAttribute("categories", categories);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
