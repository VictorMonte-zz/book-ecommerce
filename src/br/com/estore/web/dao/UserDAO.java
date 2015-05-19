package br.com.estore.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.estore.web.factory.ConnectionFactory;
import br.com.estore.web.model.UserBean;

public class UserDAO implements GenericDAO {

	/*public UserBean getUser(UserBean pUser) throws ClassNotFoundException,
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
*/
	@Override
	public List<UserDAO> getAll() throws ClassNotFoundException, SQLException {
		
		Connection conn = null;
		
		try {
			
			conn = ConnectionFactory.getConnection();
			
			String sql = "SELECT `usuario`.`NOME`, `usuario`.`CPF_CNPJ`, `usuario`.`E_MAIL`,"
					+ " `usuario`.`SEXO`, `usuario`.`TELEFONE`, `usuario`.`CEP`, `usuario`.`RUA`,"
					+ " `usuario`.`BAIRRO`, `usuario`.`NUMERO`, `usuario`.`LOGIN`, `usuario`.`SENHA`, "
					+ "`usuario`.`TP_ACESSO_ID_TP_ACESSO`, `usuario`.`TP_PESSOA_ID_TP` FROM `mydb`.`usuario`";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				UserBean user = new UserBean();
				user.setName(rs.getString("NOME"));
				user.setCpfcnpj(rs.getString("CPF_CNPJ"));
				user.setEmail(rs.getString("EMAIL"));
				user.setGender(rs.getString("SEXO").equals("M") ? 'M' : 'F');
				user.setPhone(rs.getString("TELEFONE"));
				user.setCep(rs.getString("CEP"));
				user.setAddress(rs.getString("RUA"));
				user.setNeighborhood("BAIRRO");
				user.setNumber(rs.getInt("NUMERO"));
				user.setLogin(rs.getString("LOGIN"));
				user.setPassword(rs.getString("PASSWORD"));
				//CONTINUAR
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Object save(Object object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Object object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
