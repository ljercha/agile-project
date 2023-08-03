package org.kainos.ea.cli;

public class JobRole {
    private int jobRoleId;
    private String roleTitle;

    public JobRole(int jobRoleId, String roleTitle) {
        this.jobRoleId = jobRoleId;
        this.roleTitle = roleTitle;
    }

    public int getJobRoleId() {
        return jobRoleId;
    }

    public void setJobRoleId(int jobRoleId) {
        this.jobRoleId = jobRoleId;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }
}
