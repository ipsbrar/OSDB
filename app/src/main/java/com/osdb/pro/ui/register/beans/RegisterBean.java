package com.osdb.pro.ui.register.beans;

public class RegisterBean {

    private String name;
    private String email;
    private String phone_number;
    private String type;
    private String verification_code;
    private String updated_at;
    private String created_at;
    private String id;

//    @SerializedName("email")
//    @Expose
//    private List<String> emailList = null;
//
//    public List<String> getEmailList() {
//        return emailList;
//    }
//
//    public void setEmail(List<String> emailList) {
//        this.emailList = emailList;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
