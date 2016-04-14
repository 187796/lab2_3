package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class SearchResultStub implements SearchResult {
   
    private int position = -1;

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isFound() {
        return position > -1;
    }

    public int getPosition() {
        return position;
    }
}