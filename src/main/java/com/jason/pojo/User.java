package com.jason.pojo;

/**
 * Created by 我不管我最帅 on 2019/3/31.
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String salt;//盐
    private String anonymousName;//匿名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAnonymousName() {
        if(null!=anonymousName)return anonymousName;
        if(null==name)anonymousName=null;
        else if(name.length()<=1)anonymousName="*";
        else if(name.length()==2)anonymousName=name.substring(0,1)+"*";
        else{
            char []cs=name.toCharArray();
            for(int i=1;i<cs.length-1;i++){
                cs[i]='*';
            }
        }
        return anonymousName;
    }

    public void setAnonymousName(String anonymousName) {
        this.anonymousName = anonymousName;
    }

    @Override
    public String toString() {
        return "User{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  ", password='" + password + '\'' +
                  ", salt='" + salt + '\'' +
                  ", anonymousName='" + anonymousName + '\'' +
                  '}';
    }
}
