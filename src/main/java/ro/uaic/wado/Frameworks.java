package ro.uaic.wado;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.ReadWrite;
import org.apache.jena.sparql.core.Quad;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.tdb.TDBLoader;
import org.apache.jena.tdb.base.file.Location;
import org.apache.jena.tdb.sys.TDBInternal;
import org.apache.jena.util.FileManager;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.InputStream;
import java.util.Iterator;

@Path("/")
public class Frameworks {
    @GET
    public String getList() {
        FileManager fm = FileManager.get();
        fm.addLocatorClassLoader(Frameworks.class.getClassLoader());
        InputStream in = fm.open("data/data.nt");

        Location location = Location.create("target/TDB");

        // Load some initial data
        TDBLoader.load(TDBInternal.getBaseDatasetGraphTDB(TDBFactory.createDatasetGraph(location)), in, false);

        Dataset dataset = TDBFactory.createDataset(location);
        dataset.begin(ReadWrite.READ);

        StringBuilder response = new StringBuilder();
        try {
            Iterator<Quad> iter = dataset.asDatasetGraph().find();
            while (iter.hasNext()) {
                Quad quad = iter.next();
                response.append(quad);
            }
        } finally {
            dataset.end();
        }

        return response.toString();
    }
}
