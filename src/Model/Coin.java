package Model;

public enum Coin {
    ONE_RUPEE(1), TWO_RUPEE(5), TEN_RUPEE(10), TWENTY_RUPEE(20);
    public int value;
    Coin(int value){
        this.value = value;
    }

}
