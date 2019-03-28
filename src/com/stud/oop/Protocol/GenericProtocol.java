package com.stud.oop.Protocol;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericProtocol implements IProtocol {

    private List<String> knownVerbs;
    private List<String> answers;

    GenericProtocol(){
        knownVerbs = new ArrayList<>();
        answers = new ArrayList<>();
        initialise();
    }

    public final int addVerbAndAnswer(String verb, String answer) {
        knownVerbs.add(verb.toUpperCase());
        answers.add(answer.toUpperCase());
        return answers.size();
    }

    public String processInput(String input) {

        int index = knownVerbs.indexOf(input.toUpperCase());

        if (index > -1) {
            return answers.get(index);
        }

        return null;
    }
}
