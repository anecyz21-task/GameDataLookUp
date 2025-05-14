package milestone3.dal;

import milestone3.model.Character;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterDao {

    public CharacterDao() {
    }

    public static Character create(
            Connection cxn,
            String email,
            String firstName,
            String lastName,
            String clanName
    ) throws SQLException {
        final String insertCharacter = "INSERT INTO `Character` (email, firstName, lastName, clanName) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = cxn.prepareStatement(insertCharacter, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, email);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, clanName);
            stmt.executeUpdate();

            int characterId = Utils.getAutoIncrementKey(stmt);
            return new Character(characterId, email, firstName, lastName, clanName);
        }
    }

    public static Character getCharacterById(Connection cxn, int characterID) throws SQLException {
        final String getById = "SELECT * FROM `Character` WHERE characterID = ?";
        try (PreparedStatement stmt = cxn.prepareStatement(getById)) {
            stmt.setInt(1, characterID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Character(
                            rs.getInt("characterID"),
                            rs.getString("email"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("clanName")
                    );
                } else {
                    return null;
                }
            }
        }
    }

    public static List<Character> getCharactersByEmail(Connection cxn, String email) throws SQLException {
        List<Character> result = new ArrayList<>();
        final String query = "SELECT * FROM `Character` WHERE email = ?";
        try (PreparedStatement stmt = cxn.prepareStatement(query)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    result.add(new Character(
                            rs.getInt("characterID"),
                            rs.getString("email"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("clanName")
                    ));
                }
            }
        }
        return result;
    }
}

