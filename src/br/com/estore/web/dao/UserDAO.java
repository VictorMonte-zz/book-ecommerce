package br.com.estore.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.estore.web.factory.ConnectionFactory;
import br.com.estore.web.model.UserBean;

public class UserDAO {
	public UserBean getUser(UserBean pUser) throws ClassNotFoundException,
			SQLException {

		Connection conn = ConnectionFactory.getConnection();

		try {

			String sql = "SELECT `usuario`.`NOME`, `usuario`.`CPF_CNPJ`, `usuario`.`E_MAIL`, `usuario`.`SEXO`, `usuario`.`TELEFONE`, `usuario`.`CEP`, `usuario`.`RUA`, `usuario`.`BAIRRO`, `usuario`.`NUMERO`, `usuario`.`LOGIN`, `usuario`.`SENHA`, `usuario`.`TP_ACESSO_ID_TP_ACESSO`, `usuario`.`TP_PESSOA_ID_TP` FROM `mydb`.`usuario` WHERE `usuario`.`LOGIN` = ? AND `usuario`.`SENHA` = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, pUser.getLogin());
			stmt.setString(2, pUser.getPassword());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				UserBean oUsuario = new UserBean();
				oUsuario.setName(rs.getString("NOME"));
				oUsuario.setCPFCNPJ(rs.getString("CPF_CNPJ"));

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
