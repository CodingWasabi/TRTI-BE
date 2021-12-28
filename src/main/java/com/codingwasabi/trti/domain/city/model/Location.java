package com.codingwasabi.trti.domain.city.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Location {
    SEOUL("서울특별시", "37.75768", "128.87375"),
    BUSAN("부산광역시", "33.34889", "126.28097"),
    JEJU("제주시", "33.43144", "126.87424"),
    GWANGJU("광주광역시", "36.34831", "127.39059"),
    DAEGU("대구광역시", "35.00525", "127.64877"),
    ULSAN("울산광역시", "35.59360", "129.35200"),
    DAEJEON("대전광역시", "35.19401", "128.10196"),
    INCHEON("인천광역시", "37.43779", "126.97586");

    private String name;
    private String latitude;
    private String longitude;

    public static Location parseName(String korName) {
        for (Location location : Location.values()) {
            if (location.getName().equals(korName)) {
                return location;
            }
        }

        throw new IllegalArgumentException("[ERROR] 잘못된 도시 이름이 입력되었습니다.");
    }

}
