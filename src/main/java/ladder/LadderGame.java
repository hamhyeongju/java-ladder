package ladder;

import ladder.domain.LadderRunner;
import ladder.domain.creator.LadderCreator;
import ladder.domain.wrapper.CurrentPosition;
import ladder.domain.wrapper.LadderNumber;

public class LadderGame {

    private final LadderCreator ladderCreator;

    private LadderGame(LadderCreator ladderCreator) {
        this.ladderCreator = ladderCreator;
    }

    public static LadderGame of(LadderCreator ladderCreator) {
        return new LadderGame(ladderCreator);
    }

    public int run(LadderNumber ladderNum) {
        CurrentPosition currentPosition = CurrentPosition.createCurrentPosition(ladderNum);
        LadderRunner.of(ladderCreator.getLadder()).run(currentPosition);
        return currentPosition.getY();
    }
}
