package com.eguide.yash1300.e_guide.listeners.student;

import com.eguide.yash1300.e_guide.models.ProjectModel;

import java.util.List;

public interface StudentFetchAllProjectsListener {

    void onSuccess(List<ProjectModel> projects);
    void onFailure(String message);

}
