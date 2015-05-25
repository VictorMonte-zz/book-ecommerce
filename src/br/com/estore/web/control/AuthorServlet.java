package br.com.estore.web.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estore.web.dao.AuthorDAO;
import br.com.estore.web.model.AuthorBean;

/**
 * Servlet implementation class AuthorServlet
 */
@WebServlet("/author")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TreatRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TreatRequest(request, response);
	}
	
	protected void TreatRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String op = request.getParameter("op");
		String url = "authormanager.jsp", id;
		AuthorDAO dao = null;
		AuthorBean author = null;
		
		session.setAttribute("MensagemErro", "");
		session.setAttribute("TabAddEdit", "");

		try {

			switch (op) {

			case "cadastra":
				
				session.setAttribute("TabAddEdit", "S");
				session.setAttribute("MensagemAuthor", "");
				session.setAttribute("author", "");
				break;

			case "confirmar":

				session.setAttribute("MensagemAuthor", "");
				author = new AuthorBean();
				dao = new AuthorDAO();


				String idauthor = request.getParameter("txtIdAutor");

				if (idauthor != "" && idauthor != null) {

					int Idauthor = Integer.parseInt(idauthor);
					author.setId(Idauthor);
					author.setName(request.getParameter("txtNome"));
					author.setLastName(request.getParameter("txtSobreNome"));
					author.setEmail(request.getParameter("txtEmail"));
					author.setPhone(request.getParameter("txtTelefone"));
					author.setNacionality(request.getParameter("txtNacionalidade"));
					
			
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date = formatter.parse(request.getParameter("txtDataNascimento"));
					
					author.setBirthDate(date);
					
					author.setGender(request.getParameter("rdSexo"));
					author.setAddress(request.getParameter("txtEndereco"));
					author.setSpouse(request.getParameter("txtConjuge"));					
					
					dao.update(author);

					session.setAttribute("MensagemAuthor",
							"Categoria Atualizada com Sucesso.");

					url = "author?op=listar";

				} else {
					author.setName(request.getParameter("txtNome"));
					author.setLastName(request.getParameter("txtSobreNome"));
					author.setEmail(request.getParameter("txtEmail"));
					author.setPhone(request.getParameter("txtTelefone"));
					author.setNacionality(request.getParameter("txtNacionalidade"));
					
			
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					Date date = formatter.parse(request.getParameter("txtDataNascimento"));
					
					author.setBirthDate(date);
					
					author.setGender(request.getParameter("rdSexo"));
					author.setAddress(request.getParameter("txtEndereco"));
					author.setSpouse(request.getParameter("txtConjuge"));	
					dao.save(author);

					session.setAttribute("MensagemAuthor",
							"Categoria Cadastrada com Sucesso.");

					url = "author?op=listar";
				}

				break;
			case "listar":
				
				dao = new AuthorDAO();
				
				List<AuthorBean> authors = dao.getAll();

				session.setAttribute("authors", authors);

				break;
			case "editar":
			
				session.setAttribute("TabAddEdit", "S");
				author = new AuthorBean();
				dao = new AuthorDAO();
				
				id = request.getParameter("id");
				author = dao.get(Integer.parseInt(id));
				session.setAttribute("author", author);

				break;
			case "deletar":

				session.setAttribute("MensagemAuthor", "");
				author = new AuthorBean();
				dao = new AuthorDAO();

				id = request.getParameter("id");
				author.setId(Integer.parseInt(id));
				dao.delete(author);

				session.setAttribute("MensagemAuthor",
						"Categoria Excluida com Sucesso.");

				url = "author?op=listar";

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
