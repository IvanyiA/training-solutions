package collectionsqueue.collectionsdequeue;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;

public class JobQueue {

    public Deque<Job> addJobByUrgency(Job... jobs) {
        Deque<Job> jobDeque = new ArrayDeque<>();
        for (Job j : jobs) {
            if (j.isUrgent()) {
                jobDeque.addFirst(j);
            } else {
                jobDeque.addLast(j);
            }
        }
        return jobDeque;
    }

    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get rest!");
        }
        return jobs.getFirst();
    }


    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get rest!");
        }
        return jobs.getLast();
    }
}
