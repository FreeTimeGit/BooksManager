package ksiegarnia.template;

public abstract class OrderReprint {

    public void orderReprint(){
        beginOrderReprint();
        notifyPrintingHouse();
        endOrderReprint();
        notifyBookstore();

    }

    public abstract void notifyBookstore();

    public abstract void notifyPrintingHouse();

    private void endOrderReprint() {
        System.out.println("End order");
    }

    private void beginOrderReprint() {
        System.out.println("Begin order");
    }

}
