package br.com.estore.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.estore.web.factory.ConnectionFactory;
import br.com.estore.web.model.PublishingHouseBean;

public class PublishingHouseDAO implements GenericDAO<PublishingHouseBean> {

	@Override
	public List<PublishingHouseBean> getAll() throws ClassNotFoundException,
			SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "SELECT * FROM mydb.publishing_house;";

			preparedStatement = dbConnection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();

			List<PublishingHouseBean> listOfPublishingHouses = new ArrayList<PublishingHouseBean>();

			while (rs.next()) {

				PublishingHouseBean PublishingHouse = new PublishingHouseBean();
				PublishingHouse.setId(rs.getInt("ID_PUBLISHING_HOUSE"));
				PublishingHouse.setName(rs.getString("NAME"));
				PublishingHouse.setCompanyName(rs.getString("COMPANY_NAME"));
				PublishingHouse.setEmail(rs.getString("EMAIL"));
				PublishingHouse.setCnpj(rs.getString("CNPJ"));
				PublishingHouse.setIe(rs.getString("IE"));
				PublishingHouse.setSite(rs.getString("SITE"));
				PublishingHouse.setPhone(rs.getString("PHONE"));
				PublishingHouse.setAddress(rs.getString("ADDRESS"));
				PublishingHouse.setHead(rs.getString("head"));
	
				listOfPublishingHouses.add(PublishingHouse);
			}

			return listOfPublishingHouses;

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
	public PublishingHouseBean save(PublishingHouseBean pPublishingHouse)
			throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null; 
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "INSERT INTO mydb.publishing_house (NAME, COMPANY_NAME, EMAIL, CNPJ, IE, SITE, PHONE, "
					+ " ADDRESS, head) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			preparedStatement = dbConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, pPublishingHouse.getName());
			preparedStatement.setString(2, pPublishingHouse.getCompanyName());
			preparedStatement.setString(3, pPublishingHouse.getEmail());
			preparedStatement.setString(4, pPublishingHouse.getCnpj());
			preparedStatement.setString(5, pPublishingHouse.getIe());
			preparedStatement.setString(6, pPublishingHouse.getSite());
			preparedStatement.setString(7, pPublishingHouse.getPhone());
			preparedStatement.setString(8, pPublishingHouse.getAddress());
			preparedStatement.setString(9, pPublishingHouse.getHead());

			if (preparedStatement.executeUpdate() == 1) {
				// execute insert SQL stetement
				resultSet = preparedStatement.getGeneratedKeys();
                if(resultSet.next())
                {
                	pPublishingHouse.setId(resultSet.getInt(1));
                }
                
				return pPublishingHouse;
			}

			return pPublishingHouse;
			
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
	public PublishingHouseBean get(Integer pID) throws ClassNotFoundException,
			SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "SELECT * FROM mydb.publishing_house WHERE ID_PUBLISHING_HOUSE = ?;";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, pID);

			ResultSet rs = preparedStatement.executeQuery();

			PublishingHouseBean PublishingHouse = new PublishingHouseBean();
			
			if (rs.next()) {
				
				
				PublishingHouse.setId(rs.getInt("ID_PUBLISHING_HOUSE"));
				PublishingHouse.setName(rs.getString("NAME"));
				PublishingHouse.setCompanyName(rs.getString("COMPANY_NAME"));
				PublishingHouse.setEmail(rs.getString("EMAIL"));
				PublishingHouse.setCnpj(rs.getString("CNPJ"));
				PublishingHouse.setIe(rs.getString("IE"));
				PublishingHouse.setSite(rs.getString("SITE"));
				PublishingHouse.setPhone(rs.getString("PHONE"));
				PublishingHouse.setAddress(rs.getString("ADDRESS"));
				PublishingHouse.setHead(rs.getString("head"));
			}

			return PublishingHouse;

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
	public boolean update(PublishingHouseBean pPublishingHouse)
			throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "UPDATE `mydb`.`publishing_house` SET"+
							 "NAME =?, "+
							 "COMPANY_NAME = ?,"+ 
							 "EMAIL = ?, "+
							 "CNPJ = ?, "+
							 "IE = ?, "+
							 "SITE = ?," +
							 "PHONE = ?, "+
							 "ADDRESS = ?,"+ 
							 "head = ?"+
						"WHERE ID_PUBLISHING_HOUSE = ?";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, pPublishingHouse.getName());
			preparedStatement.setString(2, pPublishingHouse.getCompanyName());
			preparedStatement.setString(3, pPublishingHouse.getEmail());
			preparedStatement.setString(4, pPublishingHouse.getCnpj());
			preparedStatement.setString(5, pPublishingHouse.getIe());
			preparedStatement.setString(6, pPublishingHouse.getSite());
			preparedStatement.setString(7, pPublishingHouse.getPhone());
			preparedStatement.setString(8, pPublishingHouse.getAddress());
			preparedStatement.setString(9, pPublishingHouse.getHead());
			preparedStatement.setInt(10, pPublishingHouse.getId());
			

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
	public boolean delete(PublishingHouseBean pPublishingHouse)
			throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

			String sql = "DELETE FROM `mydb`.`publishing_house`"
					+ "WHERE ID_PUBLISHING_HOUSE = ?";
	
			try {
				dbConnection = ConnectionFactory.getConnection();
				preparedStatement = dbConnection.prepareStatement(sql);
				preparedStatement.setLong(1, pPublishingHouse.getId());

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
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "DELETE FROM `mydb`.`publishing_house`";

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
