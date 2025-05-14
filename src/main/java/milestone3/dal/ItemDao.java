package milestone3.dal;

import milestone3.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemDao {
	private ItemDao() {}
	
	public static Item create(Connection cxn, String itemName, int itemLevel, int itemMax, double itemPrice) throws SQLException {
	    final String insertItem = 
    		"INSERT INTO Item (itemName, itemLevel, itemMax, itemPrice) VALUES (?, ?, ?, ?);";
	    
	    try (PreparedStatement insertStmt = cxn.prepareStatement(insertItem,  Statement.RETURN_GENERATED_KEYS)) {
	        insertStmt.setString(1, itemName);
	        insertStmt.setInt(2, itemLevel);
	        insertStmt.setInt(3, itemMax);
	        insertStmt.setDouble(4, itemPrice);
	        insertStmt.executeUpdate();
	        
	        return new Item(Utils.getAutoIncrementKey(insertStmt),
							itemName, itemLevel, itemMax, itemPrice);
	    }
	}
	
	public static Item getItemById(Connection cxn, int itemId)  throws SQLException {
	    String selectItem = "SELECT * FROM Item WHERE itemId = ?";
	    
	    try (PreparedStatement selectStmt = cxn.prepareStatement(selectItem)) {
	        selectStmt.setInt(1, itemId);

	        try (ResultSet results = selectStmt.executeQuery()) {
	        	if (results.next()) {
	        		return new Item(
        				itemId,
        				results.getString("itemName"),
        				results.getInt("itemLevel"),
        				results.getInt("itemMax"),
        				results.getDouble("itemPrice")
    				);
	        	} else {
	        		return null;
	          }
	        }
	      }
	}
}