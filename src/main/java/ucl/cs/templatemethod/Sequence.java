package ucl.cs.templatemethod;

import java.util.Iterator;

public abstract class Sequence implements Iterable<Integer>{
    public Iterator<Integer> iterator() {
        return new SequenceIterator();
    }
    public abstract int term(int i);

    private class SequenceIterator implements Iterator<Integer> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return term(index++);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not implemented");
        }
    }
}
