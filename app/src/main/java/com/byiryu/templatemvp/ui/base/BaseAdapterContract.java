package com.byiryu.templatemvp.ui.base;

import java.util.ArrayList;

public interface BaseAdapterContract {

    interface Model{

        void addItems(ArrayList<?> items);

        void clearItem();

    }

    interface View{

        void notifyAdapter();

    }
}
