package lab01.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CircularListTest {

    private CircularList circularList;
    private EvenStrategy evenStrategy;
    private MultipleOfStrategy multipleOfStrategy;
    private EqualsStrategy equalsStrategy;
    private SelectStrategyFactory circularListFactory;


    //TODO Factory

    @BeforeEach
    void setUp(){
        circularList = new SimpleCircularList();
        circularListFactory = new SelectStrategyFactoryImpl();
        evenStrategy = new EvenStrategy();
        equalsStrategy = new EqualsStrategy(4);
        multipleOfStrategy = new MultipleOfStrategy(3);

    }

    @Test
    void testSize() {
        circularList.add (1);
        circularList.add (2);
        assertEquals(2,circularList.size());
    }

    @Test
    void testIsEmpty() {
        assertEquals(0,circularList.size());
    }

    @Test
    void testAdd() {
        circularList.add (1);
        circularList.add (2);
        assertEquals(2,circularList.size());
    }

    @Test
    void testPrevious() {
        circularList.add (1);
        circularList.add (2);
        circularList.add (3);
        assertEquals(Optional.of(3),Optional.of(circularList.previous().get()));
        assertEquals(Optional.of(2),Optional.of(circularList.previous().get()));
        assertEquals(Optional.of(1),Optional.of(circularList.previous().get()));
        assertEquals(Optional.of(3),Optional.of(circularList.previous().get()));
    }

    @Test
    void testReset() {
        circularList.add (1);
        circularList.add (2);
        circularList.next();
        circularList.next();
        circularList.reset();
        assertEquals(Optional.of(1),Optional.of(circularList.next().get()));
    }

    @Test
    void testNext() {
        circularList.add (1);
        circularList.add (2);
        circularList.add (3);
        assertEquals(Optional.of(1),Optional.of(circularList.next().get()));
        assertEquals(Optional.of(2),Optional.of(circularList.next().get()));
        assertEquals(Optional.of(3),Optional.of(circularList.next().get()));
        assertEquals(Optional.of(1),Optional.of(circularList.next().get()));
    }

    @Test
    public void testEvenStrategy(){
        circularList.add(11);
        circularList.add(1);
        circularList.add(4);
        assertEquals(Optional.of(4),circularList.next(evenStrategy));
    }
    @Test
    public void testMultipleOfStrategy(){
        circularList.add(2);
        circularList.add(2);
        circularList.add(3);
        circularList.add(6);
        assertEquals(Optional.of(3),circularList.next(multipleOfStrategy));
    }
    @Test
    public void testEqualsStrategy(){
        circularList.add(2);
        circularList.add(1);
        circularList.add(4);
        assertEquals(Optional.of(4),circularList.next(equalsStrategy));
    }


    @Test
    public void testEvenStrategyWithFactory(){
        circularList.add(11);
        circularList.add(1);
        circularList.add(4);
        assertEquals(Optional.of(4),circularList.next(circularListFactory.createEvenStrategy()));
    }
    @Test
    public void testMultipleOfStrategyWithFactory(){
        circularList.add(2);
        circularList.add(2);
        circularList.add(3);
        circularList.add(6);
        assertEquals(Optional.of(3),circularList.next(circularListFactory.createMultipleOfStrategy(3)));
    }
    @Test
    public void testEqualsStrategyWithFactory(){
        circularList.add(2);
        circularList.add(1);
        circularList.add(4);
        assertEquals(Optional.of(4),circularList.next(circularListFactory.createEqualsStrategy(4)));
    }
}