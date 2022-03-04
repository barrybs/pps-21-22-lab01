package lab01.tdd;

public class EqualsStrategy implements SelectStrategy{

    private final Integer element;

    public EqualsStrategy(Integer element){
        this.element = element;
    }

    @Override
    public boolean apply(Integer element) {
        return (element.equals(this.element));
    }
}
