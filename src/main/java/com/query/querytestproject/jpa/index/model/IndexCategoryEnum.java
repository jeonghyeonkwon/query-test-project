package com.query.querytestproject.jpa.index.model;

import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
public enum IndexCategoryEnum {
    NUMBER_ONE(1),
    NUMBER_TWO(2),
    NUMBER_THREE(3);
    private final int number;

    public static IndexCategoryEnum findNumber(int i){
        return Stream.of(values()).filter(category -> category.number==i ).findFirst().orElse(null);
    }
}
