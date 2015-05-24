package br.com.estore.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.estore.web.factory.ConnectionFactory;
import br.com.estore.web.model.CustomerBean;

public class CustomerDAO implements GenericDAO<CustomerBean> {

	@Override
	public List<CustomerBean> getAll() throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerBean save(CustomerBean pCustomer)
			throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "INSERT INTO `mydb`.` customer`" + "( "
				+ "`IS_ADMIN`," + "`LOGIN`," + "`PASSWORD`," + "`NAME`,"
				+ "`EMAIL`," + "`GENDER`," + "`PHONE`," + "`ADDRESS`)"
				+ "VALUES" + "(" + "?," + "?," + "?," + "?," + "?,"
				+ "?," + "?," + "?" + ");";

		try {

			dbConnection = ConnectionFactory.getConnection();

			preparedStatement = dbConnection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, pCustomer.getLogin());
			preparedStatement.setString(3, pCustomer.getPassword());
			preparedStatement.setString(4, pCustomer.getName());
			preparedStatement.setString(5, pCustomer.getEmail());
			preparedStatement.setString(6, pCustomer.getGender());
			preparedStatement.setString(7, pCustomer.getPhone());
			preparedStatement.setString(8, pCustomer.getAddress());

			if (preparedStatement.executeUpdate() == 1) {
				// execute insert SQL stetement
				resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                {
                	pCustomer.setId(resultSet.getInt(1));
                }
				return pCustomer;
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
	public CustomerBean get(Integer id) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerBean get(CustomerBean pCustomer)
			throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectTableSQL = "SELECT" + "` customer`.`ID`,"
				+ "` customer`.`IS_ADMIN`," + "` customer`.`LOGIN`,"
				+ "` customer`.`PASSWORD`," + "` customer`.`NAME`,"
				+ "` customer`.`EMAIL`," + "` customer`.`GENDER`,"
				+ "` customer`.`PHONE`," + "` customer`.`ADDRESS`" + "FROM"
				+ "	`mydb`.` customer`" + "WHERE" + "	` customer`.`LOGIN` = ?"
				+ "AND" + "	` customer`.`PASSWORD` = ?;";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(selectTableSQL);

			preparedStatement.setString(1, pCustomer.getLogin());
			preparedStatement.setString(2, pCustomer.getPassword());

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			CustomerBean customer = null;
			if (rs.next()) {
				customer = new CustomerBean();
				customer.setId(rs.getInt("ID"));
				customer.setIs_admin(rs.getInt("IS_ADMIN"));
				customer.setLogin(rs.getString("LOGIN"));
				customer.setPassword(rs.getString("PASSWORD"));
				customer.setName(rs.getString("NAME"));
				customer.setEmail(rs.getString("EMAIL"));
				customer.setGender(rs.getString("GENDER"));
				customer.setPhone(rs.getString("PHONE"));
				customer.setAddress(rs.getString("ADDRESS"));
			}
			return customer;
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
	public boolean update(CustomerBean object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(CustomerBean object) throws ClassNotFoundException,
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
