In this Java project, queues were employed to make each note within a text file audible.

A text file with such notes would be represented as such:

0.2 C 4 NATURAL false
0.4 F 4 NATURAL true
0.2 F 4 NATURAL false
0.4 G 4 NATURAL false
0.2 G 4 NATURAL true
0.2 A 4 NATURAL false
0.4 R false
0.2 C 5 NATURAL false
0.2 A 4 NATURAL false

Each line represents a single note with the first number describing the length of the note in seconds. 

The letter that follows describes the pitch of the note, using the standard set of letters (A – G) or R if the note is a rest.

For notes other than rests, the third item on the line is the octave that the note is in and the following is the note's accidental* value.

The final piece of information for all notes is true if the note is the start or stop of a repeated section and false otherwise.

*Accidental in this case would refer to the a note that is out of key. It would otherwise be referred to as sharp, flat, or natural.
