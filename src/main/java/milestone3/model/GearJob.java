package milestone3.model;

import java.util.Objects;

public class GearJob {
  private int gearID;
  private int jobID;

  public GearJob(int gearID, int jobID) {
    this.gearID = gearID;
    this.jobID = jobID;
  }


  public int getGearID() {
    return gearID;
  }

  public void setGearID(int gearID) {
    this.gearID = gearID;
  }

  public int getJobID() {
    return jobID;
  }

  public void setJobID(int jobID) {
    this.jobID = jobID;
  }


  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GearJob gearJob = (GearJob) o;
    return gearID == gearJob.gearID && jobID == gearJob.jobID;
  }

  @Override
  public int hashCode() {
    return Objects.hash(gearID, jobID);
  }

  @Override
  public String toString() {
    return "GearJob{" +
        "gearID=" + gearID +
        ", jobID=" + jobID +
        '}';
  }
}

