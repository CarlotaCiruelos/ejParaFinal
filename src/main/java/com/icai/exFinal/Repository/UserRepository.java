package com.icai.exFinal.Repository;

import ch.qos.logback.classic.Logger;
import com.icai.exFinal.DTO.UserDocumentsDto;
import com.icai.exFinal.DTO.UserWIthDocumentsDto;
import com.icai.exFinal.Model.User;
import org.slf4j.LoggerFactory;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT * FROM DOCUMENT INNER JOIN USER ON USER.USER_ID=DOCUMENT.USER_ID")
    List<UserDocumentsDto> getAllUserDocuments();
}
