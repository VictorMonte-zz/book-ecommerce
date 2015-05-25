package br.com.estore.web.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;

import br.com.estore.web.dao.BookDAO;
import br.com.estore.web.dao.CustomerDAO;
import br.com.estore.web.model.BookBean;
import br.com.estore.web.model.CustomerBean;

@WebServlet("/book")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
				maxFileSize=1024*1024*10,      // 10MB
				maxRequestSize=1024*1024*50)   // 50MB
public class BookServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	/**
     * Directory where uploaded files will be saved, its relative to
     * the web application directory.
     */
    private static final String UPLOAD_DIR = "WebContent/img/capa";

	public BookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		treatRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		treatRequest(request, response);
	}

	private void treatRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		String op = request.getParameter("op");
		String url = "bookmanager.jsp", id;
		BookDAO dao = null;
		BookBean book = null;

		try {
			switch (op) {
			case "cadastrar":
				
				String title = request.getParameter("txtTitle");
				String price = request.getParameter("txtPrice");
				String pageNumber = request.getParameter("txtPageNumber");
				String description = request.getParameter("txtDescription");
				Part part = request.getPart("file");
				
				if (title != null
						&& price != null
						&& pageNumber != null
						&& description != null
						&& !request.getParts().isEmpty()) {
					
					// gets absolute path of the web application
			        String applicationPath = request.getServletContext().getRealPath("");
			        // constructs path of the directory to save uploaded file
			        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
			          
			        // creates the save directory if it does not exists
			        File fileSaveDir = new File(uploadFilePath);
			        if (!fileSaveDir.exists()) {
			            fileSaveDir.mkdirs();
			        }
			         
			        String fileName = null;
			        
			        fileName = getFileName(part);
		            part.write(uploadFilePath + File.separator + fileName);
			        
			        //Get all the parts from request and write it to the file on server
		            /*
			        for (Part part : request.getParts()) {
			        	if(part.getSize() > 0){
			        		fileName = getFileName(part);
				            part.write(uploadFilePath + File.separator + fileName);
			        	}
			        }
			        */
			        
			        dao = new BookDAO();
			        
			        book = new BookBean();
			        book.setTitle(title);
			        book.setPrice(Double.valueOf(price));
			        book.setNumerPages(Integer.valueOf(pageNumber));
			        book.setDescription(description);
			        book.setImageDirectory(fileName);
			        book.setAuthorId(1);
			        book.setPublishingHouseId(1);
			        book.setCategoryId(1);
			        
			        dao.save(book);
				}
				
				break;
			case "listar":

				dao = new BookDAO();

				List<BookBean> books = dao.getAll();

				HttpSession session = request.getSession(true);

				session.setAttribute("books", books);

				break;
			case "editar":

				book = new BookBean();
				dao = new BookDAO();

				id = request.getParameter("id");
				book = dao.get(Integer.parseInt(id));

				// em andamento

				break;
			case "deletar":

				book = new BookBean();
				dao = new BookDAO();

				id = request.getParameter("id");
				book.setId(Integer.parseInt(id));
				dao.delete(book);

				url = "book?op=listar";

			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}

	}
	
	/**
     * Utility method to get file name from HTTP header content-disposition
     */
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
}
