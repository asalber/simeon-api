package es.ceu.alf.simeon;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import java.net.URI;

/**
 * This class test the {@code StandardComparisonMeasure} class.
 * 
 * @see org.ceu.alf.ecollections.JenaCollectionOntology
 * @author Alfredo Sánchez Alberca (asalber@ceu.es)
 */
public final class StandardComparisonMeasureTests {

  /**
   * This test checks the default constructor for the same source and target objects creates a
   * comparison measure with value 1.
   */
  @Test
  public void defaultConstructorEqualObjectsTest() {
    String source = "http://example.org/A";
    ComparisonMeasure measure = new StandardComparisonMeasure(source, source);
    assertEquals("Identity comparison measure for two equal objects should be 1", 1f,
        measure.getValue(), 0);
  }

  /**
   * This test checks the default constructor for two different objects creates a comparison measure
   * with value 0.
   */
  @Test
  public void defaultConstructorDifferentObjectsTest() {
    String source = "http://example.org/A";
    String target = "http://example.org/B";
    ComparisonMeasure measure = new StandardComparisonMeasure(source, target);
    assertEquals("Identity comparison measure for two different objects should be 0", 0f,
        measure.getValue(), 0);
  }

  /**
   * This test checks that after setting the target object the same than the source object in a
   * comparison measure created with the default constructor, the value of the measure is 1.
   */
  @Test
  public void setTargetObjectTheSameThanSourceObjectTest() {
    String source = "http://example.org/A";
    String target = "http://example.org/B";
    ComparisonMeasure measure = new StandardComparisonMeasure(source, target);
    measure.setTargetObject(source);
    assertEquals("Identity comparison measure for tow equal objects should be 1", 1f,
        measure.getValue(), 0);
  }
      
}
