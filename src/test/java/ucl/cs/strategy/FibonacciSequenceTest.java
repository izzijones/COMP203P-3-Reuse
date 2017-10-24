package ucl.cs.strategy;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

import org.junit.Test;
import ucl.cs.matchers.IterableBeginsWith;

public class FibonacciSequenceTest {

  final Sequence sequence = new Sequence(new FibonacciTerm());

  @Test
  public void definesFirstTwoTermsToBeOne() {

    assertThat(sequence.term.term(0), is(1));
    assertThat(sequence.term.term(1), is(1));
  }

  @Test
  public void definesSubsequentTermsToBeTheSumOfThePreviousTwo() {

    assertThat(sequence.term.term(2), is(2));
    assertThat(sequence.term.term(3), is(3));
    assertThat(sequence.term.term(
            4), is(5));
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
    assertThat(sequence, IterableBeginsWith.beginsWith(1, 1, 2, 3, 5));
  }

}