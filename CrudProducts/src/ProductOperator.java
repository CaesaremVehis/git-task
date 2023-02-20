import stock.*;
import java.util.Map;

public class ProductOperator {
    private ProductOperator(){}
        private static final String path="./Database/products.txt";


    public static void main(String[] args) {
            DataBase db = new DataBase(path);
            for (int i = 0; i < 5; i++) {
                db.add(new Product("Product#"+i, Math.round(Math.random()*7000+3000)/100d,(int)(Math.random()*50)));
            }

            Product product = db.getProductById(4);


            try{
                Product Liza = new Product("Liza1", 99999,1);
                db.add(Liza);
            }
            catch (IllegalArgumentException e){
                System.out.println("Can't to add product. Illegal argument");
            }

            Map<Integer,Product> productsMap = db.getProductsByName("Product");
            productsMap.forEach((integer, product1) -> System.out.println(integer+"   "+product1));

            db.setProductById(8, new Product("product",199.9,11));
            db.deleteById(1);
            db.save();
        }
}
