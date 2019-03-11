package com.eguide.yash1300.e_guide.responses.student;

import com.eguide.yash1300.e_guide.models.ProjectModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentFetchAllProjectsResponse {

    @SerializedName("success")
    @Expose
    Boolean success;

    @SerializedName("message")
    @Expose
    String message;

    @SerializedName("projects")
    @Expose
    List<ProjectModel> projects;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ProjectModel> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectModel> projects) {
        this.projects = projects;
    }
}
