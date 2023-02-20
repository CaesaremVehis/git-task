package stock;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
/**
 * Read products from .txt file
 * has-a map of products and can process it
 * save products into .txt file
 */
public class DataBase {
    private HashMap<Integer, Product> products;
    private String path;


    public DataBase(String path) {
        this.path = path;
        init();
    }


    public String getPath() {
        return path;
    }
    public Product getProductById(int id){
        return products.get(id);
    }

    /**
     *
     * @return HashMap<Integer, Product>. key is a product id, value is a product
     */
    public Map<Integer,Product> getProductsByName(String name){
        Map<Integer,Product> filteredMap = new HashMap<>();
        products.entrySet().stream()
                .filter((productEntry)->productEntry.getValue().getProductName().equals(name))
                .forEach(o->filteredMap.put(o.getKey(),o.getValue()));

        return filteredMap;
    }

    /**
     * Updates the product associated with id
     * @return previous product or null, if product wasn't found by this id;
     */
    public Product setProductById(int id, Product product){
        return products.put(id,product);
    }

    private void init() {
        products = new HashMap<>();
        int currentStringNumber=0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            while (bufferedReader.ready()){
                try {
                    StringBuilder productString = new StringBuilder(bufferedReader.readLine());
                        if(productString.isEmpty()){
                            continue;
                        }
                    String id = productString.substring(0, 7).trim();
                    String productName = productString.substring(8, 37).trim();
                    double price = Double.parseDouble(productString.substring(38, 45).trim());
                    int quantity = Integer.parseInt(productString.substring(46, 49).trim());

                    Product product = new Product(productName,price,quantity);
                    products.put(Integer.parseInt(id),product);
                    currentStringNumber++;
                }
                catch (StringIndexOutOfBoundsException e){
                    System.out.printf("Incorrect data at file \"%s\" at string %d. (Index out of bounds)\n",path,currentStringNumber++);
                }
                catch (IllegalArgumentException e){
                    System.out.printf("Incorrect data at file \"%s\" at string %d. (Illegal argument)\n",path,currentStringNumber++);
                }

            }
        }
        catch(FileNotFoundException e){
            System.out.printf("Can't find the file: \"%s\". Database will create a new file with same path.\n",path);
        }
        catch(IOException e){
            System.out.printf("Can't read the file: \"%s\". DataBase will override this file.\n",path);
        }
    }

    private int generateId(){
        Optional<Map.Entry<Integer, Product>> maxId = products.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getKey));
        return maxId.map(product -> product.getKey() + 1).orElse(0);
    }

    public int add(Product product){
        int id = generateId();
        product.setId(id);
        products.put(id,product);
        return id;
    }


    public void print(){
        products.forEach((key, value) -> System.out.println("id:" + key + "\n   " + value));
    }
    private boolean saveAs(String path){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))){
            products.forEach((key, value) -> {
                String tmp = value.toDbFormat(key);
                try {
                    bufferedWriter.write(tmp + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            return true;
        }
        catch (Exception e){
            System.out.println("Fail to save the file, please try again or change the path");
            return false;
        }
    }

    /**
     * @return true, if file successfully saved, false if file can't be saved
     */
    public boolean save(){
        return saveAs(path);
    }
    /**
     * @param path new path to save the file
     * @return true, if file successfully saved, false if file can't be saved
     */
    public boolean save(String path){
        this.path=path;
        return saveAs(path);
    }

    /**
     * @return the previous product associated with id
     */
    public Product deleteById(int id){
        return products.remove(id);

    }

}
