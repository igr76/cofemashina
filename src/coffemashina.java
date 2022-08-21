import javax.sound.sampled.Line;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class coffemashina {
    public static void main(String[] args) {
        System.out.println("Кофемашина");
        int moneyAmount = 120;

        ArrayList<Product> products = readListFromFile( "drinks.txt");
        checkPrice(products, moneyAmount);
    }
    public static ArrayList<Product> readListFromFile(String path){
        ArrayList<Product> products = new ArrayList<>();
        try{
            List<String> lines = Files.readAllLines(Path.of(path));
            for (String line : lines) {
                String[] tokens = Line.split("\s+");
                int price = Integer.parseInt(tokens[1]);
                products.add(new Product(tokens[0],price));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    public static void checkPrice(ArrayList<Product>)products, int moneyAmount){
        boolean canBuyAnything = false;

        for (Product product :products){
            if (moneyAmount >= product.getPrice()){
                System.out.println("Вы можете купить" +product.getName());
                canBuyAnything = true;
            }
        }
        if (canBuyAnything == false) {
            System.out.println("недостаточно средств");

        }
    }
