package br.com.estore.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.estore.web.factory.ConnectionFactory;
import br.com.estore.web.model.BookBean;

public class BookDAO implements GenericDAO<BookBean> {

	@Override
	public List<BookBean> getAll() throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
		try {

			dbConnection = ConnectionFactory.getConnection();

			String sql = "SELECT" + "` book`.`ID_BOOK`," + "` book`.`TITLE`,"
					+ "` book`.`PRICE`," + "` book`.`ISBN`,"
					+ "` book`.`NUMBER_PAGES`," + "` book`.`DESCRIPTION`,"
					+ "` book`.`IMAGE_DIRETORY`," + "` book`.`LIKEBOOK`,"
					+ "` book`.`ID_AUTHOR`," + "` book`.`ID_PUBLISHING_HOUSE`,"
					+ "` book`.`ID_CATEGORY`" + "FROM `mydb`.` book`;";

			preparedStatement = dbConnection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();

			List<BookBean> listOfBooks = new ArrayList<BookBean>();

			while (rs.next()) {
				BookBean book = new BookBean();
				book.setId(rs.getInt("ID_BOOK"));
				book.setTitle(rs.getString("TITLE"));
				book.setPrice(rs.getDouble("PRICE"));
				book.setIsbn(rs.getInt("ISBN"));
				book.setNumerPages(rs.getInt("NUMBER_PAGES"));
				book.setDescription(rs.getString("DESCRIPTION"));
				book.setImageDirectory(rs.getString("IMAGE_DIRETORY"));
				book.setLikebook(rs.getInt("LIKEBOOK"));
				book.setAuthorId(rs.getInt("ID_AUTHOR"));
				book.setPublishingHouseId(rs.getInt("ID_PUBLISHING_HOUSE"));
				book.setCategoryId(rs.getInt("ID_CATEGORY"));
				listOfBooks.add(book);
			}

			return listOfBooks;

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
	public BookBean save(BookBean pBook) throws ClassNotFoundException,
			SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sql = "INSERT INTO book ( TITLE, PRICE, ISBN, NUMBER_PAGES, DESCRIPTION, IMAGE_DIRETORY, LIKEBOOK, ID_AUTHOR, ID_PUBLISHING_HOUSE,"
				+ " ID_CATEGORY) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? );";

		try {

			dbConnection = ConnectionFactory.getConnection();

			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setString(1, pBook.getTitle());
			preparedStatement.setDouble(2, pBook.getPrice());
			preparedStatement.setInt(3, pBook.getIsbn());
			preparedStatement.setInt(4, pBook.getNumerPages());
			preparedStatement.setString(5, pBook.getDescription());
			preparedStatement.setString(6, pBook.getImageDirectory());
			preparedStatement.setInt(7, pBook.getLikebook());
			preparedStatement.setInt(8, pBook.getAuthorId());
			preparedStatement.setInt(9, pBook.getPublishingHouseId());
			preparedStatement.setInt(10, pBook.getCategoryId());

			preparedStatement.executeQuery();

			return pBook;

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
	public BookBean get(Integer id) throws ClassNotFoundException, SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectTableSQL = "SELECT * FROM book WHERE ID_BOOK = ?";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(selectTableSQL);

			preparedStatement.setInt(1, id);

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			BookBean book = null;
			if (rs.next()) {
				book = new BookBean();
				book.setId(rs.getInt("ID_BOOK"));
				book.setTitle(rs.getString("TITLE"));
				book.setPrice(rs.getDouble("PRICE"));
				book.setIsbn(rs.getInt("ISBN"));
				book.setNumerPages(rs.getInt("NUMBER_PAGES"));
				book.setDescription(rs.getString("DESCRIPTION"));
				book.setImageDirectory(rs.getString("IMAGE_DIRETORY"));
				book.setLikebook(rs.getInt("LIKEBOOK"));
				book.setAuthorId(rs.getInt("ID_AUTHOR"));
				book.setPublishingHouseId(rs.getInt("ID_PUBLISHING_HOUSE"));
				book.setCategoryId(rs.getInt("ID_CATEGORY"));
			}
			return book;
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
	public boolean update(BookBean pBook) throws ClassNotFoundException,
			SQLException {

		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sql = "UPDATE book" + "SET" + "TITLE = ?," + "PRICE = ?,"
				+ "ISBN = ?," + "NUMBER_PAGES = ?," + "DESCRIPTION = ?,"
				+ "IMAGE_DIRETORY = ?," + "LIKEBOOK = ?," + "ID_AUTHOR = ?,"
				+ "ID_PUBLISHING_HOUSE = ?," + "ID_CATEGORY = ?"
				+ "WHERE ID_BOOK = ?;";

		try {

			dbConnection = ConnectionFactory.getConnection();

			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setString(1, pBook.getTitle());
			preparedStatement.setDouble(2, pBook.getPrice());
			preparedStatement.setInt(3, pBook.getIsbn());
			preparedStatement.setInt(4, pBook.getNumerPages());
			preparedStatement.setString(5, pBook.getDescription());
			preparedStatement.setString(6, pBook.getImageDirectory());
			preparedStatement.setInt(7, pBook.getLikebook());
			preparedStatement.setInt(8, pBook.getAuthorId());
			preparedStatement.setInt(9, pBook.getPublishingHouseId());
			preparedStatement.setInt(10, pBook.getCategoryId());
			preparedStatement.setInt(14, pBook.getId());

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
	public boolean delete(BookBean pBook) throws ClassNotFoundException,
			SQLException {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String sql = "DELETE FROM book" + "WHERE book.ID_BOOK = ? ";

		try {

			dbConnection = ConnectionFactory.getConnection();

			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setInt(1, pBook.getId());

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

		String sql = "DELETE FROM book";

		try {

			dbConnection = ConnectionFactory.getConnection();

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
