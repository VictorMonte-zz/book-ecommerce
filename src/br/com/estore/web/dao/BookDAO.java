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

			String sql = "SELECT livro.ID_LIVRO, livro.TITULO,livro.VALOR,livro.ISBN,livro.NUMERO_DE_PAGINA,"
					+ "livro.ANO,livro.IDIOMA,livro.DESCRICAO,livro.AUTOR_ID_AUTOR,livro.CATEGORIA_ID_CATEGORIA,"
					+ "livro.EDITORA_ID_EDITORA,livro.GENERO_ID_GENERO,livro.PROMOCAO_ID_PROMOCAO,"
					+ "livro.COMENTARIO_ID_COMENTARIOFROM mydb.livro";

			preparedStatement = dbConnection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery();

			List<BookBean> listOfBooks = new ArrayList<BookBean>();

			while (rs.next()) {
				BookBean book = new BookBean();
				book.setId(rs.getInt("ID_LIVRO"));
				book.setTitle(rs.getString("TITULO"));
				book.setValue(rs.getDouble("VALOR"));
				book.setIsbn(rs.getInt("ISBN"));
				book.setPageNumber(rs.getInt("NUMERO DE PAGINA"));
				book.setYear(rs.getInt("ANO"));
				book.setIdiom(rs.getString("IDIOMA"));
				book.setDescription(rs.getString("DESCRIÇÃO"));
				book.setAuthorCode(rs.getInt("AUTOR_ID_AUTOR"));
				book.setCategorie(rs.getInt("CATEGORIA_ID_CATEGORIA"));
				book.setPublishingHouseCode(rs.getInt("EDITORA_ID_EDITORA"));
				book.setGenderCode(rs.getInt("GENERO_ID_GENERO"));
				book.setPromotionCode(rs.getInt("PROMOCAO_ID_PROMOCAO"));
				book.setCommentCode(rs.getInt("COMENTARIO_ID_COMENTARIOFROM"));
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

		String sql = "INSERT INTO mydb.livro (ID_LIVRO, TITULO, VALOR, ISBN, NUMERO_DE_PAGINA, ANO, "
				+ "IDIOMA, DESCRICAO, AUTOR_ID_AUTOR, CATEGORIA_ID_CATEGORIA,EDITORA_ID_EDITORA,GENERO_ID_GENERO,"
				+ "PROMOCAO_ID_PROMOCAO,COMENTARIO_ID_COMENTARIO)VALUES( ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {

			dbConnection = ConnectionFactory.getConnection();

			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setInt(1, pBook.getId());
			preparedStatement.setString(2, pBook.getTitle());
			preparedStatement.setDouble(3, pBook.getValue());
			preparedStatement.setInt(4, pBook.getIsbn());
			preparedStatement.setInt(5, pBook.getPageNumber());
			preparedStatement.setInt(6, pBook.getYear());
			preparedStatement.setString(7, pBook.getIdiom());
			preparedStatement.setString(8, pBook.getDescription());
			preparedStatement.setInt(9, pBook.getAuthorCode());
			preparedStatement.setInt(10, pBook.getCategorie());
			preparedStatement.setInt(11, pBook.getPublishingHouseCode());
			preparedStatement.setInt(12, pBook.getGenderCode());
			preparedStatement.setInt(13, pBook.getPromotionCode());
			preparedStatement.setInt(14, pBook.getCommentCode());

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

		String selectTableSQL = "SELECT" + "livro.ID_LIVRO," + "livro.TITULO,"
				+ "livro.VALOR," + "livro.ISBN," + "livro.NUMERO_DE_PAGINA,"
				+ "livro.ANO," + "livro.IDIOMA," + "livro.DESCRICAO,"
				+ "livro.AUTOR_ID_AUTOR," + "livro.CATEGORIA_ID_CATEGORIA,"
				+ "livro.EDITORA_ID_EDITORA," + "livro.GENERO_ID_GENERO,"
				+ "livro.PROMOCAO_ID_PROMOCAO,"
				+ "livro.COMENTARIO_ID_COMENTARIO" + "FROM " + "mydb.livro"
				+ "WHERE" + "livro.ID_LIVRO = ?";

		try {
			dbConnection = ConnectionFactory.getConnection();
			preparedStatement = dbConnection.prepareStatement(selectTableSQL);

			preparedStatement.setInt(1, id);

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
			BookBean book = null;
			if (rs.next()) {
				book = new BookBean();
				book.setId(rs.getInt("ID_LIVRO"));
				book.setTitle(rs.getString("TITLE"));
				book.setValue(rs.getDouble("VALOR"));
				book.setIsbn(rs.getInt("ISBN"));
				book.setPageNumber(rs.getInt("NUMERO_DE_PAGINA"));
				book.setYear(rs.getInt("ANO"));
				book.setIdiom(rs.getString("IDIOMA"));
				book.setDescription(rs.getString("IDIOMA"));
				book.setAuthorCode(rs.getInt("AUTOR_ID_AUTOR"));
				book.setCategorie(rs.getInt("CATEGORIA_ID_CATEGORIA"));
				book.setPublishingHouseCode(rs.getInt("EDITORA_ID_EDITORA"));
				book.setGenderCode(rs.getInt("GENERO_ID_GENERO"));
				book.setPromotionCode(rs.getInt("PROMOCAO_ID_PROMOCAO"));
				book.setCommentCode(rs.getInt("COMENTARIO_ID_COMENTARIO"));
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

		String sql = "UPDATE mydb.livro" + "SET" + "TITULO = ?,"
				+ "VALOR = {VALOR: }," + "ISBN = {ISBN: },"
				+ "NUMERO_DE_PAGINA = {NUMERO_DE_PAGINA: }," + "ANO = {ANO: },"
				+ "IDIOMA = {IDIOMA: }," + "DESCRICAO = {DESCRICAO: },"
				+ "AUTOR_ID_AUTOR = {AUTOR_ID_AUTOR: },"
				+ "CATEGORIA_ID_CATEGORIA = {CATEGORIA_ID_CATEGORIA: },"
				+ "EDITORA_ID_EDITORA = {EDITORA_ID_EDITORA: },"
				+ "GENERO_ID_GENERO = {GENERO_ID_GENERO: },"
				+ "PROMOCAO_ID_PROMOCAO = {PROMOCAO_ID_PROMOCAO: },"
				+ "COMENTARIO_ID_COMENTARIO = {COMENTARIO_ID_COMENTARIO: }"
				+ "WHERE ID_LIVRO = ?";

		try {

			dbConnection = ConnectionFactory.getConnection();

			preparedStatement = dbConnection.prepareStatement(sql);

			preparedStatement.setString(1, pBook.getTitle());
			preparedStatement.setDouble(2, pBook.getValue());
			preparedStatement.setInt(3, pBook.getIsbn());
			preparedStatement.setInt(4, pBook.getPageNumber());
			preparedStatement.setInt(5, pBook.getYear());
			preparedStatement.setString(6, pBook.getIdiom());
			preparedStatement.setString(7, pBook.getDescription());
			preparedStatement.setInt(8, pBook.getAuthorCode());
			preparedStatement.setInt(9, pBook.getCategorie());
			preparedStatement.setInt(10, pBook.getPublishingHouseCode());
			preparedStatement.setInt(11, pBook.getGenderCode());
			preparedStatement.setInt(12, pBook.getPromotionCode());
			preparedStatement.setInt(13, pBook.getCommentCode());
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

		String sql = "DELETE FROM mydb.livro"
				+ "WHERE usuario.ID_LIVRO = ? ";

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

		String sql = "DELETE FROM mydb.livro";

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
