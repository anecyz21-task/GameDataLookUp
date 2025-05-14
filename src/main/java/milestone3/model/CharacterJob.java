package milestone3.model;

import java.util.Objects;

public class CharacterJob {
  private int characterID;
  private int jobID;
  private int level;
  private int xp;
  private boolean unlock;

  public CharacterJob(int characterID, int jobID, int level, int xp, boolean unlock) {
    this.characterID = characterID;
    this.jobID = jobID;
    this.level = level;
    this.xp = xp;
    this.unlock = unlock;
  }

  public int getCharacterID() {
    return characterID;
  }

  public void setCharacterID(int characterID) {
    this.characterID = characterID;
  }

  public int getJobID() {
    return jobID;
  }

  public void setJobID(int jobID) {
    this.jobID = jobID;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getXp() {
    return xp;
  }

  public void setXp(int xp) {
    this.xp = xp;
  }

  public boolean isUnlock() {
    return unlock;
  }

  public void setUnlock(boolean unlock) {
    this.unlock = unlock;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CharacterJob that = (CharacterJob) o;
    return characterID == that.characterID && jobID == that.jobID && level == that.level && xp == that.xp
        && unlock == that.unlock;
  }

  @Override
  public int hashCode() {
    return Objects.hash(characterID, jobID, level, xp, unlock);
  }

  @Override
  public String toString() {
    return "CharacterJob{" +
        "characterID=" + characterID +
        ", jobID=" + jobID +
        ", level=" + level +
        ", xp=" + xp +
        ", unlock=" + unlock +
        '}';
  }
}
