package com.furnituremover.entitiy;

import java.util.Objects;

public class Home
{
    private int homeId;
    private int furnitureId;
    private String homeName;
    private int homeSize;

    private String furnitureName;
    private int furnitureSize;

    public Home()
    {
    }

    public Home(String homeName, int furnitureId, String furnitureName, int furnitureSize) {
        this.homeName = homeName;
        this.furnitureId = furnitureId;
        this.furnitureName = furnitureName;
        this.furnitureSize = furnitureSize;
    }

    public Home(int homeId, int furnitureId, String homeName, int homeSize) {
        this.homeId = homeId;
        this.furnitureId = furnitureId;
        this.homeName = homeName;
        this.homeSize = homeSize;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public int getFurnitureId() {
        return furnitureId;
    }

    public void setFurnitureId(int furnitureId) {
        this.furnitureId = furnitureId;
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
        return homeId == home.homeId && furnitureId == home.furnitureId && homeSize == home.homeSize && homeName.equals(home.homeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeId, furnitureId, homeName, homeSize);
    }

    @Override
    public String toString() {
        return "Home{" +
                "homeId=" + homeId +
                ", furnitureId=" + furnitureId +
                ", homeName='" + homeName + '\'' +
                ", homeSize=" + homeSize +
                '}';
    }
}
