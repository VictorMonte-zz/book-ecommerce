package br.com.estore.web.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estore.web.dao.BookDAO;
import br.com.estore.web.dao.WishListDAO;
import br.com.estore.web.model.BookBean;
import br.com.estore.web.model.CustomerBean;
import br.com.estore.web.model.ShoppingCartItemBean;
import br.com.estore.web.model.WishListBean;

@WebServlet("/wishlist")
public class WishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WishListServlet() {
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
		String id = request.getParameter("id");
		HttpSession session = null;
		String url;
		WishListBean wish = null;
		WishListDAO dao = null;
		CustomerBean customer = null;
		List<WishListBean> wishlist = null;
		List<BookBean> wishBooks = null;
		BookBean book = null;
		BookDAO daoBook = null;
		ShoppingCartItemBean item = null;

		try {

			switch (op) {
			case "cadastrar":

				// data de hoje
				Date date = new Date();

				session = request.getSession(true);
				customer = (CustomerBean) session.getAttribute("user");
				if (customer == null) {

					// mensagem de erro para logar
					session.setAttribute("msg", 4);
					
					url = "item.jsp";
					
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				}

				wish = new WishListBean();
				wish.setDate(date);
				wish.setCustomerID(customer.getId());
				wish.setBookID(Integer.parseInt(id));

				dao = new WishListDAO();
				dao.save(wish);

				// informa o usuário a adição do item no carrinho
				session.setAttribute("msg", 3);

				// retorna para o item
				url = "item.jsp";
				RequestDispatcher dispatcher = request
						.getRequestDispatcher(url);
				dispatcher.forward(request, response);

				break;
			case "listar":

				session = request.getSession(true);
				customer = (CustomerBean) session.getAttribute("user");
				if (customer == null) {
					session.setAttribute("error", 1);

					url = "shoppingcartmanager.jsp";

					dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				}

				dao = new WishListDAO();
				daoBook = new BookDAO();

				wishlist = dao.getAll(customer.getId());
				wishBooks = new ArrayList<BookBean>();

				for (WishListBean wishItem : wishlist) {
					book = daoBook.get(wishItem.getBookID());
					wishBooks.add(book);
				}

				session.setAttribute("wishBooks", wishBooks);

				url = "shoppingcartmanager.jsp";

				dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);

				break;
			case "adicionar":

				// recupe id do usuario
				session = request.getSession(true);
				customer = (CustomerBean) session.getAttribute("user");
				if (customer == null) {
					session.setAttribute("error", 1);

					url = "shoppingcartmanager.jsp";

					dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				}
				
				daoBook = new BookDAO();
				// obtem livro do bd				
				book = daoBook.get(Integer.parseInt(id));
								
				// monta objeto com as informações
				item = new ShoppingCartItemBean();
				item.setBookID(book.getId());				
				item.setCustomerID(customer != null ? customer.getId() : 0);				
				item.setDescription(book.getDescription());
				item.setImageDirectory(book.getImageDirectory());
				
				item.setQuantity(0);
				item.setSingleValue(book.getPrice());
				item.setTotal(book.getPrice());

				// obtem a session do carrinho
				session = request.getSession(true);
				@SuppressWarnings("unchecked")
				List<ShoppingCartItemBean> cart = (List<ShoppingCartItemBean>) session.getAttribute("shoppingCart");
				if (cart == null) {
					cart = new ArrayList<ShoppingCartItemBean>();
					session.setAttribute("shoppingCart", cart);
				}

				// adiciona o item
				cart.add(item);

				// registra na session
				session.setAttribute("shoppingCart", cart);
				
				// remover do bd
				dao = new WishListDAO();
				dao.delete(customer.getId(), Integer.parseInt(id));
								
				// carregar o carrinho e lista de desejos
				url = "shoppingcart?op=listar";

				dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
				
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
