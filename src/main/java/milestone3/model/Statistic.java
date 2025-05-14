package milestone3.model;

public class Statistic {

    private int characterId;
    private int value;
		private StatisticName statisticName;

		public enum StatisticName{
			Strength,
			Dexterity,
			Magic,
			Spirit,
			Vitality
		}

	public Statistic(StatisticName statisticName, int characterId, int value) {
		this.statisticName = statisticName;
		this.characterId = characterId;
		this.value = value;
	}

	public StatisticName getStatisticName() {
		return statisticName;
	}

	public void setStatisticName(StatisticName statisticName) {
		this.statisticName = statisticName;
	}

	public int getCharacterId() {
		return characterId;
	}

	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Statistic{" +
				"statisticName=" + statisticName +
				", characterId=" + characterId +
				", value=" + value +
				'}';
	}
}