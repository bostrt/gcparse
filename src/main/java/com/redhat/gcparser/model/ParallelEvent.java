package com.redhat.gcparser.model;

/**
 * Created by rbost on 6/26/15.
 */
public class ParallelEvent {
    private double timestamp;
    private Phase phase;
    private Size size;
    private Size youngGenerationSize;
    private Size oldGenerationSize;
    private Size permanentGenerationSize;
    private double timeTaken;
    private Times times;

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getYoungGenerationSize() {
        return youngGenerationSize;
    }

    public void setYoungGenerationSize(Size youngGenerationSize) {
        this.youngGenerationSize = youngGenerationSize;
    }

    public Size getOldGenerationSize() {
        return oldGenerationSize;
    }

    public void setOldGenerationSize(Size oldGenerationSize) {
        this.oldGenerationSize = oldGenerationSize;
    }

    public Size getPermanentGenerationSize() {
        return permanentGenerationSize;
    }

    public void setPermanentGenerationSize(Size permanentGenerationSize) {
        this.permanentGenerationSize = permanentGenerationSize;
    }

    public double getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(double timeTaken) {
        this.timeTaken = timeTaken;
    }

    public Times getTimes() {
        return times;
    }

    public void setTimes(Times times) {
        this.times = times;
    }
}
