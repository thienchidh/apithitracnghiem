package com.thienchidh.apithitracnghiem.model.responses;

import com.thienchidh.apithitracnghiem.model.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FavoriteClient {
    private Account account;
    private Question question;
}
