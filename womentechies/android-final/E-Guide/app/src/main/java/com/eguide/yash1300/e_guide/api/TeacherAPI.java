package com.eguide.yash1300.e_guide.api;

import com.eguide.yash1300.e_guide.responses.BasicResponse;
import com.eguide.yash1300.e_guide.responses.teacher.*;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface TeacherAPI {

    @GET("fetchDetails")
    Call<TeacherDetailsResponse> fetchDetails(
            @Header("x-access-token") String token
    );

    @POST("addSkills")
    @FormUrlEncoded
    Call<BasicResponse> addSkills(
            @Header("x-access-token") String token,
            @Field("skills") String[] skills
    );

    @GET("fetchFavStudents")
    Call<TeacherFetchFavoredStudentsResponse>  fetchFavoredStudents(
            @Header("x-access-token") String token
    );

    //Project related API calls
    @POST("project")
    @FormUrlEncoded
    Call<TeacherHostAProjectResponse> hostAProject(
            @Header("x-access-token") String token,
            @Field("title") String title,
            @Field("description") String description,
            @Field("skill_ids") String[] skill_ids,
            @Field("link") String link
    );

    @GET("project/my")
    Call<TeacherFetchMyProjectsResponse> fetchMyProjects(
            @Header("x-access-token") String token
    );

    @PUT("project/request/approve")
    @FormUrlEncoded
    Call<TeacherApproveProjectRequestResponse> approveRequest(
            @Header("x-access-token") String token,
            @Field("project_id") String project_id,
            @Field("student_id") String student_id
    );

    @PUT("project/request/reject")
    @FormUrlEncoded
    Call<TeacherRejectProjectRequestResponse> rejectRequest(
            @Header("x-access-token") String token,
            @Field("project_id") String project_id,
            @Field("student_id") String student_id
    );



}
