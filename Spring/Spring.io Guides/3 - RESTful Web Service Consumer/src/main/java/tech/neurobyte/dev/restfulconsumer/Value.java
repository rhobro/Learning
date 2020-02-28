/*
 * Copyright © 2019 NeuroByte Tech. All rights reserved.
 *
 * NeuroByte Tech is the Developer Company of Rohan Mathew.
 *
 * Project: RESTfulConsumer
 * File Name: Value.java
 * Last Modified: 31/12/2019, 15:58
 */

package tech.neurobyte.dev.restfulconsumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("quote")
    private String quoteString;

    public Value() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuoteString() {
        return quoteString;
    }

    public void setQuoteString(String quoteString) {
        this.quoteString = quoteString;
    }

    @Override
    public String toString() {
        return "Value{" +
                "quoteID=" + id +
                ", quote='" + quoteString + '\'' +
                '}';
    }
}
