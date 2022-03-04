package lab01.tdd;

public interface SelectStrategyFactory {

    SelectStrategy createEvenStrategy();

    SelectStrategy createMultipleOfStrategy(Integer element);

    SelectStrategy createEqualsStrategy(Integer element);

}
