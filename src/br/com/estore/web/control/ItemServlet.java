package br.com.estore.web.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estore.web.dao.BookDAO;
import br.com.estore.web.model.BookBean;

@WebServlet("/item")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ItemServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		treatRequest(request,response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		treatRequest(request,response);
	}

	private void treatRequest(HttpServletRequest request,
			HttpServletResponse response) {
		
		//limpando flag de item cadastrado no carrinho
		HttpSession session = request.getSession(true);
		session.setAttribute("msg", 0);
		
		BookBean book = null;
		BookDAO dao = null;
		String url = null;
		String id = request.getParameter("id");		
		
		try {			
			
			if (id == null) {
				//caso nao tenha id mantem na home
				url = "home";		
				
				RequestDispatcher dispacher = request.getRequestDispatcher(url);
				dispacher.forward(request, response);
			}
						
			dao = new BookDAO();
			book = dao.get(Integer.parseInt(id));			
			
			session.setAttribute("book", book);
			
			url = "item.jsp";
			
			RequestDispatcher dispacher = request.getRequestDispatcher(url);
			dispacher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
