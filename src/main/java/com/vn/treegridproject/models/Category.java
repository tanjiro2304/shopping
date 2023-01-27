package com.vn.treegridproject.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    private Long id;

    private String name;

    private Category parent;
}
