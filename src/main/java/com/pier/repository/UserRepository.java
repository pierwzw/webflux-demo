package com.pier.repository;

import com.pier.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
//请注意这里需要继承ReactiveMongoRepository
public interface UserRepository extends ReactiveMongoRepository<User, Long> {
	/**
     * 对用户名和备注进行模糊查询
     * @param userName —— 用户名称
     * @param note —— 备注
     * @return 符合条件的用户
     */
    public Flux<User> findByUserNameLikeAndNoteLike(
            String userName, String note);
}
