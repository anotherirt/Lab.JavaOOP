import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService<T extends Company> {


    public FileService() {

    }

    public void printList(List<T> companies){
        for(T company : companies){
            System.out.println(company.toString());
        }
    }

    public List<T> readFile(String fileName){
        List<T> objects = new ArrayList<>();
        try(ObjectInputStream file = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            boolean eof = false;
            while(!eof) {
                try {
                    T object = (T) file.readObject();
                    objects.add(object);
                } catch(EOFException e) {
                    eof = true;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch(IOException io) {
            System.out.println("IO Exception " + io.getMessage());
        } catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException " + e.getMessage());
        }
        return objects;
    }

    public void writeFile(String fileName, List<T> objects){
        try (ObjectOutputStream companyFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (T object : objects) {
                companyFile.writeObject(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
