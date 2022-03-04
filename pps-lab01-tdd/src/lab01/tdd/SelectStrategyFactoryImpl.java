package lab01.tdd;

public class SelectStrategyFactoryImpl implements SelectStrategyFactory{

    @Override
    public SelectStrategy createEvenStrategy() {
        return elem -> elem % 2 ==0;
    }

    @Override
    public SelectStrategy createMultipleOfStrategy(Integer element) {
        return elem -> (elem % element) ==0;
    }

    @Override
    public SelectStrategy createEqualsStrategy(Integer element) {
        return elem -> elem.equals(element);
    }
}
