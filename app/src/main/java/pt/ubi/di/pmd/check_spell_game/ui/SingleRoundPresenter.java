package pt.ubi.di.pmd.check_spell_game.ui;
import pt.ubi.di.pmd.check_spell_game.Model.Game;
import pt.ubi.di.pmd.check_spell_game.Model.GameInterface;
import pt.ubi.di.pmd.check_spell_game.Model.SingleRoundInterface;

public class SingleRoundPresenter implements SingleRoundPresenterInterface{

    SingleRoundActivityInterface view;
    GameInterface gameModel;
    SingleRoundInterface currentRound;


    SingleRoundPresenter(SingleRoundActivityInterface view){
        this.view=view;
        gameModel=new Game();
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
        currentRound=gameModel.getCurrentRound();
        view.updateWord(currentRound.getDividedWord1(),currentRound.getDividedWord2() );

    }

    public void updateScore(){
        view.updateScore(String.valueOf(gameModel.getPoints()), String.valueOf(gameModel.getLevel()));
    }

    public void checkAnswer(String playerAnswer) {
        gameModel.checkRound(playerAnswer);
        if(gameModel.isRecordBroken()){
            view.showHighScore();
        }
        updateScore();


        if(currentRound.isCompleted()){
            view.setNextButtonEnable(true);
            view.setCheckButtonEnable(false);
            view.setAnswerETenable(false);

        }
        else {
            if(currentRound.isSkippable()){
                view.setSkipButtonVisible();
            }
            view.cleanAnswerET();
        }

    }

    public void shareHighScore(){
        view.shareHighScore(gameModel.getPoints());
    }
}
