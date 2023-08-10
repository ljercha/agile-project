package org.kainos.ea.cli;

public class JobSpecification {
    private int RoleId;
    private String Summary;
    private String Description;
    private String SpecificationLink;

    public JobSpecification(int roleId, String summary, String description, String specificationLink) {
        RoleId = roleId;
        Summary = summary;
        Description = description;
        SpecificationLink = specificationLink;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getSpecificationLink() {
        return SpecificationLink;
    }

    public void setSpecificationLink(String specificationLink) {
        SpecificationLink = specificationLink;
    }
}