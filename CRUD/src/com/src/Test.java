import productbase.stock.ProductOperator;

public class Test {
    public static void main (String args[]) throws Exception {
        for (int i = 0; i < 5; i++) {
            String[] create = new String[4];
            create[0] = "-c";
            create[1] = String.format("product#%d",i);
            create[2] = String.valueOf(Math.round(Math.random()*700+300)/100d);
            create[3] = String.valueOf((int)(Math.random()*30));
            ProductOperator.main(create);
        }
        String[] override = new String[] {"-u", "3","overridedProduct", "222", "23"};
        ProductOperator.main(override);
        String[] delete = new String[] {"-d", "4"};
        ProductOperator.main(delete);

    }
}
