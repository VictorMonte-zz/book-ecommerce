package br.com.estore.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estore.web.factory.ConnectionFactory;
import br.com.estore.web.model.AccessTypeBean;
import br.com.estore.web.model.PersonTypeBean;
import br.com.estore.web.model.UserBean;

public class UserDAO implements GenericDAO<UserBean> {

	@Override
	public List<UserBean> getAll() throws ClassNotFoundException, SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "SELECT usuario.NOME, usuario.CPF_CNPJ, usuario.E_MAIL,"
					+ " usuario.SEXO, usuario.TELEFONE, usuario.CEP, usuario.RUA,"
					+ " usuario.BAIRRO, usuario.NUMERO, usuario.LOGIN, usuario.SENHA, "
					+ "usuario.TP_ACESSO_ID_TP_ACESSO, usuario.TP_PESSOA_ID_TP FROM mydb.usuario";

			preparedStatement = dbConnection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();

			List<UserBean> listOfUsers = new ArrayList<UserBean>();

			while (rs.next()) {
				UserBean user = new UserBean();
				user.setName(rs.getString("NOME"));
				user.setCpfcnpj(rs.getString("CPF_CNPJ"));
				user.setEmail(rs.getString("E_MAIL"));
				user.setGender(rs.getString("SEXO").equals("M") ? 'M' : 'F');
				user.setPhone(rs.getString("TELEFONE"));
				user.setCep(rs.getString("CEP"));
				user.setStreet(rs.getString("RUA"));
				user.setNeighborhood("BAIRRO");
				user.setNumber(rs.getInt("NUMERO"));
				user.setLogin(rs.getString("LOGIN"));
				user.setPassword(rs.getString("SENHA"));

				switch (rs.getInt("TP_ACESSO_ID_TP_ACESSO")) {
				case 1:
					user.setAccessType(AccessTypeBean.Administrator);
					break;
				case 2:
					user.setAccessType(AccessTypeBean.Customer);
					break;
				case 3:
					user.setAccessType(AccessTypeBean.Seller);
					break;
				default:
					user.setAccessType(AccessTypeBean.Customer);
					break;
				}

				user.setPersonType(rs.getInt("TP_PESSOA_ID_TP") == 1 ? PersonTypeBean.Individuals
						: PersonTypeBean.LegalEntity);

				listOfUsers.add(user);
			}

			return listOfUsers;

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}

	}

	@Override
	public UserBean save(UserBean pUser) throws ClassNotFoundException,
			SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "INSERT INTO mydb.usuario(NOME,CPF_CNPJ,E_MAIL,SEXO,TELEFONE,CEP,RUA,BAIRRO,"
					+ "NUMERO,LOGIN,SENHA,TP_ACESSO_ID_TP_ACESSO,TP_PESSOA_ID_TP)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);";

			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setString(1, pUser.getName());
			preparedStatement.setString(2, pUser.getCpfcnpj());
			preparedStatement.setString(3, pUser.getEmail());
			preparedStatement.setString(4, String.valueOf(pUser.getGender()));
			preparedStatement.setString(5, pUser.getPhone());
			preparedStatement.setString(6, pUser.getCep());
			preparedStatement.setString(7, pUser.getStreet());
			preparedStatement.setString(8, pUser.getNeighborhood());
			preparedStatement.setInt(9, pUser.getNumber());
			preparedStatement.setString(10, pUser.getLogin());
			preparedStatement.setString(11, pUser.getPassword());
			preparedStatement.setInt(12, pUser.getAccessType().getValue());
			preparedStatement.setInt(13, pUser.getPersonType().getValue());

			preparedStatement.executeQuery();

			return pUser;

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

	public UserBean get(String pCpfcnpj) throws ClassNotFoundException,
			SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		StringBuffer like = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "SELECT usuario.NOME, usuario.CPF_CNPJ, usuario.E_MAIL,"
					+ " usuario.SEXO, usuario.TELEFONE, usuario.CEP, usuario.RUA,"
					+ " usuario.BAIRRO, usuario.NUMERO, usuario.LOGIN, usuario.SENHA, "
					+ "usuario.TP_ACESSO_ID_TP_ACESSO, usuario.TP_PESSOA_ID_TP FROM mydb.usuario"
					+ " WHERE usuario.CPF_CNPJ LIKE ? ";

			preparedStatement = dbConnection.prepareStatement(sql);
			like = new StringBuffer();
			like.append(pCpfcnpj).append("%");
			preparedStatement.setString(1, like.toString());

			ResultSet rs = preparedStatement.executeQuery();

			UserBean user = null;
			if (rs.next()) {
				user = new UserBean();
				user.setName(rs.getString("NOME"));
				user.setCpfcnpj(rs.getString("CPF_CNPJ"));
				user.setEmail(rs.getString("E_MAIL"));
				user.setGender(rs.getString("SEXO").equals("M") ? 'M' : 'F');
				user.setPhone(rs.getString("TELEFONE"));
				user.setCep(rs.getString("CEP"));
				user.setStreet(rs.getString("RUA"));
				user.setNeighborhood("BAIRRO");
				user.setNumber(rs.getInt("NUMERO"));
				user.setLogin(rs.getString("LOGIN"));
				user.setPassword(rs.getString("SENHA"));

				switch (rs.getInt("TP_ACESSO_ID_TP_ACESSO")) {
				case 1:
					user.setAccessType(AccessTypeBean.Administrator);
					break;
				case 2:
					user.setAccessType(AccessTypeBean.Customer);
					break;
				case 3:
					user.setAccessType(AccessTypeBean.Seller);
					break;
				default:
					user.setAccessType(AccessTypeBean.Customer);
					break;
				}

				user.setPersonType(rs.getInt("TP_PESSOA_ID_TP") == 1 ? PersonTypeBean.Individuals
						: PersonTypeBean.LegalEntity);
			}

			return user;

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}

	}

	@Override
	public boolean update(UserBean pUser) throws ClassNotFoundException,
			SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "UPDATE mydb.usuario SET NOME = ?, E_MAIL = ?,SEXO = ?,TELEFONE = ?,CEP = ?,RUA = ?,"
					+ "BAIRRO = ?,NUMERO = ?,LOGIN = ?,SENHA = ?,TP_ACESSO_ID_TP_ACESSO = ?,TP_PESSOA_ID_TP = ?"
					+ "WHERE CPF_CNPJ = ? || %";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, pUser.getName());
			preparedStatement.setString(2, pUser.getEmail());
			preparedStatement.setString(3, String.valueOf(pUser.getGender()));
			preparedStatement.setString(4, pUser.getPhone());
			preparedStatement.setString(5, pUser.getCep());
			preparedStatement.setString(6, pUser.getStreet());
			preparedStatement.setString(7, pUser.getNeighborhood());
			preparedStatement.setInt(8, pUser.getNumber());
			preparedStatement.setString(9, pUser.getLogin());
			preparedStatement.setString(10, pUser.getPassword());
			preparedStatement.setInt(11, pUser.getAccessType().getValue());
			preparedStatement.setInt(12, pUser.getPersonType().getValue());
			preparedStatement.setString(13, pUser.getCpfcnpj());

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

	@Override
	public boolean delete(UserBean pUser) throws ClassNotFoundException,
			SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "DELETE FROM mydb.usuario"
					+ "WHERE usuario.CPF_CNPJ = ? ";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, pUser.getCpfcnpj());

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

	@Override
	public boolean deleteAll() throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "DELETE FROM mydb.usuario";

			preparedStatement = dbConnection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
	}

	@Override
	public UserBean get(Integer id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public UserBean get(String pLogin, String pPassword)
			throws ClassNotFoundException, SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "SELECT usuario.NOME, usuario.CPF_CNPJ, usuario.E_MAIL,"
					+ " usuario.SEXO, usuario.TELEFONE, usuario.CEP, usuario.RUA,"
					+ " usuario.BAIRRO, usuario.NUMERO, usuario.LOGIN, usuario.SENHA, "
					+ "usuario.TP_ACESSO_ID_TP_ACESSO, usuario.TP_PESSOA_ID_TP FROM mydb.usuario"
					+ " WHERE usuario.LOGIN = ?  AND usuario.SENHA = ?";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, pLogin);
			preparedStatement.setString(2, pPassword);

			ResultSet rs = preparedStatement.executeQuery();

			UserBean user = null;
			if (rs.next()) {
				user = new UserBean();
				user.setName(rs.getString("NOME"));
				user.setCpfcnpj(rs.getString("CPF_CNPJ"));
				user.setEmail(rs.getString("E_MAIL"));
				user.setGender(rs.getString("SEXO").equals("M") ? 'M' : 'F');
				user.setPhone(rs.getString("TELEFONE"));
				user.setCep(rs.getString("CEP"));
				user.setStreet(rs.getString("RUA"));
				user.setNeighborhood("BAIRRO");
				user.setNumber(rs.getInt("NUMERO"));
				user.setLogin(rs.getString("LOGIN"));
				user.setPassword(rs.getString("SENHA"));

				switch (rs.getInt("TP_ACESSO_ID_TP_ACESSO")) {
				case 1:
					user.setAccessType(AccessTypeBean.Administrator);
					break;
				case 2:
					user.setAccessType(AccessTypeBean.Customer);
					break;
				case 3:
					user.setAccessType(AccessTypeBean.Seller);
					break;
				default:
					user.setAccessType(AccessTypeBean.Customer);
					break;
				}

				user.setPersonType(rs.getInt("TP_PESSOA_ID_TP") == 1 ? PersonTypeBean.Individuals
						: PersonTypeBean.LegalEntity);
			}

			return user;

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}

	}
}
