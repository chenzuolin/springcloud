package com.sumeng.springcloud.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
@ToString
public class Payment implements Serializable {

    private Integer id;
    private String serial;
}