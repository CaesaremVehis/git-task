package productbase.stock;

/*
Прайсы
*/

public class ProductOperator {
    private ProductOperator(){}
        private static final String path="././Database/products.txt";
    public static void main(String[] args) throws Exception {
        if(!((args.length==4 && args[0].equals("-c"))||
            (args.length==5 && args[0].equals("-u"))||
            (args.length==2 && args[0].equals("-d")))){
            System.out.println("Wrongs program arguments");
        }
        else{
         DataBase db = new DataBase(path);
            switch (args[0]){
                case "-c" -> {
                    db.add(new Product(
                            args[1], Double.parseDouble(args[2]), Integer.parseInt(args[3])));
                    db.save();
                }
                case "-u" -> {
                    db.setProductById(
                            Integer.parseInt(args[1]), new Product(
                                    args[2], Double.parseDouble(args[3]), Integer.parseInt(args[4])));
                    db.save();
                }
                case "-d" -> {
                    db.deleteById(Integer.parseInt(args[1]));
                    db.save();
                }
            }
        }
    }
}
