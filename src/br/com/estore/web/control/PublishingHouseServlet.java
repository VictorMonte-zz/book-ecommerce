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

import br.com.estore.web.dao.PublishingHouseDAO;
import br.com.estore.web.model.PublishingHouseBean;

/**
 * Servlet implementation class PublishingHouseServlet
 */
@WebServlet("/PublishingHouse")
public class PublishingHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishingHouseServlet() {
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
		String url = "publishingHouseManager.jsp", id;
		PublishingHouseDAO dao = null;
		PublishingHouseBean PublishingHouse = null;
		
		session.setAttribute("MensagemErro", "");
		session.setAttribute("TabAddEdit", "");

		try {

			switch (op) {

			case "cadastra":
				
				session.setAttribute("TabAddEdit", "S");
				session.setAttribute("MensagemPublishingHouse", "");
				session.setAttribute("PublishingHouse", "");
				break;

			case "confirmar":

				session.setAttribute("MensagemPublishingHouse", "");
				PublishingHouse = new PublishingHouseBean();
				dao = new PublishingHouseDAO();

				if (request.getParameter("txtNome") != null
						&& request.getParameter("txtRazaoSocial") != null
						&& request.getParameter("txtEmail") != null
						&& request.getParameter("txtCNPJ") != null
						&& request.getParameter("txtIE") != null
						&& request.getParameter("txtSite") != null
						&& request.getParameter("txtTelefone") != null
						&& request.getParameter("txtEndereco") != null
						&& request.getParameter("txtSede") != null) {

				String idPublishingHouse = request.getParameter("txtIdEditora");

				if (idPublishingHouse != "" && idPublishingHouse != null) {

					int IdPublishingHouse = Integer.parseInt(idPublishingHouse);
					PublishingHouse.setId(IdPublishingHouse);
					PublishingHouse.setName(request.getParameter("txtNome"));
					PublishingHouse.setCompanyName(request.getParameter("txtRazaoSocial"));
					PublishingHouse.setEmail(request.getParameter("txtEmail"));
					PublishingHouse.setCnpj(request.getParameter("txtCNPJ"));
					PublishingHouse.setIe(request.getParameter("txtIE"));
					PublishingHouse.setSite(request.getParameter("txtSite"));			
					PublishingHouse.setPhone(request.getParameter("txtTelefone"));
					PublishingHouse.setAddress(request.getParameter("txtEndereco"));
					PublishingHouse.setHead(request.getParameter("txtSede"));
										
					
					dao.update(PublishingHouse);

					session.setAttribute("MensagemPublishingHouse",
							"Categoria Atualizada com Sucesso.");

					url = "PublishingHouse?op=listar";

				} else {
					
					PublishingHouse.setName(request.getParameter("txtNome"));
					PublishingHouse.setCompanyName(request.getParameter("txtRazaoSocial"));
					PublishingHouse.setEmail(request.getParameter("txtEmail"));
					PublishingHouse.setCnpj(request.getParameter("txtCNPJ"));
					PublishingHouse.setIe(request.getParameter("txtIE"));
					PublishingHouse.setSite(request.getParameter("txtSite"));			
					PublishingHouse.setPhone(request.getParameter("txtTelefone"));
					PublishingHouse.setAddress(request.getParameter("txtEndereco"));
					PublishingHouse.setHead(request.getParameter("txtSede"));
					dao.save(PublishingHouse);

					session.setAttribute("MensagemPublishingHouse",
							"Categoria Cadastrada com Sucesso.");

					url = "PublishingHouse?op=listar";
				}
				}
				else
				{
					session.setAttribute("MensagemErro",
							"Campos Não informado, Por favor tente novamente.");

					url = "PublishingHouse?op=listar";
				}

				break;
			case "listar":
				
				dao = new PublishingHouseDAO();
				
				List<PublishingHouseBean> PublishingHouses = dao.getAll();

				session.setAttribute("PublishingHouses", PublishingHouses);

				break;
			case "editar":
			
				session.setAttribute("TabAddEdit", "S");
				PublishingHouse = new PublishingHouseBean();
				dao = new PublishingHouseDAO();
				
				id = request.getParameter("id");
				PublishingHouse = dao.get(Integer.parseInt(id));
				session.setAttribute("PublishingHouse", PublishingHouse);

				break;
			case "deletar":

				session.setAttribute("MensagemPublishingHouse", "");
				PublishingHouse = new PublishingHouseBean();
				dao = new PublishingHouseDAO();

				id = request.getParameter("id");
				PublishingHouse.setId(Integer.parseInt(id));
				dao.delete(PublishingHouse);

				session.setAttribute("MensagemPublishingHouse",
						"Categoria Excluida com Sucesso.");

				url = "PublishingHouse?op=listar";

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
