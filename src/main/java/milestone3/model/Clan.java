package milestone3.model;

public class Clan {
	private String clanName;
	private RaceName raceName;

	public enum RaceName {
		Human,
		Cat,
		Elf,
		Halfling,
		Dragon
	}

	public Clan(String clanName, RaceName raceName) {
		this.clanName = clanName;
		this.raceName = raceName;
	}

	public String getClanName() {
		return clanName;
	}

	public void setClanName(String clanName) {
		this.clanName = clanName;
	}

	public RaceName getRaceName() {
		return raceName;
	}

	public void setRaceName(RaceName raceName) {
		this.raceName = raceName;
	}

	@Override
	public String toString() {
		return "Clan{" +
				"clanName='" + clanName + '\'' +
				", raceName=" + raceName +
				'}';
	}
}
