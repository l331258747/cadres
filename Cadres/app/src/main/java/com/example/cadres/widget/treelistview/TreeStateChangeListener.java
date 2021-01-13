package com.example.cadres.widget.treelistview;

public interface TreeStateChangeListener {
    void onOpen(TreeItem treeItem, int position);
    void onClose(TreeItem treeItem, int position);
}