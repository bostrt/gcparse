package com.redhat.gcparser.model;

import com.redhat.gcparser.model.space.OldGeneration;
import com.redhat.gcparser.model.space.PermanentGeneration;
import com.redhat.gcparser.model.space.YoungGeneration;

/**
 * Created by rbost on 6/26/15.
 */
public class ParallelEvent {
    private double timestamp;
    private Phase phase;
    private Size size;
    private YoungGeneration youngGenerationSize;
    private OldGeneration oldGenerationSize;
    private PermanentGeneration permanentGenerationSize;
    private double timeTaken;
    private Times timeTakenDetail;

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

    public YoungGeneration getYoungGenerationSize() {
        return youngGenerationSize;
    }

    public void setYoungGenerationSize(YoungGeneration youngGenerationSize) {
        this.youngGenerationSize = youngGenerationSize;
    }

    public OldGeneration getOldGenerationSize() {
        return oldGenerationSize;
    }

    public void setOldGenerationSize(OldGeneration oldGenerationSize) {
        this.oldGenerationSize = oldGenerationSize;
    }

    public PermanentGeneration getPermanentGenerationSize() {
        return permanentGenerationSize;
    }

    public void setPermanentGenerationSize(PermanentGeneration permanentGenerationSize) {
        this.permanentGenerationSize = permanentGenerationSize;
    }

    public double getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(double timeTaken) {
        this.timeTaken = timeTaken;
    }

    public Times getTimeTakenDetail() {
        return timeTakenDetail;
    }

    public void setTimeTakenDetail(Times timeTakenDetail) {
        this.timeTakenDetail = timeTakenDetail;
    }

    @Override
    public String toString() {

        // 288K->246K(10240K)
        // Or
        // 59[PSYoungGen: 147904K->4783K(148288K)] 907842K->769258K(916288K)
        // [PSYoungGen: 4783K->0K(148288K)] [PSOldGen: 764475K->660316K(768000K)] 769258K->660316K(916288K) [PSPermGen: 1850K->1850K(12288K)]
        String sizes = "";

        if (youngGenerationSize != null && oldGenerationSize != null && permanentGenerationSize != null) {
            sizes = String.format("%s %s %s %s", youngGenerationSize, oldGenerationSize, size, permanentGenerationSize);
        } else if (youngGenerationSize != null) {
            sizes = String.format("%s %s", youngGenerationSize, size);
        } else {
            sizes = size.toString();
        }

        // 0.053: [Full GC 288K->246K(10240K), 0.0062090 secs]
        // 60.060: [Full GC [PSYoungGen: 4783K->0K(148288K)] [PSOldGen: 764475K->660316K(768000K)] 769258K->660316K(916288K) [PSPermGen: 1850K->1850K(12288K)], 1.2817061 secs] [Times: user=1.26 sys=0.00, real=1.28 secs]
        String toReturn = String.format("%.3f: [%s %s, %.7f secs]", timestamp, phase, sizes, timeTaken);

        if (timeTakenDetail != null) {
            toReturn += " " + timeTakenDetail;
        }

        return toReturn;
    }
}
