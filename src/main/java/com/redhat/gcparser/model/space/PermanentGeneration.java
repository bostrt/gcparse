package com.redhat.gcparser.model.space;

import com.redhat.gcparser.model.Size;

/**
 * Created by rbost on 6/28/15.
 */
public class PermanentGeneration extends SpaceSize {
    public PermanentGeneration(Size size) {
        super(Space.PSPermGen, size);
    }
}
