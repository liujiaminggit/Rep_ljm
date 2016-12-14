package com.example.samsung.myapplication;

/**
 * Created by samsung on 2016/11/30.
 */

public class User {
    private int id;           //保存用户的ID
    private String username; //保存用户的帐号
    private String password;//保存用户的ID
    private String realname;//保存用户的姓名
    private String tel;      //保存用户的电话
    private String rel;      //保存用户的关系
    private String remark;  //保存用户的备注
    public User(){}
    public User(String realname,String tel,String rel,String remark){
        this.realname=realname;
        this.username=tel;                //电话号码作为默认登录帐号
        this.password=tel;//电话号码后4位作为默认登录密码
        this.tel=tel;
        this.rel=rel;
        this.remark=remark;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getRealname(){
        return realname;
    }
    public void setRealname(String realname){
        this.realname=realname;
    }
    public String getTel(){
        return tel;
    }
    public void setTel(String tel){
        this.tel=tel;
    }
    public String getRel(){
        return rel;
    }
    public void setRel(String rel){
        this.rel=rel;
    }
    public String getRemark(){
        return remark;
    }
    public void setRemark(String remark){
        this.remark=remark;
    }

}
