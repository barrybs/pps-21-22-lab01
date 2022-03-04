package lab01.tdd;

public class EvenStrategy implements SelectStrategy{

    @Override
    public boolean apply(Integer element) {
        return (element % 2 == 0);
    }
}
