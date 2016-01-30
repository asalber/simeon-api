/**
 * 
 */
package es.ceu.alf.simeon;

import java.net.URI;

/**
 * @author Alfredo Sánchez Alberca (asalber@ceu.es)
 *
 */
public interface comparisonOntologyManager {

  /**
   * * The URI for the ComparisonMeasure class in the SIMEON ontology.
   */
  public static final URI ComparisonMeasure =
      URI.create("http://purl.org/ceu/simeon#ComparisonMeasure");

  /**
   * The URI for the hasSourceObject object property in the SIMEON ontology.
   */
  public static final URI hasSourceObject =
      URI.create("http://purl.org/ceu/simeon#hasSourceObject");

  /**
   * The URI for the hasTargetObject object property in the SIMEON ontology.
   */
  public static final URI hasTargetObject =
      URI.create("http://purl.org/ceu/simeon#hasTargetObject");

  /**
   * The URI for the hasValue data property in the SIMEON ontology.
   */
  public static final URI hasValue = URI.create("http://purl.org/ceu/simeon#hasValue");

  /**
   * The URI for the usesComparisonMethod object property in the SIMEON ontology.
   */
  public static final URI usesComparisonMethod =
      URI.create("http://purl.org/ceu/simeon#usesComparisonMethod");

  /**
   * The URI for the isPerformedBy object property in the SIMEON ontology.
   */
  public static final URI isPerformedBy = URI.create("http://purl.org/ceu/simeon#isPerformedBy");

}
