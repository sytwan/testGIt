package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by jams on 2019/5/27.
 */
@Data
@Entity
@Table(name = "t_user")
public class User {

    @Id   // 表明id
    @GeneratedValue   //  自动生成
    private Long id ;

    private String name ;
}
