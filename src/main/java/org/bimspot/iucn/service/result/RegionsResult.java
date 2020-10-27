package org.bimspot.iucn.service.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bimspot.iucn.model.Region;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegionsResult {

    public int count;
    public List<Region> results;
}
