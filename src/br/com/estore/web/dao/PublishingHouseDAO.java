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
				/*UserBean user = new UserBean();
				user.setName(rs.getString("NOME"));*/
				
				PublishingHouseBean PublishingHouse = new PublishingHouseBean();
				PublishingHouse.setId(rs.getInt("ID_EDITORA"));
				PublishingHouse.setName(rs.getString("NOME"));
				PublishingHouse.setEmail(rs.getString("E-MAIL"));
				PublishingHouse.setTelefone(rs.getString("TELEFONE"));
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
	public PublishingHouseBean save(PublishingHouseBean object)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PublishingHouseBean get(Integer id) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(PublishingHouseBean object)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PublishingHouseBean object)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
