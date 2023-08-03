package org.kainos.ea.cli;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
public class JobSpecification {
    private int RoleId;
    private String Specification;

    private String Summary;
    private String SpecificationLink;

    public JobSpecification(int roleId, String specification, String summary, String specificationLink) {
        RoleId = roleId;
        Specification = specification;
        Summary = summary;
        SpecificationLink = specificationLink;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }

    public String getSpecification() {
        return Specification;
    }

    public void setSpecification(String specification) {
        Specification = specification;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getSpecificationLink() {
        return SpecificationLink;
    }

    public void setSpecificationLink(String specificationLink) {
        SpecificationLink = specificationLink;
    }
}
