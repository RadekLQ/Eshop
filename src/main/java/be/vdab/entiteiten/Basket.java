package be.vdab.entiteiten;

import be.vdab.dao.ProductDao;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    List<Product> basketItems = new ArrayList<Product>();

    public void addProductToBasketByProductId(int productId) {
        Product product = getProductByProductId(productId);
        addToBasket(product);
    }

    private Product getProductByProductId(int productId) {
        Product product = null;
        List<Product> products = new ProductDao().getProducts();
        for (Product prod : products) {
            if (prod.getIdProduct() == productId) {
                product = prod;
                break;
            }
        }
        return product;
    }

    private void addToBasket(Product product) {
        basketItems.add(product);
    }

    private void removeProductByProductId(int productId) {
        Product prod = getProductByProductId(productId);
        basketItems.remove(prod);
    }

    void printBasketItems() {
        for(Product prod: basketItems) {
            System.out.print(prod.getName());
        }
    }


}
