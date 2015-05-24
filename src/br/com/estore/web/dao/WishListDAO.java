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
import br.com.estore.web.model.WishListBean;

public class WishListDAO implements GenericDAO<WishListBean> {

	@Override
	public List<WishListBean> getAll() throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WishListBean> getAll(Integer CustomerID)
			throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "SELECT wish_list.ID_LIST, wish_list.DATE_WISH_LIST, wish_list.CUSTOMER_ID, wish_list.ID_BOOK FROM mydb.wish_list WHERE wish_list.CUSTOMER_ID = ? ;";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, CustomerID);

			ResultSet rs = preparedStatement.executeQuery();

			List<WishListBean> wishList = new ArrayList<WishListBean>();

			WishListBean wish = null;
			while (rs.next()) {
				wish = new WishListBean();
				wish.setId(rs.getInt("ID_LIST"));
				wish.setDate(new Date(rs.getTimestamp("DATE_WISH_LIST")
						.getTime()));
				wish.setCustomerID(rs.getInt("CUSTOMER_ID"));
				wish.setBookID(rs.getInt("ID_BOOK"));
				wishList.add(wish);
			}

			return wishList;

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
	public WishListBean save(WishListBean pWishList)
			throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String sql = "INSERT INTO mydb.wish_list (DATE_WISH_LIST, CUSTOMER_ID, ID_BOOK) VALUES ( ?, ?, ? );";

		try {

			dbConnection = ConnectionFactory.getConnection();

			preparedStatement = dbConnection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setTimestamp(1, new Timestamp(pWishList.getDate()
					.getTime()));
			preparedStatement.setInt(2, pWishList.getCustomerID());
			preparedStatement.setInt(3, pWishList.getBookID());

			if (preparedStatement.executeUpdate() == 1) {
				// execute insert SQL stetement
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					pWishList.setId(resultSet.getInt(1));
				}
				return pWishList;
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
	public WishListBean get(Integer id) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(WishListBean object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(WishListBean object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(int customerId, int bookId) throws ClassNotFoundException,
			SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sql = "DELETE FROM wish_list WHERE CUSTOMER_ID = ? AND ID_BOOK = ?; ";

		try {

			dbConnection = ConnectionFactory.getConnection();

			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setInt(1, customerId);
			preparedStatement.setInt(2, bookId);

			int rs = preparedStatement.executeUpdate();

			if (rs > 0) {
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
		// TODO Auto-generated method stub
		return false;
	}

}
