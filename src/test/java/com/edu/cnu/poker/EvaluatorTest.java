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
    public void RANK가_동일한수가3개_동일한수가2개이면_FULLHOUSE이다(){
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

    @Test
    public void RANK가_4개가동일하면_포카드다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(4,Suit.CLUBS),
                new Card(4,Suit.DIAMONDS),
                new Card(4,Suit.HEARTS),
                new Card(6,Suit.HEARTS),
                new Card(4,Suit.SPADES)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FOURCARD"));
    }

    @Test
    public void RANK_2개가_동일하면_원페어(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.HEARTS),
                new Card(3, Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("ONEPAIR"));
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
  }
