package com.eguide.yash1300.e_guide.fragments.student;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.eguide.yash1300.e_guide.R;

public class StudentHomeProjectFragment extends Fragment {

    Context context;
    String token;

    Button all, unapp, app;
    FrameLayout container;

    public StudentHomeProjectFragment(Context context, String token) {
        this.context = context;
        this.token = token;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_student_project, container, false);

        all = rootView.findViewById(R.id.student_all_proj_btn);
        unapp = rootView.findViewById(R.id.student_unapp_req);
        app = rootView.findViewById(R.id.student_app_req);


        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new StudentProjectAllFragment(context, token));
            }
        });

        unapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new StudentProjectUnapproveFragment(context, token));
            }
        });

        app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new StudentProjectApproveFragment(context, token));
            }
        });


        return rootView;
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.student_projects_container, fragment);
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.commit();
    }

}
