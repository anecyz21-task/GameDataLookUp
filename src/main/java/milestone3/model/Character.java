package milestone3.model;

public class Character {

	private int characterId;
	private String email;       // foreign key to Player
	private String firstName;
	private String lastName;
	private String clanName;    // foreign key to Clan

	public Character(int characterId, String email, String firstName, String lastName, String clanName) {
		this.characterId = characterId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.clanName = clanName;
	}

	public int getCharacterId() {
		return characterId;
	}

	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getClanName() {
		return clanName;
	}

	public void setClanName(String clanName) {
		this.clanName = clanName;
	}

	@Override
	public String toString() {
		return "Character{" +
				"characterId=" + characterId +
				", email='" + email + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", clanName='" + clanName + '\'' +
				'}';
	}
}
