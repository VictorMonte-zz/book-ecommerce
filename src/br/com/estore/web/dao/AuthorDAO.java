package br.com.estore.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.estore.web.factory.ConnectionFactory;
import br.com.estore.web.model.AuthorBean;
import br.com.estore.web.model.GenderBean;

public class AuthorDAO implements GenericDAO<AuthorBean> {

	@Override
	public List<AuthorBean> getAll() throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		List<AuthorBean> listComment = new ArrayList<>();
		Connection dbConnection = null;
		Statement statement = null;

		String selectTableSQL = "SELECT * FROM ALGO;";

		try {
			dbConnection = ConnectionFactory.getConnection();
			statement = dbConnection.createStatement();

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);
			while (rs.next()) {
				AuthorBean authorBean = new AuthorBean();
				authorBean.setId(rs.getLong(""));
				authorBean.setNome(rs.getString(""));
				authorBean.setTelefone(rs.getString(""));
				authorBean.setCpf(rs.getString(""));
				
				if(rs.getString("").equalsIgnoreCase("M")){
					authorBean.setGender(GenderBean.Masculino);
				} else if(rs.getString("").equalsIgnoreCase("F")){
					authorBean.setGender(GenderBean.Feminino);
				}
				
				authorBean.setEmail(rs.getString(""));
				authorBean.setBirthDate(new Date(rs.getTimestamp("").getTime()));
				
				//authorBean.setNacionality(rs.getString(""));
				
				authorBean.setDescription(rs.getString(""));

				listComment.add(authorBean);
			}
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return listComment;
	}

	@Override
	public AuthorBean save(AuthorBean object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String insertTableSQL = "INSERT INTO INTEGRANTE"
				+ "(NOME, MATRICULA, ID_EQUIPE) VALUES" 
				+ "(?, ?, ?);";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, object.getNome());
			preparedStatement.setString(2, object.getTelefone());
			preparedStatement.setString(3, object.getCpf());
			preparedStatement.setString(4, object.getGender().toString());
			preparedStatement.setString(5, object.getEmail());
			preparedStatement.setLong(6, object.getNacionality().getId());
			preparedStatement.setTimestamp(7, new Timestamp(object.getBirthDate().getTime()));
			preparedStatement.setString(8, object.getCpf());
			preparedStatement.setString(9, object.getCpf());

			if (preparedStatement.executeUpdate() == 1) {
				// execute insert SQL stetement
				resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                {
                	object.setId(resultSet.getLong(1));
                }
				return object;
			}
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return null;
	}

	@Override
	public AuthorBean get(Integer id) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectTableSQL = "SELECT * FROM INTEGRANTE WHERE ID_INTEGRANTE = ?;";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(selectTableSQL, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, id);
			
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				AuthorBean authorBean = new AuthorBean();
				authorBean.setId(rs.getLong(""));
				authorBean.setNome(rs.getString(""));
				authorBean.setTelefone(rs.getString(""));
				authorBean.setCpf(rs.getString(""));
				
				if(rs.getString("").equalsIgnoreCase("M")){
					authorBean.setGender(GenderBean.Masculino);
				} else if(rs.getString("").equalsIgnoreCase("F")){
					authorBean.setGender(GenderBean.Feminino);
				}
				
				authorBean.setEmail(rs.getString(""));
				authorBean.setBirthDate(new Date(rs.getTimestamp("").getTime()));
				
				//authorBean.setNacionality(rs.getString(""));
				
				authorBean.setDescription(rs.getString(""));

				return authorBean;
			}
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return null;

	}

	@Override
	public boolean update(AuthorBean object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "UPDATE mydb.usuario SET NOME = ?, E_MAIL = ?,SEXO = ?,TELEFONE = ?,CEP = ?,RUA = ?,"
					+ "BAIRRO = ?,NUMERO = ?,LOGIN = ?,SENHA = ?,TP_ACESSO_ID_TP_ACESSO = ?,TP_PESSOA_ID_TP = ?"
					+ "WHERE CPF_CNPJ = ? || %";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, object.getNome());
			preparedStatement.setString(2, object.getTelefone());
			preparedStatement.setString(3, object.getCpf());
			preparedStatement.setString(4, object.getGender().toString());
			preparedStatement.setString(5, object.getEmail());
			preparedStatement.setTimestamp(6, new Timestamp(object.getBirthDate().getTime()));
			preparedStatement.setLong(7, object.getNacionality().getId());
			preparedStatement.setString(8, object.getDescription());

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
	public boolean delete(AuthorBean object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM INTEGRANTE WHERE ID_INTEGRANTE = ?;";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setLong(1, object.getId());

			// execute delete SQL stetement
			if (preparedStatement.executeUpdate() == 1) {
				return true;
			}
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return false;
	}

	@Override
	public boolean deleteAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection dbConnection = null;
		Statement statement = null;

		String deleteSQL = "DELETE FROM INTEGRANTE;";

		try {
			dbConnection = ConnectionFactory.getConnection();
			statement = dbConnection.createStatement();

			// execute delete SQL stetement
			if (statement.executeUpdate(deleteSQL) == 1) {
				return true;
			}
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return false;
	}

}
