/**
 * 
 */
package es.ceu.alf.simeon;

import java.net.URI;

/**
 * Class that implements the {@see es.ceu.alf.simeon.ComparisonMeasure} with basic methods.
 * 
 * @author Alfredo Sánchez Alberca (asalber@ceu.es)
 *
 */
public class StandardComparisonMeasure implements ComparisonMeasure {
  private URI uri; // The URI identifier of the comparison measure;
  private String source; // The source object of the comparison;
  private String target; // The target object of the comparison;
  private Float value; // The value of the comparison measure;
  private ComparisonMethod method; // The method of comparison used to compute the measure.

  /**
   * Constructor for comparison measures. It creates a comparison measure for the source and target
   * objects given with the identity function as a comparison method;
   * 
   * @param source
   *          is the source object of the comparison.
   * @param target
   *          is the target object of the comparison.
   */
  public StandardComparisonMeasure(String source, String target) {
    this.uri = null;
    this.source = source;
    this.target = target;
    this.method = new StandardComparisonMethod();
    computeMeasure();
  }

  /**
   * Constructor for comparison measures. It creates a comparison measure for the source and target
   * objects given with the uri given and identity function as a comparison method;
   * 
   * @param source
   *          is the source object of the comparison.
   * @param target
   *          is the target object of the comparison.
   * @param uri
   *          is the URI that identifies de comparison measure in the ontology.
   */
  public StandardComparisonMeasure(String source, String target, URI uri) {
    this.uri = uri;
    this.source = source;
    this.target = target;
    this.method = new StandardComparisonMethod();
    computeMeasure();
  }


  /**
   * Constructor for comparison measures. It creates a comparison measure for the source and target
   * objects given with a given value and no comparison method.
   * 
   * @param source
   *          is the source object of the comparison.
   * @param target
   *          is the target object of the comparison.
   * @param value
   *          is the value of the measure.
   */
  public StandardComparisonMeasure(String source, String target, Float value) {
    this.uri = null;
    this.source = source;
    this.target = target;
    this.value = value;
    this.method = null;
  }

  /**
   * Constructor for comparison measures. It creates a comparison measure for the source and target
   * objects given with a given value and uri and no comparison method.
   * 
   * @param source
   *          is the source object of the comparison.
   * @param target
   *          is the target object of the comparison.
   * @param value
   *          is the value of the measure.
   * @param uri
   *          is the URI that identifies de comparison measure in the ontology.
   */
  public StandardComparisonMeasure(String source, String target, Float value, URI uri) {
    this.uri = null;
    this.source = source;
    this.target = target;
    this.value = value;
    this.method = null;
  }

  /**
   * Constructor for comparison measures. It creates a comparison measure for the source and target
   * objects given with a given value and uri and no comparison method.
   * 
   * @param source
   *          is the source object of the comparison.
   * @param target
   *          is the target object of the comparison.
   * @param method
   *          is the comparison method used to compare the source and target objects.
   */
  public StandardComparisonMeasure(String source, String target, ComparisonMethod method) {
    this.uri = null;
    this.source = source;
    this.target = target;
    this.method = method;
    computeMeasure();
  }

  /**
   * Constructor for comparison measures. It creates a comparison measure for the source and target
   * objects given with a given value and uri and no comparison method.
   * 
   * @param source
   *          is the source object of the comparison.
   * @param target
   *          is the target object of the comparison.
   * @param method
   *          is the comparison method used to compare the source and target objects.
   * @param uri
   *          is the URI that identifies de comparison measure in the ontology.
   */
  public StandardComparisonMeasure(String source, String target, ComparisonMethod method, URI uri) {
    this.uri = uri;
    this.source = source;
    this.target = target;
    this.method = method;
    computeMeasure();
  }

  private void computeMeasure() {
    this.value = this.method.getFunction().apply(this.source, this.target);
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMeasure#getUri()
   */
  @Override
  public URI getUri() {
    return this.uri;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMeasure#getSourceObject()
   */
  @Override
  public Object getSourceObject() {
    return source;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMeasure#getTargetObject()
   */
  @Override
  public Object getTargetObject() {
    return target;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMeasure#getValue()
   */
  @Override
  public float getValue() {
    return value;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMeasure#getComparisonMethod()
   */
  @Override
  public ComparisonMethod getComparisonMethod() {
    return method;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMeasure#setSourceObject(java.lang.Object)
   */
  @Override
  public void setSourceObject(Object source) {
    this.source = (String) source;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMeasure#setTargetObject(java.lang.Object)
   */
  @Override
  public void setTargetObject(Object target) {
    this.target = (String) target;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMeasure#setValue(float)
   */
  @Override
  public void setValue(Float value) {
    this.value = value;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * es.ceu.alf.simeon.ComparisonMeasure#setComparisonMethod(es.ceu.alf.simeon.ComparisonMethod)
   */
  @Override
  public void setComparisonMethod(ComparisonMethod method) {
    this.method = method;
  }

  @Override
  public void setUri(URI uri) {
    this.uri = uri;
  }

}
