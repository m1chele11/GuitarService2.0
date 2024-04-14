package edu.iu.mbarrant.C322Homework2.repository;

import edu.iu.mbarrant.C322Homework2.model.GuitarData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;



@Component
public class InventoryRepository {

    public InventoryRepository() {
        File guitarsImagesDirectory = new File("guitars/images");
        if(!guitarsImagesDirectory.exists()) {
            guitarsImagesDirectory.mkdirs();
        }
        File guitarsAudioDirectory = new File("guitars/audio");
        if(!guitarsAudioDirectory.exists()) {
            guitarsAudioDirectory.mkdirs();
        }
    }
    private String IMAGES_FOLDER_PATH = "guitars/images/";
    private static final String DATABASE_NAME = "guitars/guitars_database.txt";
    private static final String NEW_LINE = System.lineSeparator();




    private static void appendToFile(Path path, String content) throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public boolean add(GuitarData guitarData) throws IOException{

        Path path = Paths.get(DATABASE_NAME);
        String data = guitarData.toLine();
        System.out.println(data);
        appendToFile(path, data + NEW_LINE);
        return true;

    }

//    public GuitarData getGuitar(String serialNumber) {
//        try {
//            FileReader r = new FileReader("guitars_database.txt");
//            BufferedReader bufferedReader = new BufferedReader(r);
//
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] guitarData = line.split(",");
//                if (guitarData[0].equals(serialNumber)) {
//                    return new GuitarData(guitarData[0], Double.parseDouble(guitarData[1]), guitarData[2],
//                            guitarData[3], guitarData[4], guitarData[5], guitarData[6]);
//                }
//            }
//            bufferedReader.close();
//            r.close();
//            return null;
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//            return null;
//        }
//    }



    //    public GuitarData search(GuitarData guitarDataToFind) {
//        try {
//            FileReader r = new FileReader("guitars_database.txt");
//            BufferedReader bufferedReader = new BufferedReader(r);
//
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] guitarData = line.split(",");
//                if (guitarData.length != 7) {
//                    System.out.println("No guitar found");
//                    continue;
//                }
//
//                GuitarData g = new GuitarData(guitarData[0], Double.parseDouble(guitarData[1]), guitarData[2],
//                        guitarData[3], guitarData[4], guitarData[5], guitarData[6]);
//
//                if (g.getSerialNumber().equals(guitarDataToFind.getSerialNumber()) &&
//                        g.getBuilder().equals(guitarDataToFind.getBuilder()) &&
//                        g.getModel().equals(guitarDataToFind.getModel()) &&
//                        g.getType().equals(guitarDataToFind.getType()) &&
//                        g.getBackWood().equals(guitarDataToFind.getBackWood()) &&
//                        g.getTopWood().equals(guitarDataToFind.getTopWood())) {
//                    return g;
//                }
//            }
//
//            bufferedReader.close();
//            r.close();
//
//            System.out.println("No guitar found");
//            return null;
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//            return null;
//        }
//    }
    public List<GuitarData> search(String type) throws IOException{
        List<GuitarData> guitars = findAll();
        List<GuitarData> result = new ArrayList<>();
        for(GuitarData guitar : guitars) {
            if (type != null && !guitar.type().equalsIgnoreCase(type)) {
                continue;
            }
            result.add(guitar);
        }
        return result;
    }

    //    public static List<GuitarData> find(String serialNumber, Double price, String builder, String model, String type, String backWood, String topWood) throws IOException {
//        Path path = Paths.get("guitars_database.txt");
//        List<GuitarData> result = new ArrayList<>();
//        List<String> data = Files.readAllLines(path);
//
//        for (String line : data) {
//            String[] words = line.split(",");
//            String sn = words[0];
//            Double pr = Double.parseDouble(words[1]);
//            String b = words[2];
//            String m = words[3];
//            String t = words[4];
//            String bw = words[5];
//            String tw = words[6];
//
//            if (serialNumber.equals(sn) && price.equals(pr)
//                    && builder.equals(b) && model.equals(m)
//                    && type.equals(t) && backWood.equals(bw)
//                    && topWood.equals(tw)) {
//                GuitarData guitarData = new GuitarData(sn, pr, b, m, t, bw, tw);
//                result.add(guitarData);
//            }
//        }
//        return result;
//    }
    public List<GuitarData> findAll() throws IOException {
        List<GuitarData> result = new ArrayList<>();
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line : data) {
            GuitarData g = GuitarData.fromLine(line);
            result.add(g);
        }
        return result;
    }
    public GuitarData find(String serialNumber) throws IOException {
        List<GuitarData> guitars = findAll();
        for(GuitarData guitar : guitars) {
            if (guitar.serialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }


}