package com.eguide.yash1300.e_guide.api;

import com.eguide.yash1300.e_guide.responses.BasicResponse;
import com.eguide.yash1300.e_guide.responses.student.*;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface StudentAPI {

    @GET("fetchDetails")
    Call<StudentDetailsResponse> fetchStudentDetails(
            @Header("x-access-token") String token
    );

    @GET("teachers")
    Call<StudentFetchTeachersResponse> fetchAllTeachers(
            @Header("x-access-token") String token
    );


    @GET("favoriteTeachers")
    Call<StudentFetchFavoriteTeachersResponse> fetchFavTeachers(
            @Header("x-access-token") String token
    );

    @POST("favorTeacher")
    @FormUrlEncoded
    Call<BasicResponse> favorTeacher(
            @Header("x-access-token") String token,
            @Field("skill_id") String skillId,
            @Field("teacher_id") String teacherId
    );

    @POST("unfavorTeacher")
    @FormUrlEncoded
    Call<BasicResponse> unfavorTeacher(
            @Header("x-access-token") String token,
            @Field("teacher_id") String teacherId,
            @Field("skill_id") String skillId
    );

    //Project related API Calls
    @GET("project/all")
    Call<StudentFetchAllProjectsResponse> fetchAllProjects(
            @Header("x-access-token") String token
    );

    @POST("project/request")
    @FormUrlEncoded
    Call<StudentRequestForAProjectResponse> requestForAProject(
            @Header("x-access-token") String token,
            @Field("project_id") String project_id
    );

    @GET("project/unapproved")
    Call<StudentFetchProjectsWithUnapprovedRequestsResponse> fetchUnapprovedRequestProjects(
            @Header("x-access-token") String token
    );

    @GET("project/approved")
    Call<StudentFetchProjectsWithApprovedRequestsResponse> fetchApprovedRequestProjects(
            @Header("x-access-token") String token
    );


}
