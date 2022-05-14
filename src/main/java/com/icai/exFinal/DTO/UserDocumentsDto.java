package com.icai.exFinal.DTO;

import com.icai.exFinal.Model.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDocumentsDto {
    int user_id;
    String user;
    String comment;
    String doc;
    int doc_id;
}
