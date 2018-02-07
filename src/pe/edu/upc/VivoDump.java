package pe.edu.upc;

import java.io.IOException;

import org.vivoweb.harvester.util.repo.SDBJenaConnect;

public class VivoDump {

	public static void main(String[] args) throws IOException {
		
		SDBJenaConnect conn = new SDBJenaConnect(
			    "jdbc:mysql://localhost:3321/vitrodb",
			    "usrprdcivivo",
			    "uj673xb73xb3",
			    "MySQL",
			    "com.mysql.jdbc.Driver",
			    "layout2",
			    "http://vitro.mannlib.cornell.edu/default/vitro-kb-2"
			    );
		
		conn.getModelName();
		conn.exportRdfToFile("vivo_upc.rdf");

	}

}
