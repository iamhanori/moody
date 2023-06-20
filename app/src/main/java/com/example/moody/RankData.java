package com.example.moody;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class RankData implements Parcelable {
    private String ranking;
    private String market;
    private String name;
    private String detail;

    public RankData() {
    }

    public RankData(String market, String name) {
        this.market = market;
        this.name = name;
    }

    protected RankData(Parcel in) {
        ranking = in.readString();
        market = in.readString();
        name = in.readString();
        detail = in.readString();
    }

    public static final Creator<RankData> CREATOR = new Creator<RankData>() {
        @Override
        public RankData createFromParcel(Parcel in) {
            return new RankData(in);
        }

        @Override
        public RankData[] newArray(int size) {
            return new RankData[size];
        }
    };

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(ranking);
        dest.writeString(market);
        dest.writeString(name);
        dest.writeString(detail);
    }
}
