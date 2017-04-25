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
    public void RANK가_동일한수가3개_동일한수가2개이면_FULLHOUSE이다() {
        Evaluator evaluator = new Evaluator();
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
    public void RANK가_연달아_3장의_카드가_존재하면_스트레이트이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.SPADES),
                new Card(2, Suit.CLUBS),
                new Card(3, Suit.SPADES),
                new Card(4, Suit.HEARTS),
                new Card(5, Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("STRAIGHT"));
    }

    @Test
    public void SUIT가_같은_AKQJ10은_로열스트레이트플러쉬이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(10, Suit.CLUBS),
                new Card(11, Suit.CLUBS),
                new Card(12, Suit.CLUBS),
                new Card(13, Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("ROALSTRAIGHTFLUSH"));
    }

    @Test
    public void RANK가_연달아_3장의_카드가_존재하면_마운틴이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.SPADES),
                new Card(13, Suit.CLUBS),
                new Card(12, Suit.SPADES),
                new Card(11, Suit.HEARTS),
                new Card(10, Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("MOUNTAIN"));
    }

    @Test
    public void RANK가_4개가동일하면_포카드다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(4, Suit.CLUBS),
                new Card(4, Suit.DIAMONDS),
                new Card(4, Suit.HEARTS),
                new Card(6, Suit.HEARTS),
                new Card(4, Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FOURCARD"));
    }

    @Test
    public void RANK_2개가_동일하면_원페어() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.HEARTS),
                new Card(3, Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("ONEPAIR"));
    }

}

    @Test
    public void RANK가_동일한수가_3개_동일한수가_2개이면_FULLHOUSE이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(4,Suit.CLUBS),
                new Card(4,Suit.DIAMONDS),
                new Card(4,Suit.HEARTS),
                new Card(6,Suit.HEARTS),
                new Card(6,Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FULLHOUSE"));
    }

    @Test
    public void SUIT가_같은_AKQJ10은_로열스트레이트플러쉬이다(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(10,Suit.CLUBS),
                new Card(11,Suit.CLUBS),
                new Card(12,Suit.CLUBS),
                new Card(13,Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("ROALSTRAIGHTFLUSH"));
    }
  }
