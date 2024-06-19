package ref.ex;

import java.util.Scanner;

public class ProductOrderMain3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int count = scanner.nextInt();
        scanner.nextLine();

        ProductOrder[] orders = new ProductOrder[count];
        for(int i = 0; i < orders.length; i++) {
            System.out.println(i+1 + "번째 주문 정보를 입력하세요.");

            System.out.print("상품명: ");
            String productName = scanner.nextLine();

            System.out.print("가격: ");
            int price = scanner.nextInt();

            System.out.print("수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            orders[i] = createOrder(productName, price, quantity);
        }

        printOrders(orders);

        int totalAmount = getTotalAmount(orders);
        System.out.println("총 결제 금액 : " + totalAmount);
    }

    static int getTotalAmount(ProductOrder[] orders) {
        int totalAmount = 0;
        for (ProductOrder o : orders) {
            totalAmount += o.price * o.quantity;
        }

        return totalAmount;
    }

    static void printOrders(ProductOrder[] orders) {
        for (ProductOrder o : orders) {
            System.out.println("상품명: " + o.productName + ", 가격: " + o.price + ", 수량: " + o.quantity);
        }
    }

    static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.productName = productName;
        productOrder.price = price;
        productOrder.quantity = quantity;
        return productOrder;
    }
}