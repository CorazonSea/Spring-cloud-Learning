package com.example.paddington.entity;

import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author lijl
 * @date 2021/1/20 下午2:23
 */
/*
* @Data作用：去除Getter,Setter,equals,hashCode,toString方法
* */
@Entity
@Data
public class User implements Serializable {

    /*
    * Entity 中不映射成列的字段得加 @Transient 注解，不加注解也会映射成列
    *
    * update：最常用的属性，第一次加载 hibernate 时根据 model 类会自动建立起表的结构（前提是先建立好数据库），
    * 以后加载 hibernate 时根据 model 类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。
    * 要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等 应用第一次运行起来后才会。
    *
    * */

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nickName;

    @Column(nullable = false)
    private String regTime;

    public User() {
    }

    public User(String nickName,String email,String userName,  String password, String regTime) {
        super();
        this.email = email;
        this.nickName = nickName;
        this.password = password;
        this.userName = userName;
        this.regTime = regTime;
    }
}
