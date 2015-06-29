package com.redhat.gcparser.model.space;

/**
 * Created by rbost on 6/28/15.
 */
public enum Space {
    PSYoungGen("PSYoungGen"),
    PSOldGen("PSOldGen"),
    PSPermGen("PSPermGen")
    ;

    private String spaceName;

    private Space(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpaceName() {
        return spaceName;
    }
}
