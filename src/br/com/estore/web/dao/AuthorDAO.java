package br.com.estore.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
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

		String selectTableSQL = "SELECT * FROM AUTHOR;";

		try {
			dbConnection = ConnectionFactory.getConnection();
			statement = dbConnection.createStatement();

			// execute select SQL stetement
			ResultSet rs = statement.executeQuery(selectTableSQL);
			while (rs.next()) {
				AuthorBean authorBean = new AuthorBean();
				authorBean.setId(rs.getInt("ID_AUTHOR"));
				authorBean.setName(rs.getString("NAME"));
				authorBean.setLastName(rs.getString("LAST_NAME"));
				authorBean.setEmail(rs.getString("EMAIL"));
				authorBean.setPhone(rs.getString("PHONE"));
				authorBean.setNacionality(rs.getString("NATIONALITY"));
				authorBean.setBirthDate(new Timestamp(rs.getTimestamp("DATA_BIRTH").getTime()));
				authorBean.setGender(rs.getString("GENDER"));
				authorBean.setAddress(rs.getString("ADDRESS"));			
				authorBean.setSpouse(rs.getString("SPOUSE"));

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

		String insertTableSQL = "INSERT INTO AUTHOR"
				+ "( NAME, LAST_NAME, EMAIL, PHONE, NATIONALITY, DATA_BIRTH, GENDER, ADDRESS, SPOUSE) VALUES" 
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?);";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getLastName());
			preparedStatement.setString(3, object.getEmail());
			preparedStatement.setString(4, object.getPhone());
			preparedStatement.setString(5, object.getNacionality());
			preparedStatement.setTimestamp(6, new Timestamp(object.getBirthDate().getTime()));
			preparedStatement.setString(7, object.getGender().toString());
			preparedStatement.setString(8, object.getAddress());
			preparedStatement.setString(9, object.getSpouse());

			if (preparedStatement.executeUpdate() == 1) {
				// execute insert SQL stetement
				resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                {
                	object.setId(resultSet.getInt(1));
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

		String selectTableSQL = "SELECT * FROM AUTHOR WHERE ID_AUTHOR = ?;";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(selectTableSQL, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, id);
			
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				
				AuthorBean authorBean = new AuthorBean();
				authorBean.setId(rs.getInt("ID_AUTHOR"));
				authorBean.setName(rs.getString("NAME"));
				authorBean.setLastName(rs.getString("LAST_NAME"));
				authorBean.setEmail(rs.getString("EMAIL"));
				authorBean.setPhone(rs.getString("PHONE"));
				authorBean.setNacionality(rs.getString("NATIONALITY"));
				authorBean.setBirthDate(new Timestamp(rs.getTimestamp("DATA_BIRTH").getTime()));
				authorBean.setGender(rs.getString("GENDER"));
				authorBean.setAddress(rs.getString("ADDRESS"));			
				authorBean.setSpouse(rs.getString("SPOUSE"));

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

			String sql = "UPDATE `mydb`.`author`"+
							"SET"+
							"`NAME` =?,			"+					
							"`LAST_NAME` = ?,"+
							"`EMAIL` = ?,"+
							"`PHONE` = ?,"+
							"`NATIONALITY` = ?,"+
							"`DATA_BIRTH` = ?,"+
							"`GENDER` = ?,"+
							"`ADDRESS` = ?,"+
							"`SPOUSE` = ?"+
						"WHERE ID_AUTHOR = ?>";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getLastName());
			preparedStatement.setString(3, object.getEmail());
			preparedStatement.setString(4, object.getPhone());
			preparedStatement.setString(5, object.getNacionality());
			preparedStatement.setTimestamp(6, new Timestamp(object.getBirthDate().getTime()));		
			preparedStatement.setString(7, object.getGender().toString());			
			preparedStatement.setString(8, object.getAddress());
			preparedStatement.setString(9, object.getSpouse());
			preparedStatement.setInt(10, object.getId());
			
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

		String deleteSQL = "DELETE FROM AUTHOR WHERE ID_AUTHOR = ?;";

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

		String deleteSQL = "DELETE FROM AUTHOR;";

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
