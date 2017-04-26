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
    public void SUIT가_같은_AKQJ10은_로열스트레이트플러쉬() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(10, Suit.CLUBS),
                new Card(11, Suit.CLUBS),
                new Card(12, Suit.CLUBS),
                new Card(13, Suit.CLUBS)
        );
        Genealogy result = evaluator.evaluate(cardList);
        assertThat(result, is(Genealogy.ROALSTRAIGHTFLUSH));
    }

    @Test
    public void 같은_SUIT의_CARD가_A부터5까지면_백스트레이트플러쉬() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(2, Suit.CLUBS),
                new Card(3, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.CLUBS)
        );
        Genealogy result = evaluator.evaluate(cardList);
        assertThat(result, is(Genealogy.BACKSTRAIGHTFLUSH));
    }

    @Test
    public void 같은_SUIT의_5개의_연속된_숫자면_스트레이트플러쉬() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.CLUBS),
                new Card(6, Suit.CLUBS),
                new Card(7, Suit.CLUBS),
                new Card(8, Suit.CLUBS)
        );
        Genealogy result = evaluator.evaluate(cardList);
        assertThat(result, is(Genealogy.STRAIGHTFLUSH));
    }

    @Test
    public void RANK가_4개가동일하면_포카드() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(4, Suit.CLUBS),
                new Card(4, Suit.DIAMONDS),
                new Card(4, Suit.HEARTS),
                new Card(6, Suit.HEARTS),
                new Card(4, Suit.SPADES)
        );
        Genealogy result = evaluator.evaluate(cardList);
        assertThat(result, is(Genealogy.FOUROFAKIND));
    }

    @Test
    public void RANK가_동일한수가3개_동일한수가2개이면_풀하우스() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(1, Suit.DIAMONDS),
                new Card(1, Suit.CLUBS),
                new Card(2, Suit.SPADES),
                new Card(2, Suit.HEARTS)
        );
        Genealogy result = evaluator.evaluate(cardList);
        assertThat(result, is(Genealogy.FULLHOUSE));
    }

    @Test
    public void SUIT가_5개가동일하면_플러쉬() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(4, Suit.CLUBS),
                new Card(8, Suit.CLUBS),
                new Card(13, Suit.CLUBS),
                new Card(2, Suit.CLUBS)
        );
        Genealogy result = evaluator.evaluate(cardList);
        assertThat(result, is(Genealogy.FLUSH));
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
        Genealogy result = evaluator.evaluate(cardList);
        assertThat(result, is(Genealogy.MOUNTAIN));
    }

    @Test
    public void 카드가_A부터5까지면_백스트레이트() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.CLUBS),
                new Card(2, Suit.SPADES),
                new Card(3, Suit.HEARTS),
                new Card(4, Suit.CLUBS),
                new Card(5, Suit.DIAMONDS)
        );
        Genealogy result = evaluator.evaluate(cardList);
        assertThat(result, is(Genealogy.BACKSTRAIGHT));
    }


    @Test
    public void RANK가_연달아_3장의_카드가_존재하면_스트레이트() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(4, Suit.SPADES),
                new Card(5, Suit.CLUBS),
                new Card(6, Suit.SPADES),
                new Card(7, Suit.HEARTS),
                new Card(8, Suit.SPADES)
        );
        Genealogy result = evaluator.evaluate(cardList);
        assertThat(result, is(Genealogy.STRAIGHT));
    }

    @Test
    public void RANK가_같은_카드가_3장이면_트리플() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.SPADES),
                new Card(1, Suit.CLUBS),
                new Card(1, Suit.HEARTS),
                new Card(5, Suit.SPADES),
                new Card(8, Suit.DIAMONDS)
        );
        Genealogy result = evaluator.evaluate(cardList);
        assertThat(result, is(Genealogy.TRIPLE));
    }

    @Test
    public void RANK가_같은_카드가_2쌍이면_투페어() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.SPADES),
                new Card(1, Suit.CLUBS),
                new Card(2, Suit.DIAMONDS),
                new Card(2, Suit.HEARTS),
                new Card(7, Suit.CLUBS)
        );
        Genealogy result = evaluator.evaluate(cardList);
        assertThat(result, is(Genealogy.TWOPAIR));
    }

    @Test
    public void RANK_2개가_동일하면_원페어() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1, Suit.HEARTS),
                new Card(1, Suit.DIAMONDS),
                new Card(3, Suit.SPADES),
                new Card(5, Suit.DIAMONDS),
                new Card(7, Suit.CLUBS)
        );
        Genealogy result = evaluator.evaluate(cardList);
        assertThat(result, is(Genealogy.ONEPAIR));
    }
}
