package br.com.estore.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estore.web.factory.ConnectionFactory;
import br.com.estore.web.model.UsuarioBean;

public class UsuarioDAO {
	public UsuarioBean carregarUsuario(UsuarioBean usuario) throws ClassNotFoundException, SQLException {
		
		Connection conn = ConnectionFactory.getConnection();
		
		try {

			String sql = "SELECT NOME FROM USUARIO WHERE LOGIN = ? AND SENHA = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				UsuarioBean oUsuario = new UsuarioBean();
				oUsuario.setNome(rs.getString("NOME"));

				return oUsuario;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return null;
	}
}
