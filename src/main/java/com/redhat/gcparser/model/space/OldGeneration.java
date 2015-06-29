package com.redhat.gcparser.model.space;

import com.redhat.gcparser.model.Size;

/**
 * Created by rbost on 6/28/15.
 */
public class OldGeneration extends SpaceSize {
    public OldGeneration(Size size) {
        super(Space.PSOldGen, size);
    }
}
