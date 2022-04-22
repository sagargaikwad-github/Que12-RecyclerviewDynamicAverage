package com.example.que12_recycleraverage;

public class ModelData {
    private String Edittext1,Edittext2,Edittext3,Textview;

    public ModelData(String edittext1, String edittext2, String edittext3,String textview) {
        Edittext1 = edittext1;
        Edittext2 = edittext2;
        Edittext3 = edittext3;
        Textview=textview;

    }

    public String getTextview() {
        return Textview;
    }

    public void setTextview(String textview) {
        Textview = textview;
    }

    public String getEdittext1() {
        return Edittext1;
    }

    public void setEdittext1(String edittext1) {
        Edittext1 = edittext1;
    }

    public String getEdittext2() {
        return Edittext2;
    }

    public void setEdittext2(String edittext2) {
        Edittext2 = edittext2;
    }

    public String getEdittext3() {
        return Edittext3;
    }

    public void setEdittext3(String edittext3) {
        Edittext3 = edittext3;
    }
}
