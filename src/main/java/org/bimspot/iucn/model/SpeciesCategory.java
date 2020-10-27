package org.bimspot.iucn.model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum SpeciesCategory {

    @JsonProperty("DD")
    DATA_DEFICIENT,
    @JsonProperty("LC")
    LEAST_CONCERN,
    @JsonProperty("NT")
    NEAR_THREATENED,
    @JsonProperty("VU")
    VULNERABLE,
    @JsonProperty("EN")
    ENDANGERED,
    @JsonProperty("CR")
    CRITICALLY_ENDANGERED,
    @JsonProperty("EW")
    EXTINCT_IN_THE_WILD,
    @JsonProperty("EX")
    EXTINCT,
    @JsonProperty("LR/lc")
    LOWER_RISK_LEAST_CONCERN,
    @JsonProperty("LR/nt")
    LOWER_RISK_NEAR_THREATENED,
    @JsonProperty("LR/cd")
    CONSERVATION_DEPENDENT,
    NA,
    RE;
}
