package br.com.estore.web.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estore.web.dao.BookDAO;
import br.com.estore.web.model.BookBean;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookServlet() {
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
			HttpServletResponse response) {

		String op = request.getParameter("op");
		BookDAO dao = null;
		String url = "bookmanager.jsp";

		try {
			switch (op) {
			case "listar":

				dao = new BookDAO();

				List<BookBean> books = dao.getAll();

				HttpSession session = request.getSession(true);

				session.setAttribute("books", books);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher(url);
				dispatcher.forward(request, response);

				break;
			default:
				break;
			}
		} catch (Exception e) {
		}

	}
}
