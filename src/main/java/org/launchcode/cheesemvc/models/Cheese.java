package org.launchcode.cheesemvc.models;

import java.util.HashMap;

public class Cheese {

    private String cheeseName;
    private String cheeseDescription;

    public Cheese() {
    }

    public Cheese(String cheeseName, String cheeseDescription) {
        this.cheeseName = cheeseName;
        this.cheeseDescription = cheeseDescription;
    }

    public String getCheeseName() {
        return cheeseName;
    }

    public void setCheeseName(String cheeseName) {
        this.cheeseName = cheeseName;
    }

    public String getCheeseDescription() {
        return cheeseDescription;
    }

    public void setCheeseDescription(String cheeseDescription) {
        this.cheeseDescription = cheeseDescription;
    }
}
