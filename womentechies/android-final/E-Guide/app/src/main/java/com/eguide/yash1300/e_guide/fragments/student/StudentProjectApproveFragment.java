package com.eguide.yash1300.e_guide.fragments.student;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eguide.yash1300.e_guide.R;
import com.eguide.yash1300.e_guide.adapters.StudentProjectAdapter;
import com.eguide.yash1300.e_guide.listeners.student.StudentFetchApprovedRequestProjectsListener;
import com.eguide.yash1300.e_guide.listeners.student.StudentFetchUnapprovedRequestProjectsListener;
import com.eguide.yash1300.e_guide.models.ProjectModel;
import com.eguide.yash1300.e_guide.utils.NetworkManager;

import java.util.List;

@SuppressLint("ValidFragment")
public class StudentProjectApproveFragment extends Fragment {

    Context context;
    String token;
    RecyclerView recyclerView;

    public StudentProjectApproveFragment(Context context, String token) {
        this.context = context;
        this.token = token;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_student_project_app, container, false);

        recyclerView = rootView.findViewById(R.id.student_project_unapp_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        NetworkManager.getInstance().fetchApprovedRequestProjects(token, new StudentFetchApprovedRequestProjectsListener() {
            @Override
            public void onSuccess(List<ProjectModel> projects) {
                StudentProjectAdapter studentProjectAdapter = new StudentProjectAdapter(context, projects, token, false);
                recyclerView.setAdapter(studentProjectAdapter);
            }

            @Override
            public void onFailure(String message) {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }
        });


        return rootView;
    }
}
