package com.codeerow.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Validation<S> {
    private Provider<S> subjectProvider;
    private List<Rule<S>> rules;
    private List<Handler<Boolean>> handlers;


    public Validation(Provider<S> subjectProvider, Rule<S>... rules) {
        this.subjectProvider = subjectProvider;
        this.rules = Arrays.asList(rules);
        this.handlers = new ArrayList<>();
    }

    public Validation(Provider<S> subjectProvider, List<Rule<S>> rules, List<Handler<Boolean>> handlers) {
        this.subjectProvider = subjectProvider;
        this.rules = rules;
        this.handlers = handlers;
    }


    boolean validate() {
        boolean result = true;
        S subject = subjectProvider.provide();

        for (Rule<S> rule : rules) {
            boolean isValid = rule.execute(subject);
            if (!isValid) result = false;
        }

        for (Handler<Boolean> handler : handlers) {
            handler.handle(result);
        }
        return result;
    }


    public static class Builder<S> {
        private Provider<S> subjectProvider;
        private List<Rule<S>> rules = new ArrayList<>();
        private List<Handler<Boolean>> handlers = new ArrayList<>();

        public Builder(Provider<S> subjectProvider) {
            this.subjectProvider = subjectProvider;
        }


        public Builder addRule(Rule<S> rule) {
            this.rules.add(rule);
            return this;
        }

        public Builder addHandler(Handler<Boolean> handler) {
            this.handlers.add(handler);
            return this;
        }


        public Validation<S> build() {
            return new Validation<>(subjectProvider, rules, handlers);
        }
    }
}
