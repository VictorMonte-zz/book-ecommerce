package br.com.estore.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

			String sql = "SELECT editora.ID_EDITORA, editora.NOME, editora.E-MAIL, editora.TELEFONE, editora.CONTATO,"
					+ " editora.CNPJ, editora.IE, editora.SITE, editora.RAZÃO SOCIAL FROM mydb.editora";

			preparedStatement = dbConnection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();

			List<PublishingHouseBean> listOfPublishingHouses = new ArrayList<PublishingHouseBean>();

			while (rs.next()) {

				PublishingHouseBean PublishingHouse = new PublishingHouseBean();
				PublishingHouse.setId(rs.getInt("ID_EDITORA"));
				PublishingHouse.setName(rs.getString("NOME"));
				PublishingHouse.setEmail(rs.getString("E-MAIL"));
				PublishingHouse.setPhone(rs.getString("TELEFONE"));
				PublishingHouse.setContact(rs.getString("CONTATO"));
				PublishingHouse.setCnpj(rs.getString("CNPJ"));
				PublishingHouse.setIe(rs.getString("IE"));
				PublishingHouse.setSite(rs.getString("SITE"));
				PublishingHouse.setSocialReason(rs.getString("RAZÃO SOCIAL"));

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
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "INSERT INTO mydb.editora (NOME, E-MAIL, TELEFONE, CONTATO, CNPJ, IE, SITE, "
					+ " RAZÃO SOCIAL) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, pPublishingHouse.getName());
			preparedStatement.setString(2, pPublishingHouse.getEmail());
			preparedStatement.setString(3, pPublishingHouse.getPhone());
			preparedStatement.setString(3, pPublishingHouse.getContact());
			preparedStatement.setString(4, pPublishingHouse.getCnpj());
			preparedStatement.setString(5, pPublishingHouse.getIe());
			preparedStatement.setString(6, pPublishingHouse.getSite());
			preparedStatement.setString(7, pPublishingHouse.getSocialReason());

			preparedStatement.executeQuery();

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

			String sql = "SELECT editora.ID_EDITORA, editora.NOME, editora.E-MAIL, editora.TELEFONE, editora.CONTATO,"
					+ " editora.CNPJ, editora.IE, editora.SITE, editora.RAZÃO SOCIAL FROM mydb.editora WHERE "
					+ " editora.ID_EDITORA = ?";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, pID);

			ResultSet rs = preparedStatement.executeQuery();

			PublishingHouseBean PublishingHouse = null;
			if (rs.next()) {

				PublishingHouse = new PublishingHouseBean();
				PublishingHouse.setId(rs.getInt("ID_EDITORA"));
				PublishingHouse.setName(rs.getString("NOME"));
				PublishingHouse.setEmail(rs.getString("E-MAIL"));
				PublishingHouse.setPhone(rs.getString("TELEFONE"));
				PublishingHouse.setContact(rs.getString("CONTATO"));
				PublishingHouse.setCnpj(rs.getString("CNPJ"));
				PublishingHouse.setIe(rs.getString("IE"));
				PublishingHouse.setSite(rs.getString("SITE"));
				PublishingHouse.setSocialReason(rs.getString("RAZÃO SOCIAL"));
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

			String sql = "UPDATE mydb.editora SET NOME = ?, E-MAIL = ?, TELEFONE = ?, CONTATO = ?, CNPJ = ?, IE = ?, SITE = ?, RAZÃO SOCIAL = ? WHERE ID_EDITORA = ?";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setString(1, pPublishingHouse.getName());
			preparedStatement.setString(2, pPublishingHouse.getEmail());
			preparedStatement.setString(3, pPublishingHouse.getPhone());
			preparedStatement.setString(3, pPublishingHouse.getContact());
			preparedStatement.setString(4, pPublishingHouse.getCnpj());
			preparedStatement.setString(5, pPublishingHouse.getIe());
			preparedStatement.setString(6, pPublishingHouse.getSite());
			preparedStatement.setString(7, pPublishingHouse.getSocialReason());
			preparedStatement.setInt(8, pPublishingHouse.getId());
			

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
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "DELETE FROM mydb.editora"
					+ "WHERE editora.ID_EDITORA = ? ";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, pPublishingHouse.getId());

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

			String sql = "DELETE FROM mydb.editora";

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
