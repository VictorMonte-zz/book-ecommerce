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

import br.com.estore.web.dao.CategoryDAO;
import br.com.estore.web.model.CategoryBean;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		TreatRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		TreatRequest(request, response);
	}

	protected void TreatRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String op = request.getParameter("op");
		String url = "categorymanager.jsp", id;
		CategoryDAO dao = null;
		CategoryBean category = null;
		
		session.setAttribute("MensagemErro", "");
		session.setAttribute("TabAddEdit", "");

		try {

			switch (op) {

			case "cadastra":
				
				session.setAttribute("TabAddEdit", "S");
				session.setAttribute("Mensagem", "");
				session.setAttribute("category", "");
				break;

			case "confirmar":

				session.setAttribute("Mensagem", "");
				category = new CategoryBean();
				dao = new CategoryDAO();

				String description = request.getParameter("txtDescription");
				String idCategory = request.getParameter("txtIdCategory");

				if (idCategory != "" && idCategory != null) {

					int IdCategory = Integer.parseInt(idCategory);
					category.setId(IdCategory);
					category.setDescription(description);
					dao.update(category);

					session.setAttribute("Mensagem",
							"Categoria Atualizada com Sucesso.");

					url = "category?op=listar";

				} else {
					category.setDescription(description);
					dao.save(category);

					session.setAttribute("Mensagem",
							"Categoria Cadastrada com Sucesso.");

					url = "category?op=listar";
				}

				break;
			case "listar":
				
				dao = new CategoryDAO();

				List<CategoryBean> categorys = dao.getAll();

				session.setAttribute("categorys", categorys);

				break;
			case "editar":
			
				session.setAttribute("TabAddEdit", "S");
				category = new CategoryBean();
				dao = new CategoryDAO();

				id = request.getParameter("id");
				category = dao.get(Integer.parseInt(id));
				session.setAttribute("category", category);

				break;
			case "deletar":

				session.setAttribute("Mensagem", "");
				category = new CategoryBean();
				dao = new CategoryDAO();

				id = request.getParameter("id");
				category.setId(Integer.parseInt(id));
				dao.delete(category);

				session.setAttribute("Mensagem",
						"Categoria Excluida com Sucesso.");

				url = "category?op=listar";

			default:
				break;

			}

		} catch (Exception ex) {

			session.setAttribute("MensagemErro", "");
			ex.printStackTrace();
			session.setAttribute("MensagemErro", ex.getMessage());

		} finally {

			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);

		}

	}

}
