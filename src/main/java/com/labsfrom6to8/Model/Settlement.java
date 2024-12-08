package com.labsfrom6to8.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Settlement {

    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("population")
    private Integer population;

    @JsonProperty("region")
    private String region;

    @JsonProperty("is_active")
    private Boolean isActive;
}
