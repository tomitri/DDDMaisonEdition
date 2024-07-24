package com.ddd.domainCompta.auteur;

import com.ddd.domainCompta.RIB;
import lombok.*;

@Builder
@AllArgsConstructor
@Data
public class Auteur {

    private String idAuteur;
    private RIB ribAuteur;
    private String siren;

}
