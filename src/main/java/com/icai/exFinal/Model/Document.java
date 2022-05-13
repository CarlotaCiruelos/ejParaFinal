package com.icai.exFinal.Model;

import ch.qos.logback.classic.Logger;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
public class Document {


    @Id
    private @Column("DOC_ID")  int doc_id;

    private @Column("DOC") String doc;
    private @Column("USER_ID") int user_id;

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(Document.class);

    public String getText (){
        LOGGER.info("test");
        return "a";
    }
}

