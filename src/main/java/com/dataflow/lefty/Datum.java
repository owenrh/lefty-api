package com.dataflow.lefty;

import sun.misc.Unsafe;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by Owen Rees-Hayward on 01/11/2016.
 */
public abstract class Datum {

    protected static Unsafe unsafe;

    /**
     * Set unsafe for the datum.
     *
     * @param unsafe region
     */
    protected void setUnsafe(final Unsafe unsafe) {
        Datum.unsafe = unsafe;
    }

    /**
     *
     * @return
     */
    public abstract long getObjectSize();

    /**
     * Set unsafe offset to point to next data.
     *
     * @param objectOffset offset in the unsafe
     */
    public abstract void setObjectOffset(long objectOffset);

    /**
     * Get datum mapped onto unsafe at index by datum.
     *
     * @param address memory address allocated to the unsafe region
     * @param index index of datum, e.g. 2 of N data points (gets translated into bytes)
     * @return datum for the index
     */
    public abstract Datum get(long address, int index);

    /**
     * Stores the datum from unsafe into the target byte buffer.
     *
     * @param buffer target ByteBuffer
     */
    public abstract void store(ByteBuffer buffer);

    /**
     * Load datum from the buffer into the current unsafe position.
     *
     * @param buffer source byte buffer
     */
    public abstract void load(ByteBuffer buffer);

    /**
     * Load datum from the input stream into the current unsafe position.
     *
     * @param is source input stream
     */
    public abstract void load(DataInputStream is) throws IOException;
}
