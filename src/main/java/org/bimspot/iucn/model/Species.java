package org.bimspot.iucn.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Species {

    @JsonProperty("taxonid")
    public Long taxonId;
    @JsonProperty("kingdom_name")
    public String kingdomName;
    @JsonProperty("phylum_name")
    public String phylumName;
    @JsonProperty("class_name")
    public String className;
    @JsonProperty("order_name")
    public String orderName;
    @JsonProperty("family_name")
    public String familyName;
    @JsonProperty("genus_name")
    public String genusName;
    @JsonProperty("scientific_name")
    public String scientificName;
    // maybe different type
    @JsonProperty("infra_rank")
    public String infraRank;
    // maybe different type
    @JsonProperty("infra_name")
    public String infraName;
    // maybe different type
    public String population;
    public SpeciesCategory category;
    public String conservationMeasures;

    @Override
    public String toString() {
        return "Species{" +
                "taxonId=" + taxonId +
                ", kingdomName='" + kingdomName + '\'' +
                ", phylumName='" + phylumName + '\'' +
                ", className='" + className + '\'' +
                ", orderName='" + orderName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", genusName='" + genusName + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", infraRank='" + infraRank + '\'' +
                ", infraName='" + infraName + '\'' +
                ", population='" + population + '\'' +
                ", category=" + category +
                ", conservationMeasures='" + conservationMeasures + '\'' +
                '}';
    }
}
