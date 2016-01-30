package es.ceu.alf.simeon;

import java.net.URI;

/**
 * Class that implements the {@see es.ceu.alf.simeon.ComparisonMeasure} with basic methods.
 * 
 * @author Alfredo Sánchez Alberca (asalber@ceu.es)
 *
 */
public final class StandardComparisonMeasure implements ComparisonMeasure {
  /**
   * The URI identifier of the comparison measure.
   */
  private URI uri;
  /**
   * The source object of the comparison.
   */
  private Object source;
  /**
   * The target object of the comparison.
   */
  private Object target;
  /**
   * The value of the comparison measure.
   */
  private Float value;
  /**
   * The method of comparison used to compute the measure.
   */
  private ComparisonMethod method;
  /**
   * The URI of the agent that assess the comparison measure.
   */
  private URI agent;


  /**
   * Constructor for comparison measures. It creates a comparison measure for the source and target
   * objects given with the method, URI and agent given.
   * 
   * @param source
   *          is the source object of the comparison.
   * @param target
   *          is the target object of the comparison.
   * @param method
   *          is the comparison method used to compare the source and target objects.
   * @param uri
   *          is the URI that identifies the comparison measure in the ontology.
   * @param agent
   *          is the URI of the agent that assess the comparison measure.
   */
  public StandardComparisonMeasure(final Object source, final Object target, final ComparisonMethod method,
      final URI uri, final URI agent) {
    this.source = source;
    this.target = target;
    this.method = new StandardComparisonMethod();
    this.uri = uri;
    this.agent = agent;
    computeMeasure();
  }

  /**
   * Constructor for comparison measures. It creates a comparison measure for the source and target
   * objects given with the identity function as a comparison method.
   * 
   * @param source
   *          is the source object of the comparison.
   * @param target
   *          is the target object of the comparison.
   */
  public StandardComparisonMeasure(final Object source, final Object target) {
    this(source, target, new StandardComparisonMethod(), null, null);
  }

  /**
   * Constructor for comparison measures. It creates a comparison measure for the source and target
   * objects given with the URI given and identity function as a comparison method.
   * 
   * @param source
   *          is the source object of the comparison.
   * @param target
   *          is the target object of the comparison.
   * @param uri
   *          is the URI that identifies the comparison measure in the ontology.
   */
  public StandardComparisonMeasure(final Object source, final Object target, final URI uri) {
    this(source, target, new StandardComparisonMethod(), uri, null);
  }

  /**
   * Constructor for comparison measures. It creates a comparison measure for the source, the target
   * objects, the comparison method and the URI given.
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
  public StandardComparisonMeasure(final Object source, final Object target, final ComparisonMethod method,
      final URI uri) {
    this(source, target, method, uri, null);
  }

  /**
   * Constructor for comparison measures. It creates a comparison measure for the source, the target
   * objects and the comparison method given.
   * 
   * @param source
   *          is the source object of the comparison.
   * @param target
   *          is the target object of the comparison.
   * @param method
   *          is the comparison method used to compare the source and target objects.
   */
  public StandardComparisonMeasure(final Object source, final Object target, final ComparisonMethod method) {
    this(source, target, method, null, null);
  }
  
  /**
   * Constructor for comparison measures. It creates a comparison measure for the source, the target
   * objects, the value, the URI and the agent given and no comparison method.
   * 
   * @param source
   *          is the source object of the comparison.
   * @param target
   *          is the target object of the comparison.
   * @param value
   *          is the value of the measure.
   * @param uri
   *          is the URI that identifies the comparison measure in the ontology.
   * @param agent
   *          is the URI of the agent that assess the comparison measure.
   */
  public StandardComparisonMeasure(final Object source, final Object target, final Float value, final URI uri,
      final URI agent) {
    this.source = source;
    this.target = target;
    this.value = value;
    this.method = null;
    this.uri = uri;
    this.agent = agent;
  }

  /**
   * Constructor for comparison measures. It creates a comparison measure for the source and target
   * objects given with a given value and URI and no comparison method.
   * 
   * @param source
   *          is the source object of the comparison.
   * @param target
   *          is the target object of the comparison.
   * @param value
   *          is the value of the measure.
   * @param uri
   *          is the URI that identifies the comparison measure in the ontology.
   */
  public StandardComparisonMeasure(final Object source, final Object target, final Float value, final URI uri) {
    this(source, target, value, uri, null);
  }


  /**
   * Method that computes the comparison measure with the comparison method if there are one.
   */
  private void computeMeasure() {
    if (this.method != null) {
      this.value = this.method.getFunction().apply(this.source, this.target);
    } else {
      this.value = null;
    }
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMeasure#getSourceObject()
   */
  @Override
  public Object getSourceObject() {
    return this.source;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMeasure#getTargetObject()
   */
  @Override
  public Object getTargetObject() {
    return this.target;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMeasure#getValue()
   */
  @Override
  public float getValue() {
    return this.value;
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.ComparisonMeasure#getComparisonMethod()
   */
  @Override
  public ComparisonMethod getComparisonMethod() {
    return this.method;
  }

  /*
   * (non-Javadoc)
   * 
   * @see es.ceu.alf.simeon.ComparisonMeasure#getUri()
   */
  @Override
  public URI getUri() {
    return this.uri;
  }

  /*
   * (non-Javadoc)
   * 
   * @see es.ceu.alf.simeon.ComparisonMeasure#getAgent()
   */
  @Override
  public URI getAgent() {
    return this.agent;
  }

  /*
   * (non-Javadoc)
   * 
   * @see es.ceu.alf.simeon.ComparisonMeasure#setSourceObject(java.lang.Object)
   */
  @Override
  public void setSourceObject(final Object source) {
    this.source = source;
    computeMeasure();
  }

  /*
   * (non-Javadoc)
   * 
   * @see es.ceu.alf.simeon.ComparisonMeasure#setTargetObject(java.lang.Object)
   */
  @Override
  public void setTargetObject(final Object target) {
    this.target = target;
    computeMeasure();
  }

  /*
   * (non-Javadoc)
   * 
   * @see es.ceu.alf.simeon.ComparisonMeasure#setValue(float)
   */
  @Override
  public void setValue(final Float value) {
    this.value = value;
  }

  /*
   * (non-Javadoc)
   * 
   * @see es.ceu.alf.simeon.ComparisonMeasure#setComparisonMethod(es.ceu.alf.simeon.ComparisonMethod)
   */
  @Override
  public void setComparisonMethod(final ComparisonMethod method) {
    this.method = method;
    computeMeasure();
  }

  /*
   * (non-Javadoc)
   * 
   * @see es.ceu.alf.simeon.ComparisonMeasure#setUri(java.net.URI)
   */
  @Override
  public void setUri(final URI uri) {
    this.uri = uri;
  }

  /*
   * (non-Javadoc)
   * 
   * @see es.ceu.alf.simeon.ComparisonMeasure#setAgent(java.net.URI)
   */
  @Override
  public void setAgent(final URI agent) {
    this.agent = agent;
  }

}
