package com.eguide.yash1300.e_guide.listeners.teacher;

import com.eguide.yash1300.e_guide.models.ProjectModel;

import java.util.List;

public interface TeacherFetchMyProjectsListener {

    void onSuccess(List<ProjectModel> projects);
    void onFailure(String message);

}
