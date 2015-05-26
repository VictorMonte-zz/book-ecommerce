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
import br.com.estore.web.model.CommentBean;
import br.com.estore.web.model.CustomerBean;

public class CommentDAO implements GenericDAO<CommentBean> {

	public List<CommentBean> getAll(int id) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		List<CommentBean> listComment = new ArrayList<>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		CustomerBean customer = null;
		CustomerDAO dao = null;

		String selectTableSQL = "SELECT * FROM mydb.comentary WHERE ID_BOOK = ?";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(selectTableSQL,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				
				
				CommentBean commentBean = new CommentBean();
				commentBean.setId(rs.getInt("ID_COMENTARY"));
				commentBean.setDescription(rs.getString("DESCRIPTION"));
				commentBean.setDateComment(new Date(rs.getTimestamp("DATECOMENTARY").getTime()));
				commentBean.setIdCustomer(rs.getInt("CUSTOMER_ID"));
				commentBean.setIdBook(rs.getInt("ID_BOOK"));
				
				customer = new CustomerBean();
				dao = new CustomerDAO();
				customer = dao.get(rs.getInt("ID_BOOK"));
				
				commentBean.setCustomer(customer);

				listComment.add(commentBean);
			}
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (dbConnection != null) {
				dbConnection.close();
			}
		}
		return listComment;
	}

	
	@Override
	public CommentBean save(CommentBean object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String insertTableSQL = "INSERT INTO `mydb`.`comentary`"+
		"(`DESCRIPTION`,`DATECOMENTARY`,`CUSTOMER_ID`,`ID_BOOK`)" +
		"VALUES(?,?,?,?);";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, object.getDescription());
			preparedStatement.setTimestamp(2, new Timestamp(object.getDateComment().getTime()));
			preparedStatement.setInt(3, object.getIdCustomer());
			preparedStatement.setInt(4, object.getIdBook());

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
	public List<CommentBean> getAll() throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentBean get(Integer id) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(CommentBean object) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(CommentBean object) throws ClassNotFoundException,
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
