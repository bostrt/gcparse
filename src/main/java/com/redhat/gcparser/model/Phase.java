package com.redhat.gcparser.model;

/**
 * Created by rbost on 6/25/15.
 */
public enum Phase {
    MINOR_GC("GC"),
    FULL_GC("Full GC"),
    CMS_CONCURRENT_MARK_START("CMS-concurrent-mark-start"),
    CMS_CONCURRENT_MARK("CMS-concurrent-mark"),
    CMS_CONCURRENT_ABORTABLE_PRECLEAN_START("CMS-concurrent-abortable-preclean-start"),
    CMS_CONCURRENT_PRECLEAN_START("CMS-concurrent-preclean-start"),
    CMS_CONCURRENT_PRECLEAN("CMS-concurrent-preclean"),
    ;

    private String eventTypeName;

    private Phase(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getEventTypeName() {
        return this.eventTypeName;
    }
}
