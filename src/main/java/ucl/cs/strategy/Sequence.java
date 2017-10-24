package ucl.cs.strategy;

import java.util.Iterator;

public class Sequence implements Iterable<Integer>{
    Term term;

    public Sequence(Term t){
        term = t;
    }
    public Iterator<Integer> iterator() {
        return new SequenceIterator();
    }

    private class SequenceIterator implements Iterator<Integer> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return term.term(index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not implemented");
        }
    }
}
