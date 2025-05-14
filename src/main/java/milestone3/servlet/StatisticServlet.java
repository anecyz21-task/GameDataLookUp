package milestone3.servlet;

import milestone3.dal.ConnectionManager;
import milestone3.dal.StatisticDao;
import milestone3.dal.CharacterDao;
import milestone3.model.Statistic;
import milestone3.model.Character;
import milestone3.model.Statistic.StatisticName;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;

@WebServlet("/statistics")
public class StatisticServlet extends HttpServlet { 
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String idParam = req.getParameter("characterid");
    Map<String, String> messages = new HashMap<>();
    req.setAttribute("messages", messages);

    if (idParam == null || idParam.trim().isEmpty()) {
      messages.put("title", "Missing character ID.");
    } else {
      try (Connection cxn = ConnectionManager.getConnection()) {
        int characterId = Integer.parseInt(idParam);
        List<Statistic> stats = StatisticDao.getAllStatsForCharacter(cxn, characterId);
        Character character = CharacterDao.getCharacterById(cxn, characterId);
        req.setAttribute("statistics", stats);
        messages.put("title", "Statistics for firstname: " + character.getFirstName()+" and lastname: " + character.getLastName());
      } catch (Exception e) {
        e.printStackTrace();
        throw new IOException(e);
      }
    }

    req.getRequestDispatcher("/Statistics.jsp").forward(req, resp);
  }
}
