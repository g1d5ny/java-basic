package class1.ex;

public class ProductOrderMain {
    public static void main(String[] args) {
        ProductOrder dooboo = new ProductOrder();
        dooboo.productName = "두부";
        dooboo.price = 2000;
        dooboo.quantity = 2;

        ProductOrder kimchi = new ProductOrder();
        kimchi.productName = "김치";
        kimchi.price = 5000;
        kimchi.quantity = 1;

        ProductOrder cola = new ProductOrder();
        cola.productName = "콜라";
        cola.price = 1500;
        cola.quantity = 2;

        ProductOrder[] orders = { dooboo, kimchi, cola };

        int totalPrice = 0;
        for(ProductOrder o: orders) {
            System.out.println("상품명: " + o.productName + ", 가격: " + o.price + ", 수량: " + o.quantity);
            totalPrice+=o.price*o.quantity;
        }
        System.out.println("총 결제 금액 : " + totalPrice);
        
    }
}
