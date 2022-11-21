package com.furnituremover.entitiy;

import java.util.Objects;

public class Furniture {
    private int furnitureId;
    private String furnitureName;
    private String furnitureColor;
    private int furnitureSize;

    public Furniture() {}

    public Furniture(int furnitureId, String furnitureName, String furnitureColor, int furnitureSize) {
        this.furnitureId = furnitureId;
        this.furnitureName = furnitureName;
        this.furnitureColor = furnitureColor;
        this.furnitureSize = furnitureSize;
    }

    public int getFurnitureId() {
        return furnitureId;
    }

    public void setFurnitureId(int furnitureId) {
        this.furnitureId = furnitureId;
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public String getFurnitureColor() {
        return furnitureColor;
    }

    public void setFurnitureColor(String furnitureColor) {
        this.furnitureColor = furnitureColor;
    }

    public int getFurnitureSize() {
        return furnitureSize;
    }

    public void setFurnitureSize(int furnitureSize) {
        this.furnitureSize = furnitureSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return furnitureId == furniture.furnitureId && furnitureSize == furniture.furnitureSize && furnitureName.equals(furniture.furnitureName) && furnitureColor.equals(furniture.furnitureColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(furnitureId, furnitureName, furnitureColor, furnitureSize);
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "furnitureId=" + furnitureId +
                ", furnitureName='" + furnitureName + '\'' +
                ", furnitureColor='" + furnitureColor + '\'' +
                ", furnitureSize=" + furnitureSize +
                '}';
    }
}
