# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).


## [1.0.0] - 2020-10-27
### Added
- Support for several rest api services from the IUCN Red List of Threatened Species:
    - RegionsService - fetching of available regions
    - SpeciesService - fetching of species for the specified region
    - ConservationMeasuresService - fetching conservation measures for the specified species in the
    specified region
- Rest endpoint that returns the critically endangered species from the randomly chosen region, and
species that belong to mammal class from the chosen region