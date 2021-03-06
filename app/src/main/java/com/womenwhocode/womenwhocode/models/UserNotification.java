package com.womenwhocode.womenwhocode.models;

import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseObject;

/**
 * Created by zassmin on 11/11/15.
 */
@ParseClassName("UserNotification")
public class UserNotification extends ParseObject {
    public static final String USER_ID_KEY = "user_id";
    public static final String ENABLED_KEY = "enabled";
    public static final String NOTIFICATION_KEY = "notification";

    public String getUserId() {
        return getString(USER_ID_KEY);
    }

    public void setUserId(String userId) {
        put(USER_ID_KEY, userId);
    }

    public boolean getEnabled() {
        return getBoolean(ENABLED_KEY);
    }

    public void setEnabled(boolean enabled) {
        put(ENABLED_KEY, enabled);
    }

    public Notification getNotification() {
        Notification notification = null;
        try {
            notification = this.getParseObject(NOTIFICATION_KEY).fetchIfNeeded();
        } catch (ParseException | NullPointerException e) {
            e.printStackTrace();
        }
        return notification;
    }

    public void setNotification(Notification notification) {
        put(NOTIFICATION_KEY, notification);
    }
}
