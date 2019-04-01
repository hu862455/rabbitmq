package com.example.rabbitmq.vo;

import java.io.Serializable;

/**
 * @Class_name: Student
 * @Exception:
 * @Describe: 传输对象必须进行序列化操作
 * @Author: shuaihu2
 * @Creat_date: 2019/3/29 16:27
 **/
public class Student  implements Serializable {
    private String name;
    private String id;
    private String schoolName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
