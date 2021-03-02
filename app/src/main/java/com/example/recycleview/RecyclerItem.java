package com.example.recycleview;

import android.graphics.drawable.Drawable;

public class RecyclerItem {
    Drawable iconDrawable;
    String titleStr;
    String descStr;

    public RecyclerItem(Drawable drawable, String box, String s) {
        iconDrawable = drawable;
        titleStr = box;
        descStr = s;
    }

    //아래의 set과 get을 하는 이유는 위의 정의된 값들이 private이기 때문에 recyclerItem 내에서만 수정할 수 있기 때문입니다.
    public void setIcon(Drawable icon) {
        iconDrawable = icon;
    }

    public void setTitle(String title) {
        titleStr = title;
    }

    public void setDesc(String desc) {
        descStr = desc;
    }

    public Drawable getIcon(){
        //this를 꼭 넣어야하는가? 안 넣어도 될 것 같은데....
        return this.iconDrawable;
        //return iconDrawable;
    }

    public String getTitle(){
        return this.titleStr;
    }

    public String getDesc(){
        return this.descStr;
    }
}
