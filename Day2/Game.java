public class Game {
    int score;

    enum SHAPE{
       A,B,C
    }

    enum MYSHAPE{
        X, Y, Z
    }

    public void play(String shape1, String shape2) {
        
        MYSHAPE s1 = MYSHAPE.valueOf(shape1);
        SHAPE s2 = SHAPE.valueOf(shape2);

        score+=(s1.ordinal() + 1);

        if (s1 == MYSHAPE.X) {
            if (s2 == SHAPE.A) {
                score += 3;
            } else if (s2 == SHAPE.B) {
                score += 0;
            } else if (s2 == SHAPE.C) {
                score += 6;
            }
        } else if (s1 == MYSHAPE.Y) {
            if (s2 == SHAPE.A) {
                score += 6;
            } else if (s2 == SHAPE.B) {
                score += 3;
            } else if (s2 == SHAPE.C) {
                score += 0;
            }
        } else if (s1 == MYSHAPE.Z) {
            if (s2 == SHAPE.A) {
                score += 0;
            } else if (s2 == SHAPE.B) {
                score += 6;
            } else if (s2 == SHAPE.C) {
                score += 3;
            }
        }
    }

    public void playWithStrategy(String outcome, String shape)
    {
        SHAPE yourShape = SHAPE.valueOf(shape);
        MYSHAPE myShape = null;

        switch(outcome)
        {
            case "X":
                myShape = MYSHAPE.values()[(yourShape.ordinal() + 2) % 3];
                break;
            case "Y":
                myShape = MYSHAPE.values()[yourShape.ordinal()];
                break;
            case "Z":
                myShape = MYSHAPE.values()[((yourShape.ordinal() + 1) % 3)] ;
                break;
        }
        play(myShape.toString(), yourShape.toString());
    }

    public int getTournamentScore() {
        return score;
    }


}
