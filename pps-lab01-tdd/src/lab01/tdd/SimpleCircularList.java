package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList{
    private List<Integer> circularList;
    private Integer listIndex=0;

    public SimpleCircularList() {
        circularList = new ArrayList<>();
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (this.listIndex == this.circularList.size()){
            this.listIndex = 0;
        }
        Optional<Integer> element = Optional.of(this.circularList.get(this.listIndex));
        this.listIndex++;
        return element;
    }

    @Override
    public Optional<Integer> previous() {
        if (this.listIndex == 0){
            this.listIndex = circularList.size();
        }
        this.listIndex--;
        return Optional.of(this.circularList.get(this.listIndex));
    }

    @Override
    public void reset() {
        this.listIndex = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        Optional<Integer> nextElement;
        for (int i=0; i < this.circularList.size(); i++){
            nextElement = this.next();
            if (nextElement.isPresent() && strategy.apply(nextElement.get())){
                return nextElement;
            }
        }
        return Optional.empty();
    }
}