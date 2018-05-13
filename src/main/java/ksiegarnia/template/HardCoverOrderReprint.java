package ksiegarnia.template;

public class HardCoverOrderReprint extends OrderReprint {
    @Override
    public void notifyBookstore() {
        System.out.println("Hard cover notify Bookstore");
    }

    @Override
    public void notifyPrintingHouse() {
        System.out.println("Hard cover notify Printing house");
    }
}
