package com.vn.treegridproject.mvputils;

public interface View<P extends Presenter> {
    P getPresenter();
}
