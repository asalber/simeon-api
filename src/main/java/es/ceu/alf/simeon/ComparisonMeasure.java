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
  URI getUri();

  /**
   * Gets the source object of the comparison measure.
   * 
   * @return the source object of the comparison measure.
   */
  Object getSourceObject();

  /**
   * Gets the target object of the comparison measure.
   * 
   * @return the target object of the comparison measure.
   */
  Object getTargetObject();

  /**
   * Gets the value of the comparison measure.
   * 
   * @return the value of the comparison measure.
   */
  float getValue();

  /**
   * Gets the comparison method used to compute the comparison measure.
   * 
   * @return the comparison method used to compute the comparison measure.
   */
  ComparisonMethod getComparisonMethod();

  /**
   * Gets the agent that assessed the comparison measure.
   * 
   * @return the URI of the agent that assessed the comparison measure.
   */
  URI getAgent();

  /**
   * Sets the URI of the comparison measure.
   * 
   * @param uri
   *          is the URI of the comparison measure.
   */
  void setUri(URI uri);

  /**
   * Sets the source object of the comparison measure.
   * 
   * @param source
   *          is the source object of the comparison.
   */
  void setSourceObject(Object source);

  /**
   * Sets the target object of the comparison.
   * 
   * @param target
   *          is the target object of the comparison.
   */
  void setTargetObject(Object target);

  /**
   * Sets the value of the comparison measure.
   * 
   * @param value
   *          is the value of the comparison measure.
   */
  void setValue(Float value);

  /**
   * Sets the comparison method of the comparison measure.
   * 
   * @param method
   *          is the method used to compute the comparison measure.
   */
  void setComparisonMethod(ComparisonMethod method);

  /**
   * Sets the agent that assess the comparison measure.
   * 
   * @param agent
   *          is the URI of the agent that assess the comparison measure.
   */
  void setAgent(URI agent);

}
