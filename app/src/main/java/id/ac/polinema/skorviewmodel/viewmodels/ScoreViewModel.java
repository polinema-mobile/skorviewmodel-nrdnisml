package id.ac.polinema.skorviewmodel.viewmodels;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

import java.util.ArrayList;

import id.ac.polinema.skorviewmodel.fragments.ScoreFragmentDirections;
import id.ac.polinema.skorviewmodel.models.GoalScorer;
import id.ac.polinema.skorviewmodel.fragments.ScoreFragment;

public class ScoreViewModel extends ViewModel {
    String homeScorer;
    String awayScorer;
    private final MutableLiveData<ArrayList<GoalScorer>> homeGoalScorerList = new MutableLiveData<>(new ArrayList<GoalScorer>());
    private final MutableLiveData<ArrayList<GoalScorer>> awayGoalScorerList = new MutableLiveData<>(new ArrayList<GoalScorer>());

    public int getHomeScore(){
        return homeGoalScorerList.getValue().size();
    }

    public int getAwayScore(){
        return  awayGoalScorerList.getValue().size();
    }

    public void setGoalScorer(String team, GoalScorer goalScorer){
        if(team.equals(ScoreFragment.HOME)){
            homeGoalScorerList.getValue().add(goalScorer);
        }else{
            awayGoalScorerList.getValue().add(goalScorer);
        }
    }

    public void onAddHomeClick(View view){
        ScoreFragmentDirections.GoalScorerAction action = ScoreFragmentDirections.goalScorerAction(ScoreFragment.HOME);
        Navigation.findNavController(view).navigate(action);
    }

    public void onAddAwayClick(View view){
        ScoreFragmentDirections.GoalScorerAction action = ScoreFragmentDirections.goalScorerAction(ScoreFragment.AWAY);
        Navigation.findNavController(view).navigate(action);
    }

    public String getHomeScorer(){
        for(int i = 0; i < homeGoalScorerList.getValue().size(); i++){
            if (i == 0){
                homeScorer = homeGoalScorerList.getValue().get(i).getName()+" "+homeGoalScorerList.getValue().get(i).getMinute()+"\" ";
            }else{
                homeScorer = homeScorer + homeGoalScorerList.getValue().get(i).getName()+" "+homeGoalScorerList.getValue().get(i).getMinute()+"\" ";
            }
        }
        return homeScorer;
    }

    public String getAwayScorer(){
        for(int i = 0; i < awayGoalScorerList.getValue().size(); i++){
            if (i == 0){
                awayScorer = awayGoalScorerList.getValue().get(i).getName()+" "+awayGoalScorerList.getValue().get(i).getMinute()+"\" ";
            }else{
                awayScorer = awayScorer + awayGoalScorerList.getValue().get(i).getName()+" "+awayGoalScorerList.getValue().get(i).getMinute()+"\" ";
            }
        }
        return awayScorer;
    }
}

