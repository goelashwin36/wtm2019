package com.eguide.yash1300.e_guide.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eguide.yash1300.e_guide.R;
import com.eguide.yash1300.e_guide.models.ProjectModel;

import java.util.List;

public class TeacherProjectAdapter extends RecyclerView.Adapter<TeacherProjectAdapter.ViewHolder> {

    Context context;
    List<ProjectModel> projects;

    public TeacherProjectAdapter(Context context, List<ProjectModel> projects) {
        this.context = context;
        this.projects = projects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.adapter_teacher_project, parent, false);
        return (new ViewHolder(rootView));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProjectModel project = projects.get(position);
        holder.title.setText(project.getTitle());
        holder.description.setText(project.getDescription());
        holder.link.setText(project.getLink());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add dialog for the list of students
            }
        });
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, link, description;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.adapter_teacher_project_title);
            description = itemView.findViewById(R.id.adapter_teacher_project_description);
            link = itemView.findViewById(R.id.adapter_teacher_project_link);
        }
    }
}
