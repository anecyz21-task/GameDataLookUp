package milestone3.servlet;

import milestone3.dal.PlayerDao;
import milestone3.model.Player;
import milestone3.dal.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findplayer")
public class FindPlayerServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private static final String RESPONSE_MESSAGE = "response";

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    handleRequest(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    handleRequest(req, resp);
  }

  private void handleRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    Map<String, String> messages = new HashMap<>();
    req.setAttribute("messages", messages);

    String firstName = req.getParameter("firstname");

    if (firstName == null || firstName.trim().isEmpty()) {
      messages.put(RESPONSE_MESSAGE, "Please enter a valid first name.");
    } else {
      try (Connection cxn = ConnectionManager.getConnection()) {
        List<Player> players = PlayerDao.getPlayersByFirstNameLike(cxn, firstName);
        req.setAttribute("players", players);

        if (players.isEmpty()) {
          messages.put(RESPONSE_MESSAGE, "No players found for \"" + firstName + "\".");
        } else {
          messages.put(RESPONSE_MESSAGE, "Displaying results for \"" + firstName + "\".");
        }

      } catch (SQLException e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/FindPlayer.jsp").forward(req, resp);
  }
}
