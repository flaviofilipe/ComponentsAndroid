package br.com.flaviofilipe.componentsandroid.Models;

/**
 * Created by Windows 10 Pro on 04/08/2017.
 */

public class UserModel {
    private final String mName;
    private final String mCity;
    private final String mDescription;
    private int mAge;

    public UserModel(String name, String city, String description, int age) {
        mName = name;
        mCity = city;
        mDescription = description;
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public String getCity() {
        return mCity;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getAge() {
        return mAge;
    }

    public void incrementAge() {
        //Incrementa idade
        mAge++;
    }

}
