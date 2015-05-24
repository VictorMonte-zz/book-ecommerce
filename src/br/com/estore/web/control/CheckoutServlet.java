package br.com.estore.web.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estore.web.dao.PurchaseDAO;
import br.com.estore.web.model.CustomerBean;
import br.com.estore.web.model.PurchaseBean;
import br.com.estore.web.model.ShoppingCartItemBean;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckoutServlet() {
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

		try {

			// recupera o carrinho
			HttpSession session = request.getSession(true);
			List<ShoppingCartItemBean> cart = (List<ShoppingCartItemBean>) session
					.getAttribute("shoppingCart");

			// recupera o usuario
			CustomerBean customer = (CustomerBean) session.getAttribute("user");

			if (cart != null && customer != null) {

				// cadastra na tabela de compras
				PurchaseDAO dao = new PurchaseDAO();
				PurchaseBean purchase = null;

				if (cart != null) {

					for (ShoppingCartItemBean shoppingCartItem : cart) {
						purchase = new PurchaseBean();

						purchase.setBookID(shoppingCartItem.getBookID());
						purchase.setCustomerID(customer.getId());

						Date date = new Date();

						purchase.setDate(date);

						// necessario modificar apos criar a promocao
						purchase.setPromotionID(0);

						purchase.setTotal(shoppingCartItem.getTotal());

						dao.save(purchase);
					}

					// limpa o carrinho
					session.setAttribute("shoppingCart", null);

				}
			}
			// volta pro carrinho
			String url = "shoppingcart?op=listar";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);

		} catch (ServletException | IOException | ClassNotFoundException
				| SQLException e) {
			e.printStackTrace();
		}
	}
}
