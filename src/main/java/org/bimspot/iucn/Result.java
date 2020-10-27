package org.bimspot.iucn;

import org.bimspot.iucn.model.Species;

import java.util.List;

/**
 * Result of the /species endpoint
 */
public class Result {
    public List<Species> criticallyEndangeredSpecies;
    public List<Species> mammalSpecies;
}
