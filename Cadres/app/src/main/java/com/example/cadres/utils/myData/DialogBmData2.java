package com.example.cadres.utils.myData;

import com.example.cadres.beanDB.DBBmBean;
import com.example.cadres.widget.treelistview.TreeItem;

import java.util.ArrayList;
import java.util.List;

public class DialogBmData2 {

    public DialogBmData2() {
    }

    public List<TreeItem> getBmLeftBean(List<DBBmBean> dbBmList) {
        List<TreeItem> bmLeftBeans = new ArrayList<>();
        for (int i = 0; i < dbBmList.size(); i++) {
            DBBmBean dbItem = dbBmList.get(i);
            TreeItem item = new TreeItem();
            item.setId(dbItem.getDeptId());
            item.setParentId(dbItem.getParentId());
            item.setName(dbItem.getDeptName());
            item.setTitle(dbItem.getDeptName());
            item.setIdType(dbItem.getDeptType());
            item.setSubset(dbItem.getSubset());
            item.setIsNoWomen(dbItem.getGetWomanCadre());
            bmLeftBeans.add(item);
        }

        //多层数据
        List<TreeItem> rootTrees = new ArrayList<>();
        for (TreeItem tree : bmLeftBeans) {
            if (tree.getParentId() == 0) {
                rootTrees.add(tree);
            }
            for (TreeItem t : bmLeftBeans) {
                if (t.getParentId() == tree.getId()) {
                    if (tree.getChild() == null) {
                        List<TreeItem> myChildrens = new ArrayList<>();
                        myChildrens.add(t);
                        tree.setChild(myChildrens);
                    } else {
                        tree.getChild().add(t);
                    }
                }
            }
        }
        initList(rootTrees,0);

        return rootTrees;
    }

    private void initList(List<TreeItem> list, int level) {
        if (list == null || list.size() <= 0) return;
        for (TreeItem item: list) {
            item.itemLevel = level;
            if (item.child != null && item.child.size() > 0) {
                initList(item.child, level + 1);
            }
        }
    }

    public List<TreeItem> getBmLeftBean2(List<DBBmBean> dbBmList){
        List<TreeItem> bmLeftBeans = new ArrayList<>();
        for (int i = 0; i < dbBmList.size(); i++) {
            DBBmBean dbItem = dbBmList.get(i);
            TreeItem item = new TreeItem();
            item.setId(dbItem.getDeptId());
            item.setParentId(dbItem.getParentId());
            item.setName(dbItem.getDeptName());
            item.setTitle(dbItem.getDeptName());
            item.setIdType(dbItem.getDeptType());
            item.setSubset(dbItem.getSubset());
            item.setIsNoWomen(dbItem.getGetWomanCadre());
            bmLeftBeans.add(item);
        }
        return bmLeftBeans;
    }

}
