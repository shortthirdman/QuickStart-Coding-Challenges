package com.shortthirdman.quickstart.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkedWordNode {

    private String word;
    private int depth;
    private LinkedWordNode prev;
}
