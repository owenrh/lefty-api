package com.dataflow.lefty;

import java.util.List;
import java.util.Map;

/**
 * Created by Owen Rees-Hayward on 31/10/2016.
 */
public interface Processor<T extends Datum, R extends Object> {

    /**
     * Set context on the processor.
     *
     * @param ctx processor context
     */
    void setContext(Map<String,String> ctx);

    /**
     * Process the passed datum and populate 'matches' in the response data list.
     *
     * @param responseData list of 'matches'
     * @param datum piece of data to match
     */
    void processDatum(List<R> responseData, T datum);
}
