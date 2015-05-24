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
			HttpServletResponse response) throws ServletException, IOException {

		String op = request.getParameter("op");
		String url = "bookmanager.jsp", id;
		BookDAO dao = null;
		BookBean book = null;

		try {
			switch (op) {
			case "cadastrar":
				
				
				
				break;
			case "listar":

				dao = new BookDAO();

				List<BookBean> books = dao.getAll();

				HttpSession session = request.getSession(true);

				session.setAttribute("books", books);

				break;
			case "editar":

				book = new BookBean();
				dao = new BookDAO();

				id = request.getParameter("id");
				book = dao.get(Integer.parseInt(id));

				// em andamento

				break;
			case "deletar":

				book = new BookBean();
				dao = new BookDAO();

				id = request.getParameter("id");
				book.setId(Integer.parseInt(id));
				dao.delete(book);

				url = "book?op=listar";

			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}

	}
}
