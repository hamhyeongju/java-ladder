package ladder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderGamePositionFactoryTest {

    static LadderGame ladderGame;

    @BeforeAll
    static void setLadder() {
        ladderGame = LadderPositionFactory.createLadderGame(4, 5);
    }

    @Test
    public void createLadder() throws Exception {
        //given
        ladderGame = LadderPositionFactory.createLadderGame(4, 5);

        //then
        assertEquals(4, ladderGame.getRow());
        assertEquals(5, ladderGame.getNumberOfPerson());
    }

    @Test
    public void validateLadderException() throws Exception {
        //given
        /** row > 2*/
        assertThrows(IllegalArgumentException.class, () -> LadderPositionFactory.createLadderGame(2, 5));
        /** numberOfPerson > 1*/
        assertThrows(IllegalArgumentException.class, () -> LadderPositionFactory.createLadderGame(5, 1));
    }

    @Test
    public void createPosition() throws Exception {
        //given
        Position position = LadderPositionFactory.createPosition(ladderGame, 1, 1, 2);

        //then
        assertEquals(1, position.getLeftPointXInt());
        assertEquals(1, position.getLeftPointYInt());
        assertEquals(1, position.getRightPointXInt());
        assertEquals(2, position.getRightPointYInt());
    }

    @Test
    public void validatePositionException() throws Exception {
        //when
        /** Y 좌표값이 numberOfPerson을 넘어선 안됨 */
        assertThrows(IllegalArgumentException.class,
                () -> LadderPositionFactory.createPosition(ladderGame, 10, 1, 11));

        /** X 좌표값이 row을 넘어선 안됨
         *  또한 마지막 row와 같아서도 안됨 */
        assertThrows(IllegalArgumentException.class,
                () -> LadderPositionFactory.createPosition(ladderGame, 1, 10, 2));
        assertThrows(IllegalArgumentException.class,
                () -> LadderPositionFactory.createPosition(ladderGame, 2, 5, 2));

        /** rightPoint.Y > leftPoint.Y*/
        assertThrows(IllegalArgumentException.class,
                () -> LadderPositionFactory.createPosition(ladderGame, 2, 1, 1));
        /** 두 좌표의 Y 값 차가 1이어야 함 */
        assertThrows(IllegalArgumentException.class,
                () -> LadderPositionFactory.createPosition(ladderGame, 1, 1, 3));

    }
}