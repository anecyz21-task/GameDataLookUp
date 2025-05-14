package milestone3.servlet;

import milestone3.dal.PlayerDao;
import milestone3.model.Player;
import milestone3.dal.ConnectionManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/playerupdate")
public class UpdatePlayerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String, String> messages = new HashMap<>();
        req.setAttribute("messages", messages);

        // Search for players via email
        String email = req.getParameter("email");
        if (email == null || email.trim().isEmpty()) {
            messages.put("success", "Please enter a valid email.");
        } else {
            try (Connection cxn = ConnectionManager.getConnection()) {
                Player player = PlayerDao.getPlayerByEmail(cxn, email);
                if (player == null) {
                    messages.put("success", "Player not found.");
                }
                req.setAttribute("player", player);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
        }
        
        req.getRequestDispatcher("/UpdatePlayer.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String, String> messages = new HashMap<>();
        req.setAttribute("messages", messages);

        String email = req.getParameter("email");
        if (email == null || email.trim().isEmpty()) {
            messages.put("success", "Please enter a valid email.");
        } else {
            try (Connection cxn = ConnectionManager.getConnection()) {
                Player player = PlayerDao.getPlayerByEmail(cxn, email);
                if (player == null) {
                    messages.put("success", "Player not found.");
                } else {
                    // Update player information
                    String newFirstName = req.getParameter("firstname");
                    String newLastName = req.getParameter("lastname");
                    
                    if (newFirstName == null || newFirstName.trim().isEmpty() || 
                        newLastName == null || newLastName.trim().isEmpty()) {
                        messages.put("success", "Please provide first and last name.");
                    } else {
                        player = PlayerDao.update(cxn, email, newFirstName, newLastName);
                        messages.put("success", "Successfully updated " + email);
                    }
                }
                req.setAttribute("player", player);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new IOException(e);
            }
        }
        
        req.getRequestDispatcher("/UpdatePlayer.jsp").forward(req, resp);
    }
}