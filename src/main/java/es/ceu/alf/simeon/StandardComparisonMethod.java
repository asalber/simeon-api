package es.ceu.alf.simeon;

import java.net.URI;
import java.util.function.BiFunction;

/**
 * @author Alfredo Sánchez Alberca (asalber@ceu.es)
 *
 */
public class StandardComparisonMethod implements ComparisonMethod {
  private URI uri; // The uri of the comparison method.
  private BiFunction<Object, Object, Float> function; // The function that computes de comparison.
  private URI domain; // The uri of the class of objects that compares the method.
  private URI algorithm; // The uri of the algorithm used by the function that computes the method;
  private URI[] references; // The bibliographic references to the comparison method.

  /**
   * Default constructor that creates the identity similarity function. 
   */
  public StandardComparisonMethod() {
    this.uri = URI.create("http://purl.org/ceu/simeon#objectIdentitySimilarityFunction");
    this.function = (x, y) -> {
      return ((x == y) ? 1f : 0f);
    };
    this.domain = URI.create("http://www.w3.org/2002/07/owl#Thing");
    this.algorithm = null;
    this.references = null;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMethod#getUri()
   */
  @Override
  public URI getUri() {
    return this.uri;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMethod#getFunction()
   */
  @Override
  public BiFunction<Object, Object, Float> getFunction() {
    return function;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMethod#getDomain()
   */
  @Override
  public URI getDomain() {
    return domain;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMethod#getAlgorithm()
   */
  @Override
  public URI getAlgorithm() {
    return algorithm;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMethod#getReference()
   */
  @Override
  public URI[] getReference() {
    return references;
  }

}
