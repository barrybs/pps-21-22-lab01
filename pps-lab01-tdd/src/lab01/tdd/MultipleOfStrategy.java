package lab01.tdd;

public class MultipleOfStrategy implements SelectStrategy{

    private final Integer element;

    public MultipleOfStrategy(Integer element){
        this.element = element;
    }

    @Override
    public boolean apply(Integer element) {
        return (element % this.element ==0);
    }
}
