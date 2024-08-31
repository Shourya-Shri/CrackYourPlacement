 /* ExhaustiveSolve
* ---------------
* This is the "not-very-smart" version of cryptarithmetic solver. It takes
* the puzzle itself (with the 3 strings for the two addends and sum) and a
* string of letters as yet unassigned. If no more letters to assign
* then we've hit a base-case, if the current letter-to-digit mapping solves
* the puzzle, we're done, otherwise we return false to trigger backtracking
* If we have letters to assign, we take the first letter from that list, and
* try assigning it the digits from 0 to 9 and then recursively working
* through solving puzzle from here. If we manage to make a good assignment
* that works, we've succeeded, else we need to unassign that choice and try
* another digit. This version is easy to write, since it uses a simple
* approach (quite similar to permutations if you think about it) but it is
* not so smart because it doesn't take into account the structure of the
* puzzle constraints (for example, once the two digits for the addends have
* been assigned, there is no reason to try anything other than the correct
* digit for the sum) yet it tries a lot of useless combos regardless
*/
static boolean exhaustiveSolve(Puzzle puzzle, String lettersToAssign) {
    if (lettersToAssign.isEmpty()) // no more choices to make
        return puzzleSolved(puzzle); // checks arithmetic to see if works
    for (int digit = 0; digit <= 9; digit++) // try all digits
    {
        if (assignLetterToDigit(lettersToAssign.charAt(0), digit)) {
            if (exhaustiveSolve(puzzle, lettersToAssign.substring(1)))
                return true;
            unassignLetterFromDigit(lettersToAssign.charAt(0), digit);
        }
}
    return false; // nothing worked, need to backtrack
}
//this code is contributed by abdulaslam