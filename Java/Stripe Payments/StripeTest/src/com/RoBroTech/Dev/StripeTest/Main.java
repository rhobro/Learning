/*
 * Copyright (c) 2019 RoBro Tech. All rights reserved.
 *
 * RoBro Tech is the Developer Company of Rohan Mathew.
 *
 * Project: Stripe Test
 * File Name: Main.java
 * Last Modified: 16/08/2019, 15:05
 */

package com.RoBroTech.Dev.StripeTest;

import com.stripe.Stripe;
import com.stripe.model.Customer;
import com.stripe.model.Source;
import com.stripe.model.Token;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.PaymentSourceCollectionCreateParams;
import com.stripe.param.SourceCreateParams;
import com.stripe.param.TokenCreateParams;
import com.stripe.param.TokenCreateParams.Card;

public class Main {

    public static void main(String[] args) throws Exception {
        Stripe.apiKey = "sk_test_MB9Etccn5OU7fNZm3UayCtUS00aW0SYDUX";

        /*CustomerCreateParams.Builder customerCreateParamsBuilder = CustomerCreateParams.builder();
        customerCreateParamsBuilder.setName("Rohan Mathew");
        customerCreateParamsBuilder.setPhone("07445032112");
        customerCreateParamsBuilder.setEmail("robozmat@gmail.com");
        CustomerCreateParams.Address.Builder addressBuilder = CustomerCreateParams.Address.builder();
        addressBuilder.setLine1("6 Willowbrook Manor");
        addressBuilder.setLine2("Horbury");
        addressBuilder.setCity("Wakefield");
        addressBuilder.setState("West Yorkshire");
        addressBuilder.setPostalCode("WF4 5FA");
        addressBuilder.setCountry("United Kingdom");
        customerCreateParamsBuilder.setAddress(addressBuilder.build());
        Customer customer = Customer.create(customerCreateParamsBuilder.build());*/

        Customer customer = Customer.retrieve("cus_Fiwjd37ZhnninQ");

        Card.Builder cardBuilder = Card.builder();
        cardBuilder.setName(customer.getName());
        cardBuilder.setNumber("1234567890123456");
        cardBuilder.setExpMonth("2");
        cardBuilder.setExpYear("2022");
        cardBuilder.setCvc("123");
        cardBuilder.setCurrency("gbp");
        cardBuilder.setAddressLine1("6 Willowbrook Manor");
        cardBuilder.setAddressLine2("Horbury");
        cardBuilder.setAddressCity("Wakefield");
        cardBuilder.setAddressState("West Yorkshire");
        cardBuilder.setAddressZip("WF4 5FA");
        cardBuilder.setAddressCountry("United Kingdom");

        TokenCreateParams.Builder tokenCreateParamsBuilder = TokenCreateParams.builder();
        tokenCreateParamsBuilder.setCustomer(customer.getId());
        tokenCreateParamsBuilder.setCard(cardBuilder.build());

        SourceCreateParams.Builder sourceCreateParamsBuilder = SourceCreateParams.builder();
        sourceCreateParamsBuilder.setToken(Token.create(tokenCreateParamsBuilder.build()).getId());
        Source source = Source.create(sourceCreateParamsBuilder.build());

        PaymentSourceCollectionCreateParams.Builder paymentSourceCollectionCreateParamsBuilder = PaymentSourceCollectionCreateParams.builder();
        paymentSourceCollectionCreateParamsBuilder.setSource(source.getId());

        customer.getSources().create(paymentSourceCollectionCreateParamsBuilder.build());
    }
}
