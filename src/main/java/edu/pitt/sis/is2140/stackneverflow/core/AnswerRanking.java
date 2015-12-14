/*
 * This class is used for ranking answers based on various parameters
 */
package edu.pitt.sis.is2140.stackneverflow.core;

import edu.pitt.sis.is2140.stackneverflow.config.RankingModel;
import edu.pitt.sis.is2140.stackneverflow.model.Answer;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Wu
 */
public class AnswerRanking {

    /**
     * Sort answer list based on different parameters
     *
     * @param input
     * @return
     */
    public static List<Answer> ranking(List<Answer> input) {
        PriorityQueue<Answer> heap = new PriorityQueue(new Comparator<Answer>() {

            @Override
            public int compare(Answer o1, Answer o2) {
                return o1.compareTo(o2);
            }

        });
        int size = (int) (input.size() * RankingModel.accept_percentage);
        for (Answer a : input) {
            if (heap.size() < size) {
                heap.add(a);
            } else {
                if (heap.peek().compareTo(a) == -1) {
                    heap.poll();
                    heap.add(a);
                }
            }
        }
        List<Answer> res = new LinkedList();
        while (!heap.isEmpty()) {
            res.add(0, heap.poll());
        }
        return res;
    }
}
