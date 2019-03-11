package com.eguide.yash1300.e_guide.fragments.teacher;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eguide.yash1300.e_guide.R;
import com.eguide.yash1300.e_guide.adapters.TeacherProjectAdapter;
import com.eguide.yash1300.e_guide.listeners.teacher.TeacherFetchMyProjectsListener;
import com.eguide.yash1300.e_guide.listeners.teacher.TeacherHostAProjectListener;
import com.eguide.yash1300.e_guide.models.ProjectModel;
import com.eguide.yash1300.e_guide.utils.NetworkManager;

import java.util.List;

@SuppressLint("ValidFragment")
public class TeacherHomeProjectsFragment extends Fragment {


    Context context;
    String token;

    RecyclerView teacherProjectsRecyclerView;
    FloatingActionButton addProject;

    public TeacherHomeProjectsFragment(Context context, String token) {
        this.context = context;
        this.token = token;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_teacher_projects, container, false);

        teacherProjectsRecyclerView = rootView.findViewById(R.id.teacher_projects_recycler_view);
        addProject = rootView.findViewById(R.id.teacher_add_projects_fab);

        teacherProjectsRecyclerView.setLayoutManager(new LinearLayoutManager(context));

        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Loading the projects...");
        progressDialog.setTitle("Please Wait");
        progressDialog.setCancelable(false);
        progressDialog.show();

        NetworkManager.getInstance().teacherFetchMyProjects(token, new TeacherFetchMyProjectsListener() {
            @Override
            public void onSuccess(List<ProjectModel> projects) {
                progressDialog.dismiss();
                TeacherProjectAdapter teacherProjectAdapter = new TeacherProjectAdapter(context, projects);
                teacherProjectsRecyclerView.setAdapter(teacherProjectAdapter);
            }

            @Override
            public void onFailure(String message) {
                progressDialog.dismiss();
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add_project, null, false);
        final EditText title = dialogView.findViewById(R.id.dialog_project_title);
        final EditText link = dialogView.findViewById(R.id.dialog_project_link);
        final EditText description = dialogView.findViewById(R.id.dialog_project_description);
        final Button hostBtn = dialogView.findViewById(R.id.dialog_project_host_btn);
        builder.setView(dialogView);
        final AlertDialog hostDialog = builder.create();

        hostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProgressDialog progressDialog1 = new ProgressDialog(context);
                progressDialog1.setMessage("Hosting the project...");
                progressDialog1.setTitle("Please Wait");
                progressDialog1.setCancelable(false);
                progressDialog1.show();

                String[] skill_ids = {"5bdf38e062e3d22cd9e341d4", "5bdf38e562e3d22cd9e341d5"};

                NetworkManager.getInstance().hostAProject(token, title.getText().toString(), description.getText().toString(), skill_ids, link.getText().toString(), new TeacherHostAProjectListener() {
                    @Override
                    public void onSuccess(String message) {
                        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(String message) {
                        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        addProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hostDialog.show();
            }
        });


        return rootView;
    }
}
