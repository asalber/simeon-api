package es.ceu.alf.simeon;

import java.net.URI;

/* @author alf
 *
 */
/**
 * @author Alfredo Sánchez Alberca (asalber@ceu.es)
 *
 */
public class Prueba {
  /**
   * Class prueba
   * @param args
   */
  public static void main(String[] args) {
    String source = "http://example.org/A";
    String target = "http://example.org/B";
    URI uri = URI.create("http://example.org/simAB");
    ComparisonMeasure measure = new StandardComparisonMeasure(source, target, uri);
    ComparisonOntologyManager ontologyManager = new JenaComparisonOntologyManager();
    ontologyManager.addComparisonMeasure(measure);
    ontologyManager.writeOntology("/home/alf/prueba.ttl", "TURTLE");

  }

}


