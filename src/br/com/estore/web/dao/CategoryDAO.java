package br.com.estore.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.estore.web.factory.ConnectionFactory;
import br.com.estore.web.model.CategoryBean;


public class CategoryDAO implements GenericDAO<CategoryBean> {

	@Override
	public List<CategoryBean> getAll() throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub

		List<CategoryBean> listCategory = new ArrayList<>();
		Connection dbConnection = null;
		Statement statement = null;

		String selectTabletSql = "SELECT * FROM CATEGORY;";

		try {
			dbConnection = ConnectionFactory.getConnection();
			statement = dbConnection.createStatement();

			ResultSet rs = statement.executeQuery(selectTabletSql);

			while (rs.next()) {
				CategoryBean categoryBean = new CategoryBean();
				categoryBean.setId(rs.getInt("Id"));
				categoryBean.setDescription(rs.getString("Description"));

				listCategory.add(categoryBean);
			}
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}

		return listCategory;
	}

	@Override
	public CategoryBean save(CategoryBean object)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		String insertTableSql = "INSERT INTO CATEGORY (Description ) VALUES (?);";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSql,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, object.getDescription());

			if (preparedStatement.executeUpdate() == 1) {
				rs = preparedStatement.getGeneratedKeys();

				if (rs.next()) {
					object.setId(rs.getInt(1));
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
	public CategoryBean get(Integer id) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectTableSQL = "SELECT * FROM CATEGORY WHERE ID = ?;";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(selectTableSQL,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, id);

			if (preparedStatement.executeUpdate() == 1) {
				ResultSet rs = preparedStatement.getGeneratedKeys();
				while (rs.next()) {
					CategoryBean categoryBean = new CategoryBean();
					categoryBean.setId(rs.getInt("Id"));
					categoryBean.setDescription(rs.getString("Description"));

					return categoryBean;

				}
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
	public boolean update(CategoryBean object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sqlUpdateTable = "UPDATE CATEGORY SET DESCRIPTION = ? WHERE ID = ?;";

		try {

			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(sqlUpdateTable,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, object.getDescription());
			preparedStatement.setInt(2, object.getId());
			

			if (preparedStatement.executeUpdate() == 1) {
				return true;
			}

		} finally {

			if (dbConnection != null) {
				dbConnection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}

		}

		return false;
	}

	@Override
	public boolean delete(CategoryBean object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sqlDelete = "DELETE FROM CATEGORY WHERE ID =?;";

		try {

			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(sqlDelete,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, object.getId());

			if (preparedStatement.executeUpdate() == 1) {
				return true;
			}

		} finally {

			if (dbConnection != null) {
				dbConnection.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}

		return false;

	}

	@Override
	public boolean deleteAll() throws ClassNotFoundException, SQLException {

		// TODO Auto-generated method stub
		Connection dbConnection = null;
		Statement statement = null;

		String deleteSQL = "DELETE FROM CATEGORY;";

		try {
			dbConnection = ConnectionFactory.getConnection();
			statement = dbConnection.createStatement();

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
