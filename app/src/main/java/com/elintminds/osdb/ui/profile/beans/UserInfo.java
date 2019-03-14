package com.elintminds.osdb.ui.profile.beans;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserInfo {

        @SerializedName("user")
        @Expose
        private User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

    public class User {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("phone_number")
        @Expose
        private String phoneNumber;
        @SerializedName("remember_token")
        @Expose
        private Object rememberToken;
        @SerializedName("verification_code")
        @Expose
        private String verificationCode;
        @SerializedName("is_verified")
        @Expose
        private Integer isVerified;
        @SerializedName("is_active")
        @Expose
        private Integer isActive;
        @SerializedName("customer_uuid")
        @Expose
        private Object customerUuid;
        @SerializedName("customer_detail")
        @Expose
        private Object customerDetail;
        @SerializedName("is_super_admin")
        @Expose
        private Integer isSuperAdmin;
        @SerializedName("type")
        @Expose
        private Integer type;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("assets")
        @Expose
        private ArrayList<Object> assets = null;
        @SerializedName("claims")
        @Expose
        private ArrayList<Object> claims = null;
        @SerializedName("billing_address")
        @Expose
        private Object billingAddress;
        @SerializedName("user_subscription")
        @Expose
        private Object userSubscription;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

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

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Object getRememberToken() {
            return rememberToken;
        }

        public void setRememberToken(Object rememberToken) {
            this.rememberToken = rememberToken;
        }

        public String getVerificationCode() {
            return verificationCode;
        }

        public void setVerificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
        }

        public Integer getIsVerified() {
            return isVerified;
        }

        public void setIsVerified(Integer isVerified) {
            this.isVerified = isVerified;
        }

        public Integer getIsActive() {
            return isActive;
        }

        public void setIsActive(Integer isActive) {
            this.isActive = isActive;
        }

        public Object getCustomerUuid() {
            return customerUuid;
        }

        public void setCustomerUuid(Object customerUuid) {
            this.customerUuid = customerUuid;
        }

        public Object getCustomerDetail() {
            return customerDetail;
        }

        public void setCustomerDetail(Object customerDetail) {
            this.customerDetail = customerDetail;
        }

        public Integer getIsSuperAdmin() {
            return isSuperAdmin;
        }

        public void setIsSuperAdmin(Integer isSuperAdmin) {
            this.isSuperAdmin = isSuperAdmin;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public ArrayList<Object> getAssets() {
            return assets;
        }

        public void setAssets(ArrayList<Object> assets) {
            this.assets = assets;
        }

        public ArrayList<Object> getClaims() {
            return claims;
        }

        public void setClaims(ArrayList<Object> claims) {
            this.claims = claims;
        }

        public Object getBillingAddress() {
            return billingAddress;
        }

        public void setBillingAddress(Object billingAddress) {
            this.billingAddress = billingAddress;
        }

        public Object getUserSubscription() {
            return userSubscription;
        }

        public void setUserSubscription(Object userSubscription) {
            this.userSubscription = userSubscription;
        }

    }
    
    
    
    
}
