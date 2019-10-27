package com.codeerow.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Validation<S> {
    private S subject;
    private List<Rule<S>> rules;


    public Validation(S subject, Rule<S>... rules) {
        this.subject = subject;
        this.rules = Arrays.asList(rules);
    }

    public Validation(S subject, List<Rule<S>> rules) {
        this.subject = subject;
        this.rules = rules;
    }


    boolean isValid() {
        for (Rule<S> rule : rules) {
            if (!rule.execute(subject)) return false;
        }
        return true;
    }


    public static class Builder<S> {
        private S subject;
        private List<Rule<S>> rules = new ArrayList<>();

        public Builder(S subject) {
            this.subject = subject;
        }


        public Builder addRule(Rule<S> rule) {
            this.rules.add(rule);
            return this;
        }

        public Validation<S> build() {
            return new Validation<>(subject, rules);
        }
    }
}
