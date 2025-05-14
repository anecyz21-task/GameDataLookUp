package milestone3.servlet;

import milestone3.dal.CharacterDao;
import milestone3.dal.ConnectionManager;
import milestone3.model.Character;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

@WebServlet("/characters")
public class CharactersServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String TITLE_MESSAGE = "title";
  private static final String EMAIL = "email";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Map<String, String> messages = new HashMap<>();
    req.setAttribute("messages", messages);

    List<Character> characters = new ArrayList<>();

    String email = req.getParameter("email");
    if (email == null || email.trim().isEmpty()) {
      messages.put(TITLE_MESSAGE, "Missing player email.");
    } else {
      messages.put(TITLE_MESSAGE, "Characters for " + email);
      messages.put(EMAIL, email);
      try (Connection cxn = ConnectionManager.getConnection()) {
        characters = CharacterDao.getCharactersByEmail(cxn, email);
      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.setAttribute("characters", characters);
    req.getRequestDispatcher("/Characters.jsp").forward(req, resp);
  }
}

