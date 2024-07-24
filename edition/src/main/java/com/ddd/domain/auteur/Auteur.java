package com.ddd.domain.auteur;

import com.ddd.domain.Skill;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Auteur {

    private String id;
    private List<Skill> skills;
    private String email;

}
