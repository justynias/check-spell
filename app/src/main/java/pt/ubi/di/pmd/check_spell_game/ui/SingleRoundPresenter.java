package pt.ubi.di.pmd.check_spell_game.ui;
import pt.ubi.di.pmd.check_spell_game.Model.Game;
import pt.ubi.di.pmd.check_spell_game.Model.SingleRound;

public class SingleRoundPresenter {

    SingleRoundActivity view;
    Game gameModel;
    SingleRound currentRound;


    SingleRoundPresenter(SingleRoundActivity view){
        this.view=view;
        gameModel=new Game();

        //Log.d("LOGGED_PLAYER", gameModel.getCurrentPlayer().getName());
       loadRound();

    }

    public void resetView(){
        view.cleanAnswerET();
        view.setAnswerETenable(true);
        view.setNextButtonEnable(false);
        view.setCheckButtonEnable(true);
        view.setSkipButtonInvisible();
    }

    public void loadRound(){

        resetView();
        gameModel.loadRound();
        currentRound=gameModel.getCurrentRoud();
        this.view.setWord1TextView(currentRound.getDividedWord1());
        this.view.setWord2TextView(currentRound.getDividedWord2());
    }

    public void updateScore(){
        view.setLevelTV(String.valueOf(gameModel.getLevel()));
        view.setPointsTV(String.valueOf(gameModel.getPoints()));

    }

    public void checkAnswer(String answer) {
        gameModel.checkRound(answer);
        updateScore();

        if(currentRound.isCompleted()){
            view.setNextButtonEnable(true);
            view.setCheckButtonEnable(false);
            view.setAnswerETenable(false);

        }
        else {
            if(currentRound.isSkipable()){
                view.setSkipButtonVisible();
            }
            view.cleanAnswerET();
        }



    }
}
