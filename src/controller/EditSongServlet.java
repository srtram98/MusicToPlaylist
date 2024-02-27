package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Song;

/**
 * Servlet implementation class EditSongServlet
 */
@WebServlet("/editSongServlet")
public class EditSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SongHelper sh = new SongHelper();
		
		String title = request.getParameter("title");
		String artist = request.getParameter("artist");
		String genre = request.getParameter("genre");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Song itemToUpdate = sh.searchForItemById(tempId);
		itemToUpdate.setTitle(title);
		itemToUpdate.setArtist(artist);
		itemToUpdate.setGenre(genre);
		
		sh.updateItem(itemToUpdate);
		
		getServletContext().getRequestDispatcher("/viewSongsServlet").forward(request, response);
	}

}
