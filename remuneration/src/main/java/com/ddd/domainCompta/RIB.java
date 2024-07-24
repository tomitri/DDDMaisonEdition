package com.ddd.domainCompta;

import lombok.*;

@AllArgsConstructor
@Getter
public class RIB {

    private final String bic;
    private final String codeBanque;
    private final String codeAgence;
    private final String numCompte;
    private final String cléRIB;
    private final String iban;

}
