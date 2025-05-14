package milestone3.model;

import java.util.Objects;

public class JobType {

  private int jobID;
  private String jobName;

  public JobType(int jobID, String jobName) {
    this.jobID = jobID;
    this.jobName = jobName;
  }

  public int getJobID() {
    return jobID;
  }

  public void setJobID(int jobID) {
    this.jobID = jobID;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobType jobType = (JobType) o;
    return jobID == jobType.jobID && Objects.equals(jobName, jobType.jobName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jobID, jobName);
  }

  @Override
  public String toString() {
    return "JobType{" +
        "jobID=" + jobID +
        ", jobName='" + jobName + '\'' +
        '}';
  }
}