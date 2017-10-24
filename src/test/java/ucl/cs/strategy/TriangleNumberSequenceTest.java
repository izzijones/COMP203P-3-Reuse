package ucl.cs.strategy;

import org.junit.Test;
import ucl.cs.matchers.IterableBeginsWith;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class TriangleNumberSequenceTest {
    final Sequence sequence = new Sequence(new TriangleNumberTerm());

    @Test
    public void definesFirstTermToBeOne() {

        assertThat(sequence.term.term(0), is(1));
    }

    @Test
    public void definesSubsequentTermsComputedCorrectly() {

        assertThat(sequence.term.term(1), is(3));
        assertThat(sequence.term.term(2), is(6));
        assertThat(sequence.term.term(3), is(10));
    }

    @Test
    public void isUndefinedForNegativeIndices() {

        try {
            sequence.term.term(-1);
            fail("should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), containsString("Not defined for indices < 0"));
        }
    }

    @Test
    public void canBeIteratedThrough() {
        assertThat(sequence, IterableBeginsWith.beginsWith(1, 3, 6, 10, 15));
    }

}
