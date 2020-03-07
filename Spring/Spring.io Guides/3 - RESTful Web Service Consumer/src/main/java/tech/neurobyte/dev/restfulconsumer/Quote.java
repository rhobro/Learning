/*
 * Copyright © 2019 NeuroByte Tech. All rights reserved.
 *
 * NeuroByte Tech is the Developer Company of Rohan Mathew.
 *
 * Project: RESTfulConsumer
 * File Name: Quote.java
 * Last Modified: 31/12/2019, 15:58
 */

package tech.neurobyte.dev.restfulconsumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    @JsonProperty("type")
    private String quoteType;
    @JsonProperty("value")
    private Value quoteValue;

    public Quote() {

    }

    public String getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(String quoteType) {
        this.quoteType = quoteType;
    }

    public Value getQuoteValue() {
        return quoteValue;
    }

    public void setQuoteValue(Value quoteValue) {
        this.quoteValue = quoteValue;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + quoteType + '\'' +
                ", value=" + quoteValue +
                '}';
    }
}
