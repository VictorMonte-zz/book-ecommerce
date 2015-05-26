package br.com.estore.web.control;

import java.io.IOException;
import java.util.Date;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estore.web.dao.CommentDAO;
import br.com.estore.web.model.CommentBean;
import br.com.estore.web.model.CustomerBean;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TreatRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TreatRequest(request, response);
	}

	protected void TreatRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String url = "item?id=" + request.getParameter("id");
		CommentDAO dao = null;
		CommentBean comment = null;

		session.setAttribute("MensageComment", "");

		try {

			CustomerBean customer = (CustomerBean) session.getAttribute("user");

			if (customer.getId() > 0) {
				comment = new CommentBean();
				dao = new CommentDAO();

				comment.setDescription(request.getParameter("txtDescription"));
				comment.setDateComment(new Date());
				comment.setIdBook(Integer.parseInt(request.getParameter("id")));
				comment.setIdCustomer(customer.getId());

				dao.save(comment);

				session.setAttribute("MensageComment",
						"Comentario cadastrado com sucesso.");

			} else {
				session.setAttribute("MensagemErro",
						"Para cadastra o comentario você deve está logado.");
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
