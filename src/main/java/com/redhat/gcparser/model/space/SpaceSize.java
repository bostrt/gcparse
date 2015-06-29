package com.redhat.gcparser.model.space;

import com.redhat.gcparser.model.Size;

/**
 * Created by rbost on 6/28/15.
 */
public abstract class SpaceSize {
    private Space space;
    private Size size;

    public SpaceSize(Space space, Size size) {
        this.space = space;
        this.size = size;
    }

    public SpaceSize(Space space, int before, int after, int committed) {
        this(space, new Size(before, after, committed));
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return String.format("[%s: %s]", space, size);
    }
}
