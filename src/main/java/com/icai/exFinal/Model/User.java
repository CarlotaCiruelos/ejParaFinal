package com.icai.exFinal.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private @Column("USER_ID") int user_id;

    private @Column("USER") String user;
    private @Column("COMMENT") String comment;


    public User(String userName, String password) {
        this.user = userName;
        this.comment = password;
    }


}
