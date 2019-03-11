package com.eguide.yash1300.e_guide.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectModel {

    @SerializedName("_id")
    @Expose
    String project_id;

    @SerializedName("teacher")
    @Expose
    TeacherModel teacher;

    @SerializedName("students")
    @Expose
    List<StudentModel> students;

    @SerializedName("requests")
    @Expose
    List<StudentModel> requests;

    @SerializedName("title")
    @Expose
    String title;

    @SerializedName("description")
    @Expose
    String description;

    @SerializedName("skills")
    @Expose
    List<SkillModel> skills;

    @SerializedName("link")
    @Expose
    String link;

    public TeacherModel getTeacher() {
        return teacher;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public void setTeacher(TeacherModel teacher) {
        this.teacher = teacher;
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
    }

    public List<StudentModel> getRequests() {
        return requests;
    }

    public void setRequests(List<StudentModel> requests) {
        this.requests = requests;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SkillModel> getSkills() {
        return skills;
    }

    public void setSkills(List<SkillModel> skills) {
        this.skills = skills;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
