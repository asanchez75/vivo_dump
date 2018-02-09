package vivo.dump;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.vivoweb.harvester.util.repo.SDBJenaConnect;

public class VivoDump {

	public static void main(String[] args) throws IOException {
		
		ArrayList<String> models = new ArrayList<String>();

		// these named graphs contains reserchers data
		models.add("http://vitro.mannlib.cornell.edu/default/vitro-kb-inf");
		models.add("http://vitro.mannlib.cornell.edu/default/vitro-kb-2");
		// generic named graphs
		models.add("http://vitro.mannlib.cornell.edu/default/asserted-tbox");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/tbox/contact-vcard.owl");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/tbox/relationshipAxioms.n3");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/tbox/personTypes.n3");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/tbox/data-properties.owl");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/tbox/geo-political.owl");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/tbox/object-properties.owl");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/tbox/education.owl");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/tbox/classes-additional.owl");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/tbox/publication.owl");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/tbox/vitro-0.7.owl");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/tbox/appControls-temp.n3");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/abox/academicDegree.rdf");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/tbox/relationship.owl");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/abox/documentStatus.owl");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/tbox/skos-vivo.owl");
		models.add("http://vitro.mannlib.cornell.edu/filegraph/abox/geopolitical.abox.ver1.1-11-18-11.owl");
		//models.add("http://vitro.mannlib.cornell.edu/default/inferred-tbox");
		
		PrintStream out = new PrintStream(new FileOutputStream("vivo.nt"));
		System.setOut(out);
		
		for (String model : models) {
			SDBJenaConnect conn = new SDBJenaConnect(
				    "jdbc:mysql://localhost:3321/vitrodb",
				    "user",
				    "password",
				    "MySQL",
				    "com.mysql.jdbc.Driver",
				    "layout2",
				    model
				    );
			conn.getModelName();
			//conn.exportRdfToFile("vivo_upc.rdf", "N-TRIPLES", true);
			conn.exportRdfToStream(out, "N-TRIPLES");
			conn.close();
		}
		


	}

}
