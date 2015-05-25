package br.com.estore.web.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estore.web.dao.AuthorDAO;
import br.com.estore.web.dao.BookDAO;
import br.com.estore.web.dao.CategoryDAO;
import br.com.estore.web.dao.PublishingHouseDAO;
import br.com.estore.web.model.AuthorBean;
import br.com.estore.web.model.BookBean;
import br.com.estore.web.model.CategoryBean;
import br.com.estore.web.model.PublishingHouseBean;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
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
		String nome = "";
		String url = "";
		HttpSession session = null;

		BookDAO dao = null;
		List<BookBean> books = null;
		
		PublishingHouseDAO daoPublishingHouse = null;
		List<PublishingHouseBean> publishingHouses = null;
		
		AuthorDAO daoAuthor = null;
		List<AuthorBean> authors = null;
		
		CategoryDAO daoCategory = null;
		List<CategoryBean> categories = null;

		try {

			if (op != null) {
				switch (op) {
				case "buscaSimples":

					nome = request.getParameter("txtNomeSimples");

					if (nome != null) {

						dao = new BookDAO();
						books = dao.getAll(nome);

						if (books.size() > 0) {

							session = request.getSession(true);
							session.setAttribute("booksSimple", books);

							url = "searchofbooks.jsp";

							RequestDispatcher dispatcher = request
									.getRequestDispatcher(url);
							dispatcher.forward(request, response);

						}

					} else {
						// erro de preenchimento
					}

					break;
				case "buscaAvancada":
					
					nome = request.getParameter("txtNomeSimples");
					String editoraID = request.getParameter("ddlEditora"); 
					String autorID = request.getParameter("ddlAutor");
					String categoriaID = request.getParameter("ddlCategoria");

					break;
				case "carregar":
					
					//Editora
					daoPublishingHouse = new PublishingHouseDAO();
					publishingHouses = daoPublishingHouse.getAll();					
					
					if (publishingHouses.size() > 0) {

						session = request.getSession(true);
						session.setAttribute("publishingHouses", publishingHouses);
					}
					
					//Autor
					daoAuthor = new AuthorDAO();
					authors = daoAuthor.getAll();					
					
					if (authors.size() > 0) {

						session = request.getSession(true);
						session.setAttribute("authors", authors);
					}
					
					//Categoria
					daoCategory = new CategoryDAO();
					categories = daoCategory.getAll();					
					
					if (categories.size() > 0) {

						session = request.getSession(true);
						session.setAttribute("categories", categories);
					}

					//ir para a tela
					url = "searchofbooks.jsp";

					RequestDispatcher dispatcher = request
							.getRequestDispatcher(url);
					dispatcher.forward(request, response);

					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
