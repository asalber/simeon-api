package es.ceu.alf.simeon;

import java.net.URI;

/**
 * Interface for Comparison Measures of the SIMEON ontology.
 * 
 * @author Alfredo Sánchez Alberca (asalber@ceu.es)
 * @see <a href="http://aprendeconalf.es/simeon/" target="_blank">SIMEON ontology</a>
 */
public interface ComparisonMeasure {

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

  /**
   * Gets the comparison method used to compute the comparison measure.
   * 
   * @return the comparison method used to compute the comparison measure.
   */
  public ComparisonMethod getComparisonMethod();

  /**
   * Sets the URI of the comparison measure.
   * 
   * @param uri
   *          is the URI of the comparison measure.
   */
  public void setUri(URI uri);

  /**
   * Sets the source object of the comparison measure.
   * 
   * @param source
   *          is the source object of the comparison.
   */
  public void setSourceObject(Object source);

  /**
   * Sets the target object of the comparison.
   * 
   * @param target
   *          is the target object of the comparison.
   */
  public void setTargetObject(Object target);

  /**
   * Sets the value of the comparison measure.
   * 
   * @param value
   *          is the value of the comparison measure.
   */
  public void setValue(Float value);

  /**
   * Sets the comparison method of the comparison measure.
   * 
   * @param method
   *          is the method used to compute the comparison method.
   */
  public void setComparisonMethod(ComparisonMethod method);


}
