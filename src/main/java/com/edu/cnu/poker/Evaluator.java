package com.edu.cnu.poker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {
    public Genealogy evaluate(List<Card> cardList) {
        Map<Suit, Integer> tempMap = new HashMap<Suit, Integer>();
        Map<Integer, Integer> tempMap2 = new HashMap<Integer, Integer>();
        for (Card card : cardList) {
            if (tempMap.containsKey(card.getSuit())) {
                Integer count = tempMap.get(card.getSuit());
                count = new Integer(count.intValue() + 1);
                tempMap.put(card.getSuit(), count);
            } else {
                tempMap.put(card.getSuit(), new Integer(1));
            }
        }
        for (Card card : cardList) {
            if (tempMap2.containsKey(card.getRank())) {
                Integer count = tempMap2.get(card.getRank());
                count = new Integer(count.intValue() + 1);
                tempMap2.put(card.getRank(), count);
            } else {
                tempMap2.put(card.getRank(), new Integer(1));
            }
        }
        int count;
        for (Suit key : tempMap.keySet()) {
            count = 0;
            if (tempMap.get(key) != 5)
                break;
            for (Card card : cardList) {
                if (card.getRank() == 1)
                    count++;
                if (card.getRank() == 10)
                    count++;
                if (card.getRank() == 11)
                    count++;
                if (card.getRank() == 12)
                    count++;
                if (card.getRank() == 13)
                    count++;
                if (count == 5)
                    return Genealogy.ROALSTRAIGHTFLUSH;
            }
        }

        count = 0;
        for (Integer key : tempMap2.keySet()) {
            if (tempMap2.get(key) == 4) {
                return Genealogy.FOUROFAKIND;
            } else if (tempMap2.get(key) == 3) {

                return Genealogy.TRIPLE;
            } else if (tempMap2.get(key) == 2) {
                count++;
            }
        }
        if (count == 2)
            return Genealogy.TWOPAIR;
        else if (count == 1)
            return Genealogy.ONEPAIR;

        count = 0;
        for (Card card : cardList) {
            if (card.getRank() == 1)
                count++;
            if (card.getRank() == 2)
                count++;
            if (card.getRank() == 3)
                count++;
            if (card.getRank() == 4)
                count++;
            if (card.getRank() == 5)
                count++;
            if (count == 5)
                return Genealogy.BACKSTRAIGHT;
        }

        for (Suit key : tempMap.keySet()) {
            if (tempMap.get(key) == 5) {
                return Genealogy.FLUSH;
            }
        }
        int index = 0;
        int check = 0;
        int[] arr = new int[5];
        for (Card card : cardList)
            arr[index++] = card.getRank();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 == (arr[i + 1]))
                check++;
            else
                break;
        }
        if (check == 4)
            return Genealogy.STRAIGHT;
        for (Suit key : tempMap.keySet()) {
            count = 0;
            if (tempMap.get(key) != 5)
                for (Card card : cardList) {
                    if (card.getRank() == 1)
                        count++;
                    if (card.getRank() == 10)
                        count++;
                    if (card.getRank() == 11)
                        count++;
                    if (card.getRank() == 12)
                        count++;
                    if (card.getRank() == 13)
                        count++;
                    if (count == 5)
                        return Genealogy.MOUNTAIN;
                }
        }


        return Genealogy.NOTTING;
    }
}