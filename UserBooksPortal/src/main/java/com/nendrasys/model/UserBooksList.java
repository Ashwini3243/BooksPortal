package com.nendrasys.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class UserBooksList {
    List<UserBooksInfo> userBooksInfos;

    public List<UserBooksInfo> getUserBooksInfos() {
        return userBooksInfos;
    }

    public void setUserBooksInfos(List<UserBooksInfo> userBooksInfos) {
        this.userBooksInfos = userBooksInfos;
    }
}
