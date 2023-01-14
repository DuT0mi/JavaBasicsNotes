package org.example;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class List {
    private ArrayList<String> people = new ArrayList<String>();

    public void add(String pPeople){
        people.add(pPeople);
    }
    public void remove(String pPeople){
        if(!people.contains(pPeople)){
            throw new NoSuchElementException();
        }
        people.remove(pPeople);
    }

    public int getSize(){
        return this.people.size();
    }
    public boolean isEmpty(){
        return this.people.isEmpty();
    }
    public void deleteAll(){
        this.people.clear();
    }
}
