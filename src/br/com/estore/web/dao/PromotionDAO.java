package br.com.estore.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estore.web.factory.ConnectionFactory;
import br.com.estore.web.model.PromotionBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;


public class PromotionDAO implements GenericDAO<PromotionBean> {

	@Override
	public List<PromotionBean> getAll() throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub

		List<PromotionBean> listPromotion = new ArrayList<>();
		Connection dbConnection = null;
		Statement statement = null;

		String selectTabletSql = "SELECT * FROM PROMOTION;";

		try {
			dbConnection = ConnectionFactory.getConnection();
			statement = dbConnection.createStatement();

			ResultSet rs = statement.executeQuery(selectTabletSql);

			while (rs.next()) {
				PromotionBean promotionBean = new PromotionBean();
				promotionBean.setId(rs.getInt("Id"));
				promotionBean.setDescription(rs.getString("Description"));
				promotionBean.setInitialDate(new Date(rs.getTimestamp("InitialDate").getTime()));
				promotionBean.setEndDate(new Date(rs.getTimestamp("EndDate").getTime()));
				promotionBean.setTypeDiscount(rs.getString("TypeDiscount"));
				promotionBean.setDiscountValue(rs.getDouble("DiscountValue"));

				listPromotion.add(promotionBean);
			}
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}

		return listPromotion;
	}

	@Override
	public PromotionBean save(PromotionBean object)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		String insertTableSql = "INSERT INTO PROMOTION (Description,InitialDate, EndDate, TypeDiscount, DiscountValue ) VALUES (?,?,?,?,?);";
				
		
		try
		{
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSql, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, object.getDescription());
			preparedStatement.setTimestamp(2, new Timestamp(object.getInitialDate().getTime()));
			preparedStatement.setTimestamp(3, new Timestamp(object.getEndDate().getTime()));
			preparedStatement.setString(4, object.getTypeDiscount());
			preparedStatement.setDouble(5, object.getDiscountValue());
			
			if(preparedStatement.executeUpdate() == 1)
			{
				rs = preparedStatement.getGeneratedKeys();
				
				if(rs.next())
				{
					object.setId(rs.getInt(1));
				}
				
				return object;
			}
		
		}finally{
		
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
	public PromotionBean get(Integer id) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		
		String selectTableSQL = "SELECT * FROM PROMOTION WHERE ID = ?;";		
				
		try
		{
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(selectTableSQL, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, id);
			
			if(preparedStatement.executeUpdate() == 1)
			{
				ResultSet rs = preparedStatement.getGeneratedKeys();
				while(rs.next())
				{
					PromotionBean promotionBean = new PromotionBean();
					promotionBean.setId(rs.getInt("Id"));
					promotionBean.setDescription(rs.getString("Description"));
					promotionBean.setInitialDate(new Timestamp(rs.getTimestamp("InitialDate").getTime()));
					promotionBean.setEndDate(new Timestamp(rs.getTimestamp("EndDate").getTime()));
					promotionBean.setTypeDiscount(rs.getString("TypeDiscount"));
					promotionBean.setDiscountValue(rs.getInt("DiscountValue"));
					
					return promotionBean;
					
				}
			}
			
			
		}finally{
			
			if(preparedStatement != null)
			{
				preparedStatement.close();
			}
			
			if(dbConnection != null)
			{
				dbConnection.close();
			}
		}
		
		return null;
	}

	@Override
	public boolean update(PromotionBean object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String sqlUpdateTable = "UPDATE PROMOTION SET DESCRIPTION = ?, INITIALDATE = ?,"+
								"ENDDATE = ?, TYPEDISCOUNT =?, DISCOUNTVALUE = ? WHERE"	+ 
								" ID = ?;";			
		
		try{
			
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(sqlUpdateTable, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, object.getDescription());
			preparedStatement.setTimestamp(2, new Timestamp(object.getInitialDate().getTime()));
			preparedStatement.setTimestamp(3, new Timestamp(object.getEndDate().getTime()));
			preparedStatement.setString(4, object.getTypeDiscount());
			preparedStatement.setDouble(5, object.getDiscountValue());
			preparedStatement.setDouble(6, object.getId());

			if (preparedStatement.executeUpdate() == 1) {
				return true;
			}
			
			
		}finally{
			
			if(dbConnection != null){
				dbConnection.close();
			}
			if(preparedStatement != null){
				preparedStatement.close();
			}
				
		}
		
		return false;
	}

	@Override
	public boolean delete(PromotionBean object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		String sqlDelete = "DELETE FROM PROMOTION WHERE ID =?;";
		
		try{	
			
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(sqlDelete, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setInt(1, object.getId());		

			if (preparedStatement.executeUpdate() == 1) {
				return true;
			}
			
		}finally{
			
			if(dbConnection != null){
				dbConnection.close();
			}
			
			if(preparedStatement != null)
			{
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

		String deleteSQL = "DELETE FROM PROMOTION;";

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
