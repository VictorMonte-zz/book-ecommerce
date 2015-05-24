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

import br.com.estore.web.dao.BookDAO;
import br.com.estore.web.model.BookBean;
import br.com.estore.web.model.CustomerBean;
import br.com.estore.web.model.ShoppingCartItemBean;

@WebServlet("/shoppingcart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShoppingCartServlet() {
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

	@SuppressWarnings("unchecked")
	private void treatRequest(HttpServletRequest request,
			HttpServletResponse response) {

		ShoppingCartItemBean item = null;
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String qtd = request.getParameter("txtQuantidade");
		List<ShoppingCartItemBean> cart = null;
		HttpSession session = null;
		String url;
		
		try {

			switch (op) {
			case "adicionar":
				// recuper o id do cliente
				session = request.getSession(true);
				CustomerBean customer = (CustomerBean) session
						.getAttribute("user");				

				// obtem livro do bd
				BookDAO dao = new BookDAO();
				BookBean book = dao.get(Integer.parseInt(id));

				// monta objeto com as informações
				item = new ShoppingCartItemBean();
				item.setBookID(book.getId());				
				item.setCustomerID(customer != null ? customer.getId() : 0);				
				item.setDescription(book.getDescription());
				item.setImageDirectory(book.getImageDirectory());

				if (qtd == null) {
					// informar quantidade vazia
					session.setAttribute("msg", 2);

					url = "item.jsp";

					RequestDispatcher dispatcher = request
							.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				}

				if (Integer.parseInt(qtd) <= 0) {
					// informar quantidade vazia
					session.setAttribute("msg", 2);

					url = "item.jsp";

					RequestDispatcher dispatcher = request
							.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				}

				item.setQuantity(Integer.parseInt(qtd));
				item.setSingleValue(book.getPrice());
				item.setTotal(Integer.parseInt(qtd) * book.getPrice());

				// obtem a session do carrinho
				session = request.getSession(true);
				cart = (List<ShoppingCartItemBean>) session
						.getAttribute("shoppingCart");
				if (cart == null) {
					cart = new ArrayList<ShoppingCartItemBean>();
					session.setAttribute("shoppingCart", cart);
				}

				// adiciona o item
				cart.add(item);

				// registra na session
				session.setAttribute("shoppingCart", cart);

				// informa o usuário a adição do item no carrinho
				session.setAttribute("msg", 1);

				url = "item.jsp";

				RequestDispatcher dispatcher = request
						.getRequestDispatcher(url);
				dispatcher.forward(request, response);

				break;

			case "listar":

				session = request.getSession(true);
				cart = (List<ShoppingCartItemBean>) session
						.getAttribute("shoppingCart");
				if (cart != null) {

					Double totalCompra = 0.0;

					for (ShoppingCartItemBean itemCart : cart) {
						totalCompra += itemCart.getTotal();
					}

					session.setAttribute("totalCompra", totalCompra);

				}

				url = "wishlist?op=listar";

				dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);

				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
