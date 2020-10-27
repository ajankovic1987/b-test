package org.bimspot.iucn.service.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bimspot.iucn.model.ConservationMeasure;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConservationMeasureResult {

    public String name;
    @JsonProperty("region_identifier")
    public String regionIdentifier;
    public List<ConservationMeasure> result;
}
