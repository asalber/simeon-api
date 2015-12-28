package es.ceu.alf.simeon.api;

import java.net.URI;

/**
 * Interface for Comparison Methods of the SIMEON ontology.
 * 
 * @author Alfredo Sánchez Alberca (asalber@ceu.es)
 * @see <a href="http://aprendeconalf.es/simeon/" target="_blank">SIMEON ontology</a>
 */
public interface ComparisonMethod {
  /**
   * * The URI for the ComparisonMethod class in the SIMEON ontology.
   */
  public static final URI ComparisonMethod = URI.create("http://purl.org/ceu/simeon#ComparisonMethod");

  /**
   * Gets the URI identifying this comparison method.
   * 
   * @return an URI identifying this comparison method.
   */
  public URI getUri();

}
