package br.com.estore.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.estore.web.factory.ConnectionFactory;
import br.com.estore.web.model.PaymentTypeBean;
import br.com.estore.web.model.PurchaseBean;

public class PurchaseDAO implements GenericDAO<PurchaseBean> {

	@Override
	public List<PurchaseBean> getAll() throws ClassNotFoundException,
			SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "";

			preparedStatement = dbConnection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();

			List<PurchaseBean> listOfPurchases = new ArrayList<PurchaseBean>();

			while (rs.next()) {
				PurchaseBean purchase = new PurchaseBean();
				purchase.setId(rs.getInt("ID"));
				purchase.setShoppingCartID(rs.getInt("CARRINHO_ID_CARRINHO"));
				purchase.setCustomerID(rs.getInt("CARRINHO_CLIENTE_ID_CLIENTE"));
				purchase.setWishListID(rs.getInt("LISTA DE DESEJOS_ID_LISTA"));
				purchase.setTotal(rs.getDouble("TOTAL"));
				purchase.setDate(new Date(rs.getTimestamp("DATA_HORA")
						.getTime()));

				switch (rs.getInt("FORMA DE PAGAMENTO_ID")) {
				case 1:
					purchase.setPaymentType(PaymentTypeBean.CartaoDebito);
					break;
				case 2:
					purchase.setPaymentType(PaymentTypeBean.CartaoCredito);
					break;
				case 3:
					purchase.setPaymentType(PaymentTypeBean.Dinheiro);
					break;
				}

				listOfPurchases.add(purchase);
			}

			return listOfPurchases;

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
	public PurchaseBean save(PurchaseBean pPurchase)
			throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "INSERT INTO mydb.compra (ID_COMPRA, CARRINHO_ID_CARRINHO, CARRINHO_CLIENTE_ID_CLIENTE,"
					+ " LISTA DE DESEJOS_ID_LISTA, TOTAL, DATA_HORA, FORMA DE PAGAMENTO_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";

			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setInt(1, pPurchase.getId());	
			preparedStatement.setInt(2, pPurchase.getShoppingCartID());
			preparedStatement.setInt(3, pPurchase.getCustomerID());
			preparedStatement.setInt(4, pPurchase.getWishListID());
			preparedStatement.setDouble(5, pPurchase.getTotal());
			preparedStatement.setTimestamp(6,  new Timestamp(pPurchase.getDate().getTime()));
			preparedStatement.setInt(7, pPurchase.getPaymentType().getId());

			preparedStatement.executeQuery();

			if (preparedStatement.executeUpdate() == 1) {
				// execute insert SQL stetement
				resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                {
                	pPurchase.setId(resultSet.getInt(1));
                }
				return pPurchase;
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
	public PurchaseBean get(Integer pId) throws ClassNotFoundException,
			SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "SELECT compra.ID_COMPRA, compra.CARRINHO_ID_CARRINHO, compra.CARRINHO_CLIENTE_ID_CLIENTE,"
					+ " compra.LISTA DE DESEJOS_ID_LISTA, compra.TOTAL, compra.DATA_HORA, compra.FORMA DE PAGAMENTO_ID "
					+ "FROM mydb.compra WHERE compra.ID_COMPRA = ? ";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(0, pId);

			ResultSet rs = preparedStatement.executeQuery();

			PurchaseBean purchase = null;
			if (rs.next()) {
				purchase = new PurchaseBean();
				purchase.setCustomerID(rs.getInt(1));
				purchase.setShoppingCartID(rs.getInt(2));
				purchase.setCustomerID(rs.getInt(3));
				purchase.setWishListID(rs.getInt(4));
				purchase.setTotal(rs.getDouble(5));
			}

			return purchase;

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
	public boolean update(PurchaseBean pPurchase) throws ClassNotFoundException,
			SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "UPDATE mydb.compra SET CARRINHO_ID_CARRINHO = ?, CARRINHO_CLIENTE_ID_CLIENTE = ?,"
					+ " LISTA DE DESEJOS_ID_LISTA = ?, TOTAL = ?, DATA_HORA = ?, FORMA DE PAGAMENTO_ID = ? WHERE ID_COMPRA = ? ";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, pPurchase.getShoppingCartID());
			preparedStatement.setInt(2, pPurchase.getCustomerID());
			preparedStatement.setInt(3, pPurchase.getWishListID());
			preparedStatement.setDouble(4, pPurchase.getTotal());
			preparedStatement.setTimestamp(5, new Timestamp(pPurchase.getDate().getTime()));
			preparedStatement.setDouble(6, pPurchase.getPaymentType().getId());		
			preparedStatement.setInt(7, pPurchase.getId());

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
	public boolean delete(PurchaseBean pPurchase) throws ClassNotFoundException,
			SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "DELETE FROM mydb.compra"
					+ "WHERE compra.ID_COMPRA = ? ";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, pPurchase.getId());

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

			String sql = "DELETE FROM mydb.compra";

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

}
