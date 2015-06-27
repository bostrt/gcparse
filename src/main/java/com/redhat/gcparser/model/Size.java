package com.redhat.gcparser.model;

/**
 * Created by rbost on 6/26/15.
 */
public class Size {
    private int before;
    private int after;
    private int committed;

    public Size(int before, int after, int committed) {
        this.before = before;
        this.after = after;
        this.committed = committed;
    }

    public int getBefore() {
        return before;
    }

    public void setBefore(int before) {
        this.before = before;
    }

    public int getAfter() {
        return after;
    }

    public void setAfter(int after) {
        this.after = after;
    }

    public int getCommitted() {
        return committed;
    }

    public void setCommitted(int committed) {
        this.committed = committed;
    }

    @Override
    public String toString() {
        // 907842K->769258K(916288K)
        return String.format("%dK->%dK(%dK)", before, after, committed);
    }
}
