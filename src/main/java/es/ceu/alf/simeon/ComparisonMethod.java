package es.ceu.alf.simeon;

import java.net.URI;
import java.util.function.BiFunction;

/**
 * Interface for comparison methods of the SIMEON ontology.
 * 
 * @author Alfredo Sánchez Alberca (asalber@ceu.es)
 * @see <a href="http://aprendeconalf.es/simeon/" target="_blank">SIMEON ontology</a>
 */
public interface ComparisonMethod {
  /**
   * Gets the URI identifying this comparison method.
   * 
   * @return the URI identifying this comparison method.
   */
  public URI getUri();

  /**
   * Gets the comparison function that computes the comparison measure. Usually this function will
   * be applied to the source and target objects of a comparison measure.
   * 
   * @return a two arguments comparison function.
   */
  public BiFunction<Object, Object, Float> getFunction();

  /**
   * Gets the URI of the class of objects compared with the comparison method.
   * 
   * @return the URI of the class of objects compared with the comparison method.
   */
  public URI getDomain();

  /**
   * Gets the algorithm used by the comparison method.
   * 
   * @return the URI of the algorithm used by the comparison method.
   */
  public URI getAlgorithm();

  /**
   * Gets the bibliographic references to the comparison method.
   * 
   * @return an array with the URIs of the bibliographic references to the comparison method.
   */
  public URI[] getReference();


}
