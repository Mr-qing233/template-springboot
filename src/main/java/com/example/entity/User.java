package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "db_user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "fieldHandler"})
public class User implements Serializable {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "wechat_id")
    private String wechatId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    @Column(name = "create_time")
    private Date createTime;

}
