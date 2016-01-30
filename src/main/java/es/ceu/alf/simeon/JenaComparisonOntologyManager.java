package es.ceu.alf.simeon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.net.URI;

import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.RDFDataMgr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class that implement the {@code ComparisonOntologyManager} interface with the <a href=https://jena.apache.org>Jena
 * library</a>.
 * 
 * @author Alfredo Sánchez Alberca (asalber@ceu.es)
 */
public final class JenaComparisonOntologyManager implements ComparisonOntologyManager {
  /**
   * Logger for the class.
   */
  private static final Logger LOG = LoggerFactory.getLogger(JenaComparisonOntologyManager.class);

  /**
   * Jena model that contains the ontology.
   */
  private OntModel model;

  /**
   * Default constructor that creates an empty comparison ontology.
   */
  public JenaComparisonOntologyManager() {
    model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
    model.read(SIMEON_RDF_URL);
  }

  /**
   * Constructor that creates a comparison ontology from an string containing a serialized ontology.
   * 
   * @param serializedOntology
   *          a string containing a serialized ontology.
   */
  public JenaComparisonOntologyManager(final String serializedOntology) {
    this.model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
    StringReader input = new StringReader(serializedOntology);
    this.model.read(input, null);
    LOG.info("Ontology loaded.");
    LOG.info("Number of statements: " + model.size());
  }

  /**
   * Constructor that creates a comparison ontology from an string containing a serialized ontology.
   * 
   * @param ontologyFile
   *          a file containing a serialized ontology.
   * @throws FileNotFoundException
   *           File not found exception.
   */
  public JenaComparisonOntologyManager(final File ontologyFile) throws FileNotFoundException {
    this.model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
    FileInputStream input = new FileInputStream(ontologyFile);
    this.model.read(input, null);
    LOG.info("Ontology loaded from " + ontologyFile);
    LOG.info("Number of statements: " + model.size());
  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.comparisonOntologyManager#getComparisonMeasure(java.net.URI)
   */
  @Override
  public ComparisonMeasure getComparisonMeasure(final URI uri) {
    return null;

  }

  /* (non-Javadoc)
   * @see es.ceu.alf.simeon.comparisonOntologyManager#addComparisonMeasure(es.ceu.alf.simeon.ComparisonMeasure)
   */
  @Override
  public void addComparisonMeasure(final ComparisonMeasure measure) {
    OntClass comparisonMeasureClass = this.model.getOntClass(COMPARISONMEASURE_URI.toString());
    Individual comparisonMeasureIndividual;
    if (measure.getUri() != null) {
      comparisonMeasureIndividual = comparisonMeasureClass.createIndividual(measure.getUri().toString());
    } else {
      comparisonMeasureIndividual = comparisonMeasureClass.createIndividual();
    }
    Resource source = this.model.createResource(measure.getSourceObject().toString());
    comparisonMeasureIndividual.addProperty(this.model.getObjectProperty(HASSOURCEOBJECT_URI.toString()), source);
    Resource target = this.model.createResource(measure.getTargetObject().toString());
    comparisonMeasureIndividual.addProperty(this.model.getObjectProperty(HASTARGETOBJECT_URI.toString()), target);
    comparisonMeasureIndividual.addLiteral(this.model.getDatatypeProperty(HASVALUE_URI.toString()), measure.getValue());
    if (measure.getComparisonMethod() != null) {
      OntClass comparisonMethodClass = this.model.getOntClass(COMPARISONMETHOD_URI.toString());
      Individual comparisonMethodIndividual =
          comparisonMethodClass.createIndividual(measure.getComparisonMethod().getUri().toString());
      comparisonMeasureIndividual.addProperty(this.model.getObjectProperty(USESCOMPARISONMETHOD_URI.toString()),
          comparisonMethodIndividual);
    }
    if (measure.getAgent() != null) {
      Resource agent = this.model.createResource(measure.getAgent().toString());
      comparisonMeasureIndividual.addProperty(this.model.getObjectProperty(ISPERFORMEDBY_URI.toString()), agent);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see es.ceu.alf.simeon.ComparisonOntologyManager#writeOntology(java.lang.String, java.lang.String)
   */
  @Override
  public void writeOntology(final String file, final String format) {
    try {
      FileOutputStream output = new FileOutputStream(new File(file), true);
      this.model.write(output, format);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see es.ceu.alf.simeon.ComparisonOntologyManager#writeOntology(java.lang.String)
   */
  @Override
  public void writeOntology(String file) {
    writeOntology(file, "RDF/XML");

  }

}
