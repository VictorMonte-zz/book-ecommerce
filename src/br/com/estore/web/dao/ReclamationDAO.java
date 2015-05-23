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
import br.com.estore.web.model.ComplainType;
import br.com.estore.web.model.ReclamationBean;

public class ReclamationDAO implements GenericDAO<ReclamationBean> {

	@Override
	public List<ReclamationBean> getAll() throws ClassNotFoundException,
			SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "SELECT relamação_sugestão.ID_RECL_SUG, relamação_sugestão.DESCRIÇÃO, "
					+ "relamação_sugestão.DATA_HORA, relamação_sugestão.TIPO_RECL_SUGS_ID_TIPO,"
					+ " relamação_sugestão.USUARIO_CPF_CNPJ FROM mydb.relamação_sugestão ";

			preparedStatement = dbConnection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();

			List<ReclamationBean> listOfReclamation = new ArrayList<ReclamationBean>();

			while (rs.next()) {
				ReclamationBean reclamation = new ReclamationBean();
				reclamation.setId(rs.getInt("ID_RECL_SUG"));
				reclamation.setDescription(rs.getString("DESCRIÇÃO"));
				reclamation.setDate(new Date(rs.getTimestamp("DATA_HORA")
						.getTime()));
				switch (rs.getInt("TIPO_RECL_SUGS_ID_TIPO")) {
				case 1:
					reclamation.setComplainType(ComplainType.Duvida);
					break;
				case 2:
					reclamation.setComplainType(ComplainType.Reclamacao);
					break;
				case 3:
					reclamation.setComplainType(ComplainType.Sugestao);
					break;
				}

				reclamation.setCustomerID(rs.getString("USUARIO_CPF_CNPJ"));

				listOfReclamation.add(reclamation);
			}

			return listOfReclamation;

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
	public ReclamationBean save(ReclamationBean pReclamation)
			throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String insertTableSQL = "INSERT INTO mydb.relamação_sugestão (DESCRIÇÃO, DATA_HORA, "
				+ "TIPO_RECL_SUGS_ID_TIPO, USUARIO_CPF_CNPJ) VALUES "
				+ "( ?, ?, ?, ? )";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, pReclamation.getDescription());
			preparedStatement.setTimestamp(2, new Timestamp(pReclamation
					.getDate().getTime()));
			preparedStatement.setInt(3, pReclamation.getComplainType().getID());
			preparedStatement.setString(4, pReclamation.getCustomerID());

			if (preparedStatement.executeUpdate() == 1) {
				// execute insert SQL stetement
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					pReclamation.setId(resultSet.getInt(1));
				}
				return pReclamation;
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
	public ReclamationBean get(Integer pID) throws ClassNotFoundException,
			SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "SELECT relamação_sugestão.ID_RECL_SUG, relamação_sugestão.DESCRIÇÃO, "
					+ "relamação_sugestão.DATA_HORA, relamação_sugestão.TIPO_RECL_SUGS_ID_TIPO,"
					+ " relamação_sugestão.USUARIO_CPF_CNPJ FROM mydb.relamação_sugestão"
					+ " WHERE relamação_sugestão.ID_RECL_SUG = ? ";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, pID);

			ResultSet rs = preparedStatement.executeQuery();

			ReclamationBean reclamation = null;
			if (rs.next()) {
				reclamation = new ReclamationBean();
				reclamation.setId(rs.getInt("ID_RECL_SUG"));
				reclamation.setDescription(rs.getString("DESCRIÇÃO"));
				reclamation.setDate(new Date(rs.getTimestamp("DATA_HORA")
						.getTime()));
				switch (rs.getInt("TIPO_RECL_SUGS_ID_TIPO")) {
				case 1:
					reclamation.setComplainType(ComplainType.Duvida);
					break;
				case 2:
					reclamation.setComplainType(ComplainType.Reclamacao);
					break;
				case 3:
					reclamation.setComplainType(ComplainType.Sugestao);
					break;
				}

				reclamation.setCustomerID(rs.getString("USUARIO_CPF_CNPJ"));
			}

			return reclamation;

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
	public boolean update(ReclamationBean pReclamation)
			throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		String sql = "UPDATE mydb.relamação_sugestão SET DESCRIÇÃO = ?, DATA_HORA = ?, TIPO_RECL_SUGS_ID_TIPO = ?, USUARIO_CPF_CNPJ = ? WHERE ID_RECL_SUG = ?, ";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setString(1, pReclamation.getDescription());
			preparedStatement.setTimestamp(2, new Timestamp(pReclamation
					.getDate().getTime()));
			preparedStatement.setInt(3, pReclamation.getComplainType().getID());
			preparedStatement.setString(4, pReclamation.getCustomerID());
			preparedStatement.setInt(5, pReclamation.getId());

			rs = preparedStatement.executeQuery();

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
	public boolean delete(ReclamationBean pReclamation)
			throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "DELETE FROM mydb.relamação_sugestão"
					+ "WHERE relamação_sugestão.ID_RECL_SUG = ? ";

			preparedStatement = dbConnection.prepareStatement(sql);
			preparedStatement.setInt(1, pReclamation.getId());

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

			String sql = "DELETE FROM mydb.relamação_sugestão";

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
