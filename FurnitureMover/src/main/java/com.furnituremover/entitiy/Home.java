package com.furnituremover.entitiy;

import java.util.Objects;

public class Home
{
    private int homeId;
    private String homeName;
    private int homeSize;

    public Home()
    {
    }

    public Home(int homeId, String homeName, int homeSize) {
        this.homeId = homeId;
        this.homeName = homeName;
        this.homeSize = homeSize;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public int getHomeSize() {
        return homeSize;
    }

    public void setHomeSize(int homeSize) {
        this.homeSize = homeSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return homeId == home.homeId && homeSize == home.homeSize && homeName.equals(home.homeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeId, homeName, homeSize);
    }

    @Override
    public String toString() {
        return "Home{" +
                "homeId=" + homeId +
                ", homeName='" + homeName + '\'' +
                ", homeSize=" + homeSize +
                '}';
    }
}
