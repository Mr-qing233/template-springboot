package com.example.repository;


import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User,String > {
    // 用户登录验证
    // 用户注册-新增用户数据
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "INSERT INTO `db_user` (user_name, wechat_id, password) VALUES " +
            "(:#{#user.userName},:#{#user.wechatId},:#{#user.password});")
    Integer newUser(@Param("user")User user);

    // 校验用户名是否存在
    User findUserByUserName(String userName);

    // 校验微信账号是否已绑定
    User findUserByWechatId(String wechatId);

    // 校验密码
    @Query(nativeQuery = true,value = "SELECT * FROM db_user WHERE wechat_id=:uid AND `password` =:password")
    User judgeUserPassword(@Param("uid") String uid, @Param("password") String password);
}
