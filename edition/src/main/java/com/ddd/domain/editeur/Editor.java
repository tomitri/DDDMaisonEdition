package com.ddd.domain.editeur;

import com.ddd.domain.Skill;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Editor {

    private String id;
    private List<Skill> skills;
    private String email;

}
