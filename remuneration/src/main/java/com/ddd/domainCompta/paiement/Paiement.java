package com.ddd.domainCompta.paiement;

import com.ddd.domainCompta.Montant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@AllArgsConstructor
@Data
public class Paiement {

    private String idPaiement;
    private Date datePaiement;
    private Montant montantPaiement;

}
