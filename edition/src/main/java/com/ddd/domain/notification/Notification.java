package com.ddd.domain.notification;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Notification {

    private Integer id;
    private LocalDateTime date;
    private String content;

}
