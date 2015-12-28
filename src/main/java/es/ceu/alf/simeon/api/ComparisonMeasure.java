package es.ceu.alf.simeon.api;

import java.net.URI;

/**
 * Interface for Comparison Measures of the SIMEON ontology.
 * 
 * @author Alfredo Sánchez Alberca (asalber@ceu.es)
 * @see <a href="http://aprendeconalf.es/simeon/" target="_blank">SIMEON ontology</a>
 */
public interface ComparisonMeasure {
  /**
   * * The URI for the ComparisonMeasure class in the SIMEON ontology.
   */
  public static final URI ComparisonMeasure = URI.create("http://purl.org/ceu/simeon#ComparisonMeasure");

  /**
   * The URI for the hasSourceObject object property in the SIMEON ontology.
   */
  public static final URI hasSourceObject = URI.create("http://purl.org/ceu/simeon#hasSourceObject");

  /**
   * The URI for the hasTargetObject object property in the SIMEON ontology.
   */
  public static final URI hasTargetObject = URI.create("http://purl.org/ceu/simeon#hasTargetObject");

  /**
   * The URI for the hasValue data property in the SIMEON ontology.
   */
  public static final URI hasValue = URI.create("http://purl.org/ceu/simeon#hasValue");

  /**
   * The URI for the usesComparisonMethod object property in the SIMEON ontology.
   */
  public static final URI usesComparisonMethod = URI.create("http://purl.org/ceu/simeon#usesComparisonMethod");

  /**
   * Gets the URI identifying this comparison measure.
   * 
   * @return an URI identifying this comparison measure.
   */
  public URI getUri();

  /**
   * Gets the source object of the comparison measure.
   * 
   * @return the source object of the comparison measure.
   */
  public Object getSourceObject();

  /**
   * Gets the target object of the comparison measure.
   * 
   * @return the target object of the comparison measure.
   */
  public Object getTargetObject();

  /**
   * Gets the value of the comparison measure.
   * 
   * @return the value of the comparison measure.
   */
  public float getValue();

}
