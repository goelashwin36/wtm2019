package com.eguide.yash1300.e_guide.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.eguide.yash1300.e_guide.R;
import com.eguide.yash1300.e_guide.listeners.student.StudentRequestForAProjectListener;
import com.eguide.yash1300.e_guide.models.ProjectModel;
import com.eguide.yash1300.e_guide.utils.NetworkManager;

import java.util.List;

public class StudentProjectAdapter extends RecyclerView.Adapter<StudentProjectAdapter.ViewHolder> {

    Context context;
    List<ProjectModel> projects;
    String token;
    boolean displayRequest;

    public StudentProjectAdapter(Context context, List<ProjectModel> projects, String token, boolean displayRequest) {
        this.context = context;
        this.projects = projects;
        this.token = token;
        this.displayRequest = displayRequest;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.adapter_student_project, parent, false);
        return (new ViewHolder(rootView));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if(displayRequest) {
            holder.request.setVisibility(View.VISIBLE);
        } else {
            holder.request.setVisibility(View.GONE);
        }

        final ProjectModel project = projects.get(position);
        holder.title.setText(project.getTitle());
        holder.link.setText(project.getLink());
        holder.description.setText(project.getDescription());
        holder.request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(context);
                progressDialog.setTitle("Please Wait");
                progressDialog.setMessage("Entering request for the given project");
                progressDialog.setCancelable(false);
                progressDialog.show();
                NetworkManager.getInstance().requestForAProject(token, project.getProject_id(), new StudentRequestForAProjectListener() {
                    @Override
                    public void onSuccess(String message) {
                        progressDialog.dismiss();
                        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(String message) {
                        progressDialog.dismiss();
                        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, link, description;
        Button request;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.adapter_student_project_title);
            link = itemView.findViewById(R.id.adapter_student_project_link);
            description = itemView.findViewById(R.id.adapter_student_project_description);
            request = itemView.findViewById(R.id.adapter_student_project_request);
        }
    }
}
