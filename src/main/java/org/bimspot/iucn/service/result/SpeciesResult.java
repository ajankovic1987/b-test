package org.bimspot.iucn.service.result;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.bimspot.iucn.model.Species;

import java.util.List;

public class SpeciesResult {

    public long count;
    @JsonProperty("region_identifier")
    public String regionIdentifier;
    public String page;
    public List<Species> result;
}
