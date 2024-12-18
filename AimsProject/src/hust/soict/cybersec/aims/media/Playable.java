package hust.soict.cybersec.aims.media;

import hust.soict.cybersec.aims.exception.PlayerException;

public interface Playable {
    public String play() throws PlayerException;
}