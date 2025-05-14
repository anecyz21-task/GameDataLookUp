package milestone3.dal;

import milestone3.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 

public class WeaponDao {
	private WeaponDao() {}
	
	public static Weapon create(Connection cxn, String itemName, int itemLevel, int itemMax, double itemPrice, int requiredLevel, 
			int jobId, int damage) throws SQLException {
	    final String insertWeapon = 
	    		"INSERT INTO Weapon (weaponId, jobId, damage) VALUES (?, ?, ?);";

		    int weaponId = GearDao.create(cxn, itemName, itemLevel, itemMax, itemPrice, requiredLevel).getItemID();
		    
	  	    try (PreparedStatement insertStmt = cxn.prepareStatement(insertWeapon)) {
	  	        insertStmt.setInt(1, weaponId);
	  	        insertStmt.setInt(2, jobId);
	  	      insertStmt.setInt(3, damage);
	  	        insertStmt.executeUpdate();
	  	        
	  	        return new Weapon(weaponId, itemName, itemLevel, itemMax, itemPrice, requiredLevel, jobId, damage);
	  	    }
	}
	
	public static Weapon getWeaponById(Connection cxn, int weaponId) throws SQLException {
	    String selectWeapon = """
			SELECT Item.itemName AS itemName, Item.itemLevel AS itemLevel, Item.itemMax AS itemMax, Item.itemPrice AS itemPrice, 
	    		Gear.requiredLevel AS requiredLevel, Weapon.jobId AS jobId, Weapon.damage AS damage
			FROM Gear INNER JOIN Item ON Gear.gearId = Item.itemId INNER JOIN Weapon ON Item.itemId = Weapon.weaponId
			WHERE weaponId = ?""";
	    
	    try (PreparedStatement selectStmt = cxn.prepareStatement(selectWeapon)) {
	        selectStmt.setInt(1, weaponId);

	        try (ResultSet results = selectStmt.executeQuery()) {
	        	if (results.next()) {
	        		return new Weapon(
        				weaponId,
        				results.getString("itemName"),
        				results.getInt("itemLevel"),
        				results.getInt("itemMax"),
        				results.getDouble("itemPrice"),
        				results.getInt("requiredLevel"),
        				results.getInt("jobId"),
        				results.getInt("damage")
    				);
	        	} else {
	        		return null;
	          }
	        }
	      }
	}
}