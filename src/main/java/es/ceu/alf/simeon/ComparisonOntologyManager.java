/**
 * 
 */
package es.ceu.alf.simeon;

import java.net.URI;

/**
 * Interface for managing an ontology that uses the <a href="http://aprendeconalf.es/simeon"> SIMEON ontology</a>.
 * 
 * This is the main interface and every class that want to access an ontology build with the SIMEON ontology must
 * implement it.
 * 
 * @author Alfredo Sánchez Alberca (asalber@ceu.es)
 */
public interface ComparisonOntologyManager {

  /**
   * * The URI for the ComparisonMeasure class in the SIMEON ontology.
   */
  String SIMEON_RDF_URL = "http://aprendeconalf.es/simeon/1.0/simeon-core.rdf";

  /**
   * * The URI for the ComparisonMeasure class in the SIMEON ontology.
   */
  URI COMPARISONMEASURE_URI =
      URI.create("http://purl.org/ceu/simeon#ComparisonMeasure");

  /**
   * * The URI for the ComparisonMethod class in the SIMEON ontology.
   */
  URI COMPARISONMETHOD_URI = URI.create("http://purl.org/ceu/simeon#ComparisonMethod");

  /**
   * The URI for the hasSourceObject object property in the SIMEON ontology.
   */
  URI HASSOURCEOBJECT_URI =
      URI.create("http://purl.org/ceu/simeon#hasSourceObject");

  /**
   * The URI for the hasTargetObject object property in the SIMEON ontology.
   */
  URI HASTARGETOBJECT_URI = URI.create("http://purl.org/ceu/simeon#hasTargetObject");

  /**
   * The URI for the hasValue data property in the SIMEON ontology.
   */
  URI HASVALUE_URI = URI.create("http://purl.org/ceu/simeon#hasValue");

  /**
   * The URI for the usesComparisonMethod object property in the SIMEON ontology.
   */
  URI USESCOMPARISONMETHOD_URI = URI.create("http://purl.org/ceu/simeon#usesComparisonMethod");

  /**
   * The URI for the isPerformedBy object property in the SIMEON ontology.
   */
  URI ISPERFORMEDBY_URI = URI.create("http://purl.org/ceu/simeon#isPerformedBy");

  /**
   * Gets a comparison measure with the given URI from the ontology.
   * 
   * @param uri
   *          is the URI of the comparison measure.
   * @return the comparison measure with the given URI.
   */
  ComparisonMeasure getComparisonMeasure(URI uri);

  /**
   * Adds a new comparison measure to the ontology.
   * 
   * @param measure
   *          is the comparison measure to add to the ontology.
   */
  void addComparisonMeasure(ComparisonMeasure measure);

  /**
   * Serializes the ontology to a file.
   * 
   * @param file
   *          is a string with the path to the file where to write the ontology.
   * @param format
   *          is the langue used for the seralization of the ontology ("RDF/XML", "TURTLE",...).
   */
  void writeOntology(String file, String format);

  /**
   * Serializes the ontology to a file in RDF/XML language.
   * 
   * @param file
   *          is a string with the path to the file where to write the ontology.
   */
  void writeOntology(String file);

}
