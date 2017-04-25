package com.edu.cnu.poker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by cse on 2017-04-17.
 */
public class EvaluatorTest {

    @Test
    public void SUIT가_5개가동일하면_플러쉬다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(8, Suit.CLUBS),
                new Card(13, Suit.CLUBS),
                new Card(2, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FLUSH"));
    }

    @Test
    public void RANK가_같은_카드가_2쌍이면_투페어다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.SPADES),
                new Card(1, Suit.CLUBS),
                new Card(2, Suit.DIAMONDS),
                new Card(2, Suit.HEARTS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("TWOPAIR"));
    }

    @Test
    public void RANK가_같은_카드가_3장이면_트리플이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.SPADES),
                new Card(1, Suit.CLUBS),
                new Card(1, Suit.HEARTS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("TRIPPLE"));
    }

    @Test
    public void RANK가_같은_카드가_3장이면_트리플이다() {
        Evaluator evaluator = new Evaluator();
        int rank = 1;
        List<Card> cardList = Arrays.asList(
                new Card(rank, Suit.SPADES),
                new Card(rank + 1, Suit.SPADES),
                new Card(rank + 2, Suit.SPADES),
                new Card(rank + 3, Suit.SPADES),
                new Card(rank + 4, Suit.SPADES)
                );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("STRAIGHT"));
    }
}