package loader;

import com.google.gson.Gson;
import model.PetriNet;
import model.components.Pre;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class PetriNetLoader {
    private static Gson gson = new Gson();
    private static PetriNet petriNet;
    private static Reader reader;

    /**
     * Load the Petri Net from /in/loadPetriNet.txt
     * @return the loaded Petri Net
     */
    public static PetriNet loadPetriNet() {
        try {
            URL url = PetriNetLoader.class.getResource("/in/loadPetriNet.txt");
            reader = new FileReader(new File(url.toURI()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        petriNet = gson.fromJson(reader, PetriNet.class);
        return petriNet;
    }
}
