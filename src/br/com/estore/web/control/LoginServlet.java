package br.com.estore.web.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estore.web.dao.UsuarioDAO;
import br.com.estore.web.model.UsuarioBean;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			tratarRequisicao(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			tratarRequisicao(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void tratarRequisicao(HttpServletRequest request,
			HttpServletResponse response) throws Exception {		
		try {
			
			String usuario = request.getParameter("txtUsuario");
			String senha = request.getParameter("txtSenha");
			
			UsuarioDAO dao = new UsuarioDAO();
			
			UsuarioBean u = new UsuarioBean(usuario,senha);			
			
			UsuarioBean usuarioLogado = dao.carregarUsuario(u);
			
			String url = "index.jsp";
			
			if(usuarioLogado == null){				
				request.setAttribute("erro", "Credenciais Invalidas");
			}
			else{
				HttpSession session = request.getSession(true);
				session.setAttribute("usuario", usuarioLogado);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			throw e;
		}
	}

}
