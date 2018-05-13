package ksiegarnia.template;

public class SoftCoverOrderReprint extends OrderReprint {
    @Override
    public void notifyBookstore() {
        System.out.println("Soft cover notify Bookstore");
    }

    @Override
    public void notifyPrintingHouse() {
        System.out.println("Soft cover notify Printing house");
    }
}
