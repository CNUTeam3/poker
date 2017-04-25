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
                new Card(1,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(8,Suit.CLUBS),
                new Card(13,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FLUSH"));
    }
<<<<<<< HEAD
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
=======

    @Test
    public void RANK_2개가_동일하면_원페어(){
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(3, Suit.HEARTS),
                new Card(3, Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("ONEPAIR"));
>>>>>>> 22cde927ba0416d26eaaba5c1b35152f62e5a951
    }
}