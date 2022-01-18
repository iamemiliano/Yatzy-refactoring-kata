public enum Category {
    Pair(2),
    ThreeOfaKind(3),
    FourOfaKind(4);

    private int value;

    Category(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
