package com.example.cadres.bean.yjjc;

import android.content.Intent;
import android.text.TextUtils;

public class YjjcVoteListBean {

    int voteId;
    int schemeId;
    String schemeName;
    int dismissCadreId;
    int baseId;

    String cadreName;
    String currentPosition;
    String currentPositionTime;
    String aspiringPosition;
    String appointPositionName;
    String dismissPositionName;

    int voteUserId;
    String voteUserName;
    String voteTime;
    int voteState;
    String voteResult;

    int myVote;

    public int getMyVote() {
        return myVote;
    }

    public void setMyVote(int myVote) {
        this.myVote = myVote;
    }

    public int getVoteId() {
        return voteId;
    }

    public int getSchemeId() {
        return schemeId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public int getDismissCadreId() {
        return dismissCadreId;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getCadreName() {
        return cadreName;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public String getCurrentPositionTime() {
        return currentPositionTime;
    }

    public String getAspiringPosition() {
        return aspiringPosition;
    }

    public String getAppointPositionName() {
        return appointPositionName;
    }

    public String getDismissPositionName() {
        return dismissPositionName;
    }

    public int getVoteUserId() {
        return voteUserId;
    }

    public String getVoteUserName() {
        return voteUserName;
    }

    public String getVoteTime() {
        return voteTime;
    }

    public int getVoteState() {
        return voteState;
    }

    public String getVoteResult() {
        return voteResult;
    }

    public int getVoteResultInt() {
        if(TextUtils.isEmpty(voteResult))
            return 0;
        int result = 0;
        try {
            result = Integer.parseInt(voteResult);
        } catch (Exception e){
            return 0;
        }

        return result;
    }
}
