/*
 *  roombajssc
 *
 *  MIT License
 *
 *  Copyright (c) 2016 Geoffrey Mastenbroek, geoffrey@maschel.com
 *
 *  Permission is hereby granted, free of charge, to any person
 *  obtaining a copy of this software and associated documentation
 *  files (the "Software"), to deal in the Software without
 *  restriction, including without limitation the rights to use,
 *  copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following
 *  conditions:
 *
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 *  OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 *  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 *  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 *  OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.maschel.roomba.song;

/**
 * Class used for describing Roomba Songs
 * A RoombaSongNote consists of a note (RoombaNote) and a
 * duration (RoombaNoteDuration)
 */
public class RoombaSongNote {

    private RoombaNote note;
    private RoombaNoteDuration duration;

    public RoombaSongNote(RoombaNote note, RoombaNoteDuration duration) {
        this.note = note;
        this.duration = duration;
    }

    public RoombaNote getNote() {
        return note;
    }

    public RoombaNoteDuration getDuration() {
        return duration;
    }

    /**
     * Get the byte array of give RoombaSongNote array.
     * @param notes RoombaSongNote array
     * @param tempo Tempo in BPM at which notes should be played
     * @return byte[] of notes and note duration.
     */
    public static byte[] songNotesToBytes(RoombaSongNote[] notes, int tempo) {
        byte[] bytes = new byte[notes.length * 2];
        int cursor = 0;
        for (RoombaSongNote note: notes) {
            bytes[cursor++] = note.note.getNoteByte();
            bytes[cursor++] = note.duration.getDurationByte(tempo);
        }
        return bytes;
    }
}
