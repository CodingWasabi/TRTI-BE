package com.codingwasabi.trti.domain.location.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum City {
    SEOUL("서울특별시"),
    BUSAN("부산광역시"),
    JEJU("제주특별자치구"),
    GWANGJU("광주광역시"),
    DAEGU("대구광역시"),
    ULSAN("울산광역시"),
    DAEJEON("대전광역시"),
    INCHEON("인천광역시");

    private String name;

    public static City parseName(String korName) {
        for (City city : City.values()) {
            if (city.toString().equals(korName)) {
                return city;
            }
        }

        throw new IllegalArgumentException("[ERROR] 잘못된 도시 이름이 입력되었습니다.");
    }
    public String toString() {
        return name;
    }
}
