package com.redhat.gcparser.model.space;

import com.redhat.gcparser.model.Size;

/**
 * Created by rbost on 6/28/15.
 */
public class YoungGeneration extends SpaceSize {
    public YoungGeneration(Size size) {
        super(Space.PSYoungGen, size);
    }
}
