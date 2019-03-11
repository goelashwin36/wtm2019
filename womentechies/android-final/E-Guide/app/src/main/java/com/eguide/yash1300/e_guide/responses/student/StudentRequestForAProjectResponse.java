package com.eguide.yash1300.e_guide.responses.student;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentRequestForAProjectResponse {

    @SerializedName("success")
    @Expose
    Boolean success;

    @SerializedName("message")
    @Expose
    String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
