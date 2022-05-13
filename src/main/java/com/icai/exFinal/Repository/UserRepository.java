package com.icai.exFinal.Repository;

import ch.qos.logback.classic.Logger;
import com.icai.exFinal.Model.User;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
