package com.example.bt2_lab_chuong3;

import android.os.Parcel;
import android.os.Parcelable;

public class Food implements Parcelable {
    private String name;
    private int imageResId;
    private String description;
    private double price;

    public Food(String name, int imageResId, String description, double price) {
        this.name = name;
        this.imageResId = imageResId;
        this.description = description;
        this.price = price;
    }

    // Constructor để đọc dữ liệu từ Parcel
    protected Food(Parcel in) {
        name = in.readString();
        imageResId = in.readInt();
        description = in.readString();
        price = in.readDouble();
    }

    // CREATOR tĩnh để tạo đối tượng từ Parcel
    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    // --- Getters ---
    public String getName() { return name; }
    public int getImageResId() { return imageResId; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }

    @Override
    public int describeContents() {
        return 0;
    }

    // Ghi dữ liệu của đối tượng vào Parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(imageResId);
        dest.writeString(description);
        dest.writeDouble(price);
    }
}
