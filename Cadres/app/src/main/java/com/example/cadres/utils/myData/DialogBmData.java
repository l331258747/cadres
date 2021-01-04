package com.example.cadres.utils.myData;

import com.example.cadres.bean.common.BmLeftBean;
import com.example.cadres.beanDB.DBBmBean;

import java.util.ArrayList;
import java.util.List;

public class DialogBmData {

    public DialogBmData() {
    }

    public List<BmLeftBean> getBmLeftBean(List<DBBmBean> dbBmList) {
        List<BmLeftBean> bmLeftBeans = new ArrayList<>();
        for (int i = 0; i < dbBmList.size(); i++) {
            DBBmBean dbItem = dbBmList.get(i);
            BmLeftBean item = new BmLeftBean(dbItem.getDeptId(), dbItem.getParentId(), dbItem.getDeptName(),dbItem.getDeptType(),dbItem.getSubset(), dbItem.getGetWomanCadre());
            bmLeftBeans.add(item);
        }

        //多层数据
        List<BmLeftBean> rootTrees = new ArrayList<BmLeftBean>();
        for (BmLeftBean tree : bmLeftBeans) {
            if (tree.getParentId() == 0) {
                rootTrees.add(tree);
            }
            for (BmLeftBean t : bmLeftBeans) {
                if (t.getParentId() == tree.getId()) {
                    if (tree.getLists() == null) {
                        List<BmLeftBean> myChildrens = new ArrayList<BmLeftBean>();
                        myChildrens.add(t);
                        tree.setLists(myChildrens);
                    } else {
                        tree.getLists().add(t);
                    }
                }
            }
        }
        this.bmLeftBeans = new ArrayList<>();
        sysout(rootTrees,"");
        return this.bmLeftBeans;
    }

    List<BmLeftBean> bmLeftBeans = new ArrayList<BmLeftBean>();
    public void sysout(List<BmLeftBean> trees, String str) {
        if (trees != null && trees.size() > 0) {
            for (BmLeftBean tree : trees) {
                tree.setName(str + tree.getName());
                bmLeftBeans.add(tree);
                sysout(tree.getLists(), str + "   ");
            }
        }
    }


    public List<BmLeftBean> getBmLeftBean2(List<DBBmBean> dbBmList){
        bmLeftBeans = new ArrayList<>();
        for (int i = 0; i < dbBmList.size(); i++) {
            DBBmBean dbItem = dbBmList.get(i);
            BmLeftBean item = new BmLeftBean(dbItem.getDeptId(), dbItem.getParentId(), dbItem.getDeptName(),dbItem.getDeptType(),dbItem.getSubset(),dbItem.getGetWomanCadre());
            bmLeftBeans.add(item);
        }
        return this.bmLeftBeans;
    }

}
