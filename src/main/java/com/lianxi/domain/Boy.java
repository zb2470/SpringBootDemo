package com.lianxi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Boy {
    @Id
    @GeneratedValue
    private Integer id;

    @Min(value = 18,message = "必须大于18岁")
    private Integer age;

    @NotBlank(message = "名字不能为空")
    private String Name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Boy() {
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                ", age=" + age +
                ", Name='" + Name + '\'' +
                '}';
    }
}
